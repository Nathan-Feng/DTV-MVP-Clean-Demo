package com.nathan.arch.domain.interactors.androidapi;


import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.StorageDModel;

import java.util.List;

public interface StorageManagerInteractor extends Interactor {
    interface Callback{
        void UsbListUpdate(List<StorageDModel> usbList);
        void UsbPlugIn(StorageDModel usbPlugIn);
        void UsbPlugOut(StorageDModel usbPlugOut);
    }
    StorageDModel getSdcardInfo();
    List<StorageDModel> getUsbList();

    void attach(Callback callback);
}
