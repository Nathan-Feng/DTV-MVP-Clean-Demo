package com.nathan.arch.domain.interactors.epg;


import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.BookTypeDModel;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.model.EpgInfoDModel;

import java.util.List;

public interface EpgInteractor extends Interactor {
    void attach(Callback callback);
    interface Callback  {
        void showEpgBookConflict(int bookId);
    }
    List<EpgInfoDModel> getEpgListByChannel(ChannelUnitModel pInfo);
    boolean epgBook(EpgInfoDModel evtInfo, BookTypeDModel type);
    boolean epgConflictBook(EpgInfoDModel evtInfo, BookTypeDModel type, int bookId);
    boolean epgCancelBook(EpgInfoDModel evtInfo);
}
