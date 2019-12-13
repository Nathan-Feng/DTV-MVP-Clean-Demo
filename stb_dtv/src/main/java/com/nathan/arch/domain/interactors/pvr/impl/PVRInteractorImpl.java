package com.nathan.arch.domain.interactors.pvr.impl;

import com.nathan.arch.domain.interactors.pvr.PVRInteractor;
import com.nathan.arch.domain.model.PVRInfoDModel;
import com.nathan.arch.domain.repository.PVRRepository;
import com.nathan.arch.storage.PVRRepositoryImpl;
import com.nathan.arch.storage.tools.EmptyTool;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class PVRInteractorImpl implements PVRInteractor,PVRRepository.Callback{

    private Callback mCallback;
    private PVRRepository pvrRepository;

    public PVRInteractorImpl() {
        pvrRepository = PVRRepositoryImpl.getInstance();
    }


    @Override
    public boolean startPVR() {
        return pvrRepository.startPVR();
    }

    @Override
    public boolean stopPVR() {
        return pvrRepository.stopPVR();
    }

    @Override
    public PVRInfoDModel getPVRInfo() {
        return pvrRepository.getPVRInfo();
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        pvrRepository.attach(this);
    }

    @Override
    public void showError(String message) {
        mCallback.showError(message);
    }

    @Override
    public void showPVRStorageFull() {
        mCallback.showPVRStorageFull();
    }

    @Override
    public void showPVRIsRecording() {
        mCallback.showPVRIsRecording();
    }



    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(pvrRepository)){
            pvrRepository.detach();
            pvrRepository = null;
            mCallback = null;
        }
    }
}
