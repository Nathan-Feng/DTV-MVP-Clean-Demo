package com.nathan.arch.domain.interactors.channelmanager;


import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.ChannelUnitModel;

import java.util.List;

public interface ChannelFavManagerInteractor extends Interactor {

    interface Callback extends IDVBBaseInteractorCallback {

    }

    List<String> getAllFavTypeList();
    List<ChannelUnitModel> getTvChannelsByFav(int mFavIndex);
    List<ChannelUnitModel> getRadioChannelsByFav(int mFavIndex);
    boolean renameFavType(int position, String newName);
    boolean addChannelToFavType(ChannelUnitModel progInfo, int mFavIndex);
    boolean removeChannelFromFavType(ChannelUnitModel progInfo, int mFavIndex);
    List<ChannelUnitModel> getTvChannelsByFavType(int mFavIndex);
    List<ChannelUnitModel> getRadioChannelsByFavType(int mFavIndex);
    void attach(Callback callback);
}
