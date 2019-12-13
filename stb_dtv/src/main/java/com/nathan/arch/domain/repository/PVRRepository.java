package com.nathan.arch.domain.repository;


import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.PVRInfoDModel;

/**
 * A repository that is responsible for getting our welcome message.
 */
public interface PVRRepository extends Interactor {
    void attach(Callback callback);
    interface Callback  {
        void showError(String message);

        void showPVRStorageFull();

        void showPVRIsRecording();

    }

    boolean startPVR();

    boolean stopPVR();

    PVRInfoDModel getPVRInfo();
}
