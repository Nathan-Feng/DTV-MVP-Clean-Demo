package com.nathan.arch.domain.interactors.channelmanager;


import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.ChannelSortTypeDModel;
import com.nathan.arch.domain.model.ChannelUnitModel;

import java.util.List;

public interface ChannelManagerInteractor extends Interactor {

    interface Callback extends IDVBBaseInteractorCallback{

    }

    List<ChannelUnitModel> getAllTvProgList();
    List<ChannelUnitModel> getAllRadioProgList();
    ChannelUnitModel getChannelByShowNo(int showNo);
    List<String> getProgGroupList();
    ChannelUnitModel getChannelByUniqueIndex(int progIndex);
    boolean setProgDelFlag(ChannelUnitModel progInfo, boolean bDel);
    boolean setProgHideFlag(ChannelUnitModel progInfo, boolean bHide);
    boolean setProgLockFlag(ChannelUnitModel progInfo, boolean bLock);
    boolean setProgSortType(ChannelSortTypeDModel sort);
    ChannelSortTypeDModel getProgSortType();
    void attach(Callback callback);
}
