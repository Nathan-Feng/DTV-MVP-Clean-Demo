package com.nathan.arch.storage.dvb.impl;


import com.nathan.arch.storage.dvb.ICallbackStorageMethod;


public class StorageManagerMethodFromDVB implements ICallbackStorageMethod {

    private static final int TYPE_USB = 1;

    public StorageManagerMethodFromDVB(){
        initDVB();
    }

    private void initDVB() {

    }

    @Override
    public void storageSdcardDeviceMount() {

    }

    @Override
    public void storageUSBMountDisk(String devName, String mountName) {
        storageMountDisk(TYPE_USB, devName, mountName);
    }

    @Override
    public void storageUSBUnMountDisk(String devName, String mountName) {
        storageUnMountDisk(TYPE_USB, devName, mountName);
    }


    private void storageMountDisk(int type, String devName,String mountName) {

    }

    private void storageUnMountDisk(int type, String devName,String mountName) {

    }
}
