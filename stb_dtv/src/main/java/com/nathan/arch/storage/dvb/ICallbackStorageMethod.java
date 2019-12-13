package com.nathan.arch.storage.dvb;

public interface ICallbackStorageMethod {

    void storageSdcardDeviceMount();

    void storageUSBMountDisk(String devName,String mountName);
    void storageUSBUnMountDisk(String devName,String mountName);
}
