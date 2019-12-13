package com.nathan.arch.presentation.presenters;


import com.nathan.arch.domain.model.StorageDModel;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;

import java.util.List;

public interface IDVBStorageManagerPresenter extends IDVBBasePresenter {
    interface Callback{
        void UsbListUpdate(List<StorageDModel> usbList);
        void UsbPlugIn(StorageDModel usbPlugIn);
        void UsbPlugOut(StorageDModel usbPlugOut);
    }
    StorageDModel getSdcardInfo();
    List<StorageDModel> getUsbList();

    void attach(Callback callback);
}
