package com.nathan.arch.presentation.presenters.impl;

import com.nathan.arch.domain.interactors.androidapi.StorageManagerInteractor;
import com.nathan.arch.domain.interactors.androidapi.impl.StorageManagerInteractorImpl;
import com.nathan.arch.domain.model.StorageDModel;
import com.nathan.arch.presentation.presenters.IDVBStorageManagerPresenter;
import com.nathan.arch.storage.tools.EmptyTool;

import java.lang.ref.WeakReference;
import java.util.List;

public class IDVBStorageManagerPresenterImpl implements IDVBStorageManagerPresenter,
        StorageManagerInteractor.Callback {

    private Callback  mCallback;
    private StorageManagerInteractor mInteractor;
    public IDVBStorageManagerPresenterImpl(){
        mInteractor= new StorageManagerInteractorImpl();
    }

    @Override
    public StorageDModel getSdcardInfo() {
        return null;
    }

    @Override
    public List<StorageDModel> getUsbList() {
        return null;
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        mInteractor.attach(this);
    }

    @Override
    public void UsbListUpdate(List<StorageDModel> usbList) {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.UsbListUpdate(usbList);
        }
    }

    @Override
    public void UsbPlugIn(StorageDModel usbPlugIn) {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.UsbPlugIn(usbPlugIn);
        }
    }

    @Override
    public void UsbPlugOut(StorageDModel usbPlugOut) {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.UsbPlugOut(usbPlugOut);
        }
    }

    private boolean checkNullable(WeakReference<Callback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(mInteractor)){
            mCallback = null;
            mInteractor.detach();
            mInteractor = null;
        }
    }
}
