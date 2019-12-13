package com.nathan.arch.storage.dvb.impl;


import com.nathan.arch.storage.dvb.ICallbackPVRMethod;
import timber.log.Timber;

/**
 * Created by Nathan on 2019/7/10
 */
public class PVRMethodFromDVB implements ICallbackPVRMethod {

    private  ICallbackPVRMethod.Callback callback;

    private static final int RECORDER_STATUS_IDLE = 0;
    private static final int RECORDER_STATUS_PREPARE = 1;
    private static final int RECORDER_STATUS_RECORDING = 2;
    private static final int RECORDER_STATUS_STOP = 3;

    public PVRMethodFromDVB(Callback callback){
        Timber.d("Nathan PlayMethodFromDVB ");
        this.callback = callback;
        initDVB();
        subScribeListener();
    }

    private void initDVB() {

    }

    private void subScribeListener(){
        SubscribeListenerEventFromDVB ss=SubscribeListenerEventFromDVB.getInstance();
        ss.setOnMessagePVRCallback(new SubscribeListenerEventFromDVB.MessagePVRCallback() {
            @Override
            public void showPVRStorageFull() {
                callback.showPVRStorageFull();
            }

            @Override
            public void showPVRStorageOut() {
                callback.showError("Recording has stopped");
            }
        });

    }



    @Override
    public boolean startPVR() {

        return false;
    }

    @Override
    public boolean stopPVR() {

        return false;
    }

    @Override
    public String getPVRName() {
        return "";
    }

    @Override
    public String getPVRTime() {

        return "00:00:00";
    }

    @Override
    public int getPVRNameID() {
        return -1;
    }

    @Override
    public void detach() {
        callback = null;
    }

}
