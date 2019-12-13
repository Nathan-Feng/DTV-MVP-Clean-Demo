package com.nathan.arch.domain.interactors.play;


import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.ChannelUnitModel;

import java.util.List;


public interface GetPlayChannelInteractor extends Interactor {

    interface Callback extends IDVBBaseInteractorCallback {
        void showAllChannels(List<ChannelUnitModel> channelUnitModelList);
        void showAllTvChannels(List<ChannelUnitModel> channelUnitModelList);
        void showAllRadioChannels(List<ChannelUnitModel> channelUnitModelList);
    }

    void getALLChannels();
    void getAllTvChannels();
    void getAllRadioChannels();

    ChannelUnitModel getCurrentChannelInfo();
    void attach(Callback callback);
}
