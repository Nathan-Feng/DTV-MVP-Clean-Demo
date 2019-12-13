package com.nathan.arch.domain.interactors.androidapi.impl;

import com.nathan.arch.domain.interactors.androidapi.StorageManagerInteractor;
import com.nathan.arch.domain.model.StorageDModel;
import com.nathan.arch.domain.repository.StorageManagerRepository;
import com.nathan.arch.storage.androidapi.StorageManagerRepositoryImpl;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.List;

public class StorageManagerInteractorImpl implements StorageManagerInteractor,StorageManagerRepository.Callback {

    private StorageManagerRepository mRepository;
    private Callback mCallback;

    public StorageManagerInteractorImpl(){
        mRepository = StorageManagerRepositoryImpl.getInstance();
    }


    @Override
    public StorageDModel getSdcardInfo() {
        return mRepository.getSdcardInfo();
    }

    @Override
    public List<StorageDModel> getUsbList() {
        return mRepository.getUsbList();
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        mRepository.setOnUsbListUpdateCallbackListener(this);
    }


    @Override
    public void UsbListUpdate(List<StorageDModel> usbList) {
        if (mCallback != null) {
            mCallback.UsbListUpdate(usbList);
        }
    }

    @Override
    public void UsbPlugIn(StorageDModel usbPlugIn) {
        if (mCallback != null) {
            mCallback.UsbPlugIn(usbPlugIn);
        }
    }

    @Override
    public void UsbPlugOut(StorageDModel usbPlugOut) {
        if (mCallback != null) {
            mCallback.UsbPlugOut(usbPlugOut);
        }
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(mRepository)){
            mRepository.detach();
            mRepository = null;
            mCallback = null;
        }

    }
}
