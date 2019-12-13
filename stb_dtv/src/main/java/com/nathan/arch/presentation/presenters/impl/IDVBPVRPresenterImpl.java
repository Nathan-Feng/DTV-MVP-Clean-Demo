package com.nathan.arch.presentation.presenters.impl;

import com.nathan.arch.domain.interactors.pvr.PVRInteractor;
import com.nathan.arch.domain.interactors.pvr.impl.PVRInteractorImpl;
import com.nathan.arch.domain.model.PVRInfoDModel;
import com.nathan.arch.presentation.presenters.IDVBPVRPresenter;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.storage.tools.EmptyTool;

import java.lang.ref.WeakReference;

/**
 * Created by Nathan on 07/08/19.
 */
public class IDVBPVRPresenterImpl implements IDVBBasePresenter, IDVBPVRPresenter,
        PVRInteractor.Callback  {

    private Callback mCallback;
    private PVRInteractor interactor;

    public IDVBPVRPresenterImpl() {
        interactor = new PVRInteractorImpl();
    }



    private void deInit(){
        if (EmptyTool.isNotEmpty(interactor)){
            interactor.detach();
            interactor = null;
            mCallback = null;
        }
    }


    @Override
    public void attach(Callback callback) {
        mCallback = callback;
        interactor.attach(this);
    }

    @Override
    public boolean startPVR() {
        return interactor.startPVR();
    }

    @Override
    public boolean stopPVR() {
        return interactor.stopPVR();
    }

    @Override
    public PVRInfoDModel getPVRInfo() {
        return interactor.getPVRInfo();
    }

    @Override
    public void showError(String message) {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showError(message);
        }
    }

    @Override
    public void showPVRStorageFull() {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showStorageFull();
        }
    }

    @Override
    public void showPVRIsRecording() {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showPVRIsRecording();
        }
    }


    @Override
    public void detach() {
        deInit();
    }

    private boolean checkNullable(WeakReference<Callback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }
}
