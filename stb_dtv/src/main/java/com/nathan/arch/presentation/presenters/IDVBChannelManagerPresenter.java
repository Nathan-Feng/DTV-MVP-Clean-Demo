package com.nathan.arch.presentation.presenters;



import com.nathan.arch.domain.model.ChannelSortTypeDModel;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.presentation.ui.IDVBBaseCallback;

import java.util.List;


/**
 * use for Live Chanel book functions
 */
public interface IDVBChannelManagerPresenter extends IDVBBasePresenter {

    /**
     * @param callback 注册回调接口，调用后可以接收回调的所有方法
     */
    void attach(Callback callback);

    interface Callback extends IDVBBaseCallback{

    }

    List<ChannelUnitModel> getAllTvProgList();
    List<ChannelUnitModel> getAllRadioProgList();
    ChannelUnitModel getChannelByShowNo(int showNo);
    ChannelUnitModel getChannelByUniqueIndex(int progIndex);
    List<String> getProgGroupList();
    boolean setProgDelFlag(ChannelUnitModel progInfo, boolean bDel);
    boolean setProgHideFlag(ChannelUnitModel progInfo, boolean bHide);
    boolean setProgLockFlag(ChannelUnitModel progInfo, boolean bLock);
    boolean setProgSortType(ChannelSortTypeDModel sort);
    ChannelSortTypeDModel getProgSortType();
}
