package com.nathan.arch.storage.dvb;


import com.nathan.arch.domain.model.BookTypeDModel;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.model.EpgInfoDModel;

import java.util.List;

public interface ICallbackEpgMethod {

    interface Callback  {
        void showEpgBookConflict(int bookId);
    }
    void detach();
}
