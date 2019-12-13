package com.nathan.arch.presentation.presenters;


import com.nathan.arch.domain.model.PVRInfoDModel;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.presentation.ui.IDVBBaseCallback;

/**
 * For DVB PVR control
 *
 */
public interface IDVBPVRPresenter extends IDVBBasePresenter {

    void attach(Callback callback);

    interface Callback extends IDVBBaseCallback {

        /**
         * when USB or Sdcard is full ,callback this.
         */
        void showStorageFull();

        /**
         * When Timeshift or PVR , if USB plug out ,callback this.
         */
        void showPVRStorageOut();

        /**
         * when prepare search ,if only one tuner, callback this.
         */
        void showPVRTunerNotEnough();

        /**
         * when PVR recording is working ,callback this.
         */
        void showPVRIsRecording();

    }

    /**
     * start channel Recording
     */
    boolean startPVR();

    /**
     * stop channel recording
     */
    boolean stopPVR();

    /**
     * do get the channel recording info
     */
    PVRInfoDModel getPVRInfo();

}
