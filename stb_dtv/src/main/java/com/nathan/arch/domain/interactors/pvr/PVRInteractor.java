package com.nathan.arch.domain.interactors.pvr;


import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.PVRInfoDModel;


public interface PVRInteractor extends Interactor {

    interface Callback extends IDVBBaseInteractorCallback {

        void showPVRStorageFull();

        void showPVRIsRecording();
    }

    boolean startPVR();

    boolean stopPVR();

    PVRInfoDModel getPVRInfo();

    void attach(Callback callback);
}
