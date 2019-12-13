package com.nathan.arch.domain.repository;


import com.nathan.arch.domain.model.StorageDModel;

import java.util.List;

public interface StorageManagerRepository {
    void setOnUsbListUpdateCallbackListener(Callback callback);
    interface Callback{
        void UsbListUpdate(List<StorageDModel> usbList);
        void UsbPlugIn(StorageDModel usbPlugIn);
        void UsbPlugOut(StorageDModel usbPlugOut);
    }
    StorageDModel getSdcardInfo();
    List<StorageDModel> getUsbList();

    void detach();
}
