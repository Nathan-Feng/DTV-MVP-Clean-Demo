package com.nathan.arch.storage.dvb;


public interface ICallbackPVRMethod {

    interface Callback  {
        void showError(String message);

        void showPVRStorageFull();

        void showPVRIsRecording();

    }

    boolean startPVR();

    boolean stopPVR();

    String getPVRName();
    String getPVRTime();
    int getPVRNameID();
    void detach();
}
