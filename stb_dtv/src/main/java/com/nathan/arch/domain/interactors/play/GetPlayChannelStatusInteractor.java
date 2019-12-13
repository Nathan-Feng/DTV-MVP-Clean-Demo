package com.nathan.arch.domain.interactors.play;


import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.EpgInfoDModel;
import com.nathan.arch.domain.model.PlayChannelInfoDModel;


public interface GetPlayChannelStatusInteractor extends Interactor {

    interface Callback extends IDVBBaseInteractorCallback {
        void showChannelPlayInfo(PlayChannelInfoDModel playChannelInfoDModel);
    }

    //Play status  related
    EpgInfoDModel getShowChannelPresentInfo();
    EpgInfoDModel getShowChannelFollowingInfo();

    void getShowChannelPlayInfo();

    void attach(Callback callback);
}
