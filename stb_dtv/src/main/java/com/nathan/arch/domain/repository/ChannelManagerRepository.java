package com.nathan.arch.domain.repository;


import com.nathan.arch.domain.model.ChannelSortTypeDModel;
import com.nathan.arch.domain.model.ChannelUnitModel;

import java.util.List;

public interface ChannelManagerRepository {
    void attach(Callback callback);

    interface Callback  {
        void showError(String message);
    }

    List<ChannelUnitModel> getALLTVProgList();
    List<ChannelUnitModel> getALLRadioProgList();
    ChannelUnitModel getChannelByShowNo(int showNo);
    List<String> getProgGroupList();
    ChannelUnitModel getChannelByUniqueIndex(int progIndex);
    boolean setProgDelFlag(ChannelUnitModel progInfo,boolean bDel);
    boolean setProgHideFlag(ChannelUnitModel progInfo,boolean bHide);
    boolean setProgLockFlag(ChannelUnitModel progInfo,boolean bLock);
    boolean setProgSortType(ChannelSortTypeDModel sort);
    ChannelSortTypeDModel getProgSortType();
    void detach();
}
