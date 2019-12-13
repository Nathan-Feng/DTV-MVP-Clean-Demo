package com.nathan.arch.domain.repository;


import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.model.DvbPlayerStatus;
import com.nathan.arch.domain.model.EpgInfoDModel;
import com.nathan.arch.domain.model.PlayChannelInfoDModel;
import com.nathan.arch.domain.model.TipMessage;
import com.nathan.arch.domain.model.TunerInfoDModel;

import java.util.List;

/**
 * A repository that is responsible for getting our welcome message.
 */
public interface PlayRepository extends Interactor {

    void setCallbackPlayStatus(CallbackPlayStatus mCallbackPlayStatus);
    void setCallbackUIEvent(CallbackUIEvent mCallbackUIEvent);

    interface CallbackPlayStatus{
        void showChannelPlayInfo(PlayChannelInfoDModel mPlayChannelInfoDModel);
    }


    interface CallbackUIEvent{
        // only for notify UI
        void showTunerTipMessage(TipMessage tipMessage);
        void showTunerChannelUpdate();
        void showPasswordDialog();
        void showChannelPlayFinish();
        void showChannelPlayChange();
        void showPVRTunerNotEnough();
    }

    //Play related
    void playCurrentChannel();
    void playNextChannel();
    void playUpChannel();
    void playChannelByNum(int num);
    void playCertainChannel(ChannelUnitModel progInfo);
    void playChannelByIndex(int index);
    void resetCurrentPlayChannel(int type,int group,int subgroup,int progno);

    //List Related
    List<ChannelUnitModel> getAllTvChannels();
    List<ChannelUnitModel> getAllRadioChannels();
    ChannelUnitModel getCurrentChannelInfo();


    //Play status  related
    EpgInfoDModel getShowChannelPresentInfo();
    EpgInfoDModel getShowChannelFollowingInfo();
    PlayChannelInfoDModel getShowChannelPlayInfo();
    TunerInfoDModel getTunerStatus();
    DvbPlayerStatus checkPlayerStatus();
    boolean playChannelStop();
    boolean isCurrentChannelPlaying();
}
