package com.nathan.arch.presentation.presenters;


import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.presentation.ui.IDVBBaseCallback;

import java.util.List;

public interface IDVBChannelFavManagerPresenter extends IDVBBasePresenter {
    /**
     * @param callback 注册回调接口，调用后可以接收回调的所有方法
     */
    void attach(Callback callback);

    interface Callback extends IDVBBaseCallback {

    }

    List<String> getAllFavTypeList();
    //TV /RADIO
    List<ChannelUnitModel> getTvChannelsByFav(int mFavIndex);
    List<ChannelUnitModel> getRadioChannelsByFav(int mFavIndex);
    boolean renameFavType(int position, String newName);

    boolean addChannelToFavType(ChannelUnitModel progInfo, int mFavIndex);
    boolean removeChannelFromFavType(ChannelUnitModel progInfo, int mFavIndex);
    List<ChannelUnitModel> getTvChannelsByFavType(int mFavIndex);
    List<ChannelUnitModel> getRadioChannelsByFavType(int mFavIndex);

}
