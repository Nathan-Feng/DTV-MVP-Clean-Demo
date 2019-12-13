package com.nathan.arch.domain.repository;


import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.BookTypeDModel;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.model.EpgInfoDModel;

import java.util.List;

public interface EpgRepository extends Interactor {

    interface Callback  {
        void showEpgBookConflict(int bookId);
    }
    List<EpgInfoDModel> getEpgListByChannel(ChannelUnitModel pInfo);
    boolean epgBook(EpgInfoDModel evtInfo, BookTypeDModel type);
    boolean epgConflictBook(EpgInfoDModel evtInfo, BookTypeDModel type, int bookId);
    boolean epgCancelBook(EpgInfoDModel evtInfo);
}
