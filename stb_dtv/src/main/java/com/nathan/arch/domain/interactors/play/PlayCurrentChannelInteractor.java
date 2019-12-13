package com.nathan.arch.domain.interactors.play;


import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.model.TipMessage;


public interface PlayCurrentChannelInteractor extends Interactor {

    interface Callback extends IDVBBaseInteractorCallback {
        // only for notify UI
        void showTunerTipMessage(TipMessage tipMessage);
        void showTunerChannelUpdate();
    }

    void playCurrentChannel();
    void playNextChannel();
    void playUpChannel();
    void playChannelByNum(int num);
    void playCertainChannel(ChannelUnitModel channelUnit);
    void playChannelByIndex(int index);
    void attach(Callback callback);
    boolean playChannelStop();
    boolean isCurrentChannelPlaying();
}
