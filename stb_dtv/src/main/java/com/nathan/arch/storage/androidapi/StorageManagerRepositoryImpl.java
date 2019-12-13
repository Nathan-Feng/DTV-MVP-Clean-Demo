package com.nathan.arch.storage.androidapi;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Environment;
import android.os.Handler;
import android.os.storage.StorageManager;
import android.util.Log;

import com.nathan.arch.domain.model.StorageDModel;
import com.nathan.arch.domain.repository.StorageManagerRepository;
import com.nathan.arch.storage.dvb.ICallbackStorageMethod;
import com.nathan.arch.storage.dvb.impl.StorageManagerMethodFromDVB;
import com.nathan.arch.storage.tools.EmptyTool;

import java.io.File;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nathan
 */
public class StorageManagerRepositoryImpl implements StorageManagerRepository {

    private static final int TYPE_SDCARD = 0;
    private static final int TYPE_USB = 1;
    private Context mContext;
//    private List<DiskInfo> mDiskList = null;
    private StorageReceiver mRecevier = null;
    private String SDCARD_PATH;
    private Map<String,String> mUsbMaps = new IdentityHashMap<>(16);
    List<StorageDModel> mUsbList = new ArrayList<>();
    private Callback mCallback;
    private ICallbackStorageMethod method;
    private String usbPath;

//    public interface Callback{
//        void UsbListUpdate(List<StorageDModel> usbList);
//    }

    @Override
    public void setOnUsbListUpdateCallbackListener(Callback callback){
        this.mCallback = callback;
    }

    private static StorageManagerRepositoryImpl mService = null;
    public static synchronized StorageManagerRepositoryImpl getInstance(Context context){
        if (mService == null){
            mService = new StorageManagerRepositoryImpl(context.getApplicationContext());
        }
        return mService;
    }
    public static StorageManagerRepositoryImpl getInstance(){
        return mService;
    }
    private StorageManagerRepositoryImpl(Context context){
        this.mContext = context;
        method = new StorageManagerMethodFromDVB();
//        mDiskList = new ArrayList<>();
        mRecevier = new StorageReceiver();
        storageRegister(mContext);
        storageCheckDiskInfo(mContext);
        mountSdcard();
    }

    private void mountSdcard(){
        method.storageSdcardDeviceMount();
    }

    private void storageRegister(Context context){
        //register attach event
        IntentFilter filter = new IntentFilter();
        filter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED);
        filter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED);
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY-1);
        context.registerReceiver(mRecevier,filter);

        //register mount event to  get file's path;
        IntentFilter filter1 = new IntentFilter();
        filter1.addAction(Intent.ACTION_MEDIA_MOUNTED);
        filter1.addAction(Intent.ACTION_MEDIA_UNMOUNTED);
        filter1.addAction(Intent.ACTION_MEDIA_EJECT);
        filter1.addAction(Intent.ACTION_MEDIA_REMOVED);

        filter1.addDataScheme("file");
        filter1.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY-1);
        context.registerReceiver(mRecevier,filter1);
    }



//    private class DiskInfo{
//        public String name;
//        public String diskId;
//        public List<DiskPartition> diskPartitions = new ArrayList<>();
//    }
//    private class DiskPartition{
//        public String name;
//        public String partitionId;
//        public String diskId;
//        public long totalSize;
//        public long avlableSize;
//        public String path;
//    }

    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mUsbMaps.clear();
            storageCheckDiskInfo(mContext);
            getSdcardPath();
        }
    };

    private void recheckStorage(){
        mUsbMaps.clear();
        storageCheckDiskInfo(mContext);
        getSdcardPath();
    }


    private class StorageReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String path = "";
            Log.i("Nathan","Nathan onReceive action :"+action);
            if (action!= null && action.contains(UsbManager.ACTION_USB_DEVICE_ATTACHED)){
                UsbDevice usbDevice = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
//                Log.i("Nathan","Nathan onReceive getDeviceName :"
//                        +usbDevice.getDeviceName());
//                if (Build.VERSION.SDK_INT >= 23){
//                    Log.i("Nathan","Nathan onReceive getDeviceName :"
//                            +usbDevice.getDeviceName()
//                            +"getManufacturerName "
//                            +usbDevice.getManufacturerName()
//                            +"getProductName "
//                            +usbDevice.getProductName()
//                            +"getSerialNumber "
//                            +usbDevice.getSerialNumber()
//                            +"getVersion "
//                            +usbDevice.getVersion());
//                }
            }
            if (action!= null && action.contains(Intent.ACTION_MEDIA_MOUNTED)){
                Log.i("Nathan","Nathan onReceive path :"+intent.getData().getPath());
                path = intent.getData().getPath();
                usbPath = path;
//                mHandler.postDelayed(mRunnable,1);
                recheckStorage();
                sendUsbPlugInCallback();
                method.storageUSBMountDisk(path,path);
            }else if (action!= null && action.contains(Intent.ACTION_MEDIA_EJECT)){
                Log.i("Nathan","Nathan onReceive path :"+intent.getData().getPath());
                path = intent.getData().getPath();
                usbPath = path;
                sendUsbPlugOutCallback();
                recheckStorage();
//                mHandler.postDelayed(mRunnable,1);
                method.storageUSBUnMountDisk(path,path);
            }
        }
    }


    private void storageCheckDiskInfo(Context context){
        StorageManager manager = (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
        Class<?> volumeInfoClazz = null;
        Method getBestVolumeDescription = null;
        Method isMountedReadable = null;
        Method getType = null;
        Method getVolumes = null;
        Method getPath = null;
        List<?> volumes = null;
        try {
            volumeInfoClazz = Class.forName("android.os.storage.VolumeInfo");
            getBestVolumeDescription = StorageManager.class.
                    getMethod("getBestVolumeDescription",volumeInfoClazz);
            getVolumes = StorageManager.class.getMethod("getVolumes");
            isMountedReadable = volumeInfoClazz.getMethod("isMountedReadable");
            getType = volumeInfoClazz.getMethod("getType");
            getPath = volumeInfoClazz.getMethod("getPath");
            volumes = (List<?>) getVolumes.invoke(manager);
            for (Object vol : volumes){
                File path = (File) getPath.invoke(vol);
                String storageName = (String) getBestVolumeDescription.invoke(manager,vol);
                String storagePath = path.getPath();
                Log.i("Nathan","Nathan storageName:"+storageName+ " storagePath:"+storagePath);
                if (!("/storage/emulated".equals(storagePath) || "/data".equals(storagePath))){
                    Log.i("Nathan","!storagePath.contains");
                    mUsbMaps.put(storageName,storagePath);
                    method.storageUSBUnMountDisk(storagePath,storagePath);
                }
            }
            if (!mUsbMaps.isEmpty()){
                List<StorageDModel> modelList = convertUsbInfoList(mUsbMaps);
                if (mCallback != null) {
                    mCallback.UsbListUpdate(modelList);
                }
            } else {
                if (mCallback != null) {
                    mCallback.UsbListUpdate(null);
                }
            }
        }catch (Exception ex){
            Log.i("Nathan","Nathan failed to get DiskInfo "+ex.toString());
            ex.printStackTrace();
        }
    }


    private String getSdcardPath(){
        String sdPath = Environment.getExternalStorageDirectory().getPath();
        Log.i("Nathan","Nathan StorageCheckSdcard "+sdPath);
        return sdPath;
    }

    private String getFileSize(long length){
        String fileSize = "";
        DecimalFormat format = new DecimalFormat("#.##");

        if (0 ==(length / 1024)){
            float size = (float) length;
            fileSize = format.format(size) + "B";
        } else if (0 == (length / 1024 * 1024)){
            float size = (float) length/1024;
            fileSize = format.format(size) + "K";
        } else if (0 == (length / 1024 * 1024 *1024)){
            float size = (float) length/(1024*1024);
            fileSize = format.format(size) + "M";
        } else {
            float size = (float) length/(1024*1024*1024);
            fileSize = format.format(size) + "G";
        }
        return fileSize;

    }

    private String getTotalVolumes(String path){
        File file = new File(path);
        if (null != file && file.isDirectory()){
            return getFileSize(file.getTotalSpace());
        }
        return "0";
    }
    private String getFreeVolumes(String path){
        File file = new File(path);
        if (null != file && file.isDirectory()){
            return getFileSize(file.getFreeSpace());
        }
        return "0";
    }

    private List<StorageDModel> convertUsbInfoList(Map<String,String> mMaps){
        if (mMaps.isEmpty()){
            return null;
        }
        mUsbList.clear();
        for (Map.Entry<String,String> entry :mMaps.entrySet()){
            StorageDModel model = new StorageDModel();
            model.setName(entry.getKey());
            model.setPath(entry.getValue());
            model.setFreeVolumes(getFreeVolumes(entry.getValue()));
            model.setTotalVolumes(getTotalVolumes(entry.getValue()));
            mUsbList.add(model);
        }
        return mUsbList;
    }

    private void sendUsbPlugInCallback(){
        StorageDModel item =  checkUsbPlugStatus(mUsbList,usbPath);
        if (item != null){
            mCallback.UsbPlugIn(item);
        }
    }

    private void sendUsbPlugOutCallback(){
        StorageDModel item =  checkUsbPlugStatus(mUsbList,usbPath);
        if (item != null){
            mCallback.UsbPlugOut(item);
        }
    }


    private StorageDModel checkUsbPlugStatus(List<StorageDModel> usbList,String path){
        if (EmptyTool.isNotEmpty(usbList)){
            for (StorageDModel item:usbList){
                if (item.getPath().contains(path)){
                    return item;
                }
            }
        }
        return null;
    }



    @Override
    public StorageDModel getSdcardInfo(){
        StorageDModel model = new StorageDModel();
        model.setName("SDCARD");
        String path =getSdcardPath();
        model.setPath(path);
        model.setFreeVolumes(getFreeVolumes(path));
        model.setTotalVolumes(getTotalVolumes(path));
        return model;
    }

    @Override
    public List<StorageDModel> getUsbList(){
        return mUsbList;
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(mService)){
            mHandler.removeCallbacks(mRunnable);
            mContext.unregisterReceiver(mRecevier);
            mCallback = null;
            mContext = null;
            mService = null;
        }
    }


}
