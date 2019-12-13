package com.nathan.arch.presentation.presenters;


import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.model.DvbPlayerStatus;
import com.nathan.arch.domain.model.EpgInfoDModel;
import com.nathan.arch.domain.model.PlayChannelInfoDModel;
import com.nathan.arch.domain.model.TipMessage;
import com.nathan.arch.domain.model.TunerInfoDModel;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.presentation.ui.IDVBBaseCallback;

import java.util.List;

/**
 * For DVB Live Play control
 * Not include Timeshift & PVR etc.
 * 直播所有动作接口
 * @author Nathan
 */
public interface IDVBPlayPresenter  extends IDVBBasePresenter {

    /**
     * * @param callback 用于注册回调，接收回调消息
     */
    void attach(Callback callback);
    void attach(EventCallback callback);
    void attach(ChannelCallback callback);

    interface Callback extends IDVBBaseCallback {
        /**
         * 回调所有直播节目列表，
         * @param channelUnitModelList callback all the channels from DB
         */
        // List Related
        void showAllChannels(List<ChannelUnitModel> channelUnitModelList);
        void showAllTvChannels(List<ChannelUnitModel> channelUnitModelList);
        void showAllRadioChannels(List<ChannelUnitModel> channelUnitModelList);

    }

    interface EventCallback extends IDVBBaseCallback {
        /**
         * 当播放加扰节目时，回调此接口
         * when play the lock channel ,callback this .
         */
        void showChannelLockPasswordDialog();

        /**
         * 回调tuner相关状态信息
         * @param tipMessage callback some tip messge ,see TipMessage
         */
        void showTunerTipMessage(TipMessage tipMessage);

        /**
         * 当前拼点节目更新时，回调此接口
         * when Current Freq channels update, callback this.
         */
        void showTunerChannelUpdate();

        /**
         * when channel switch ,current channel will be finished,so callback this.
         */
        void showChannelPlayFinish();

        /**
         * when channel switch , next channel will be playing, so call back this.
         */
        void showChannelPlayChange();

        /**
         * when channel switch ,not having enough tuner to play,so callback this to request tuner alloc
         */
        void showPVRTunerNotEnough();
    }

    interface ChannelCallback extends IDVBBaseCallback {
        /**
         * 节目信息相关的回调
         * @param playChannelInfoDModel
         */
        void showChannelPlayInfo(PlayChannelInfoDModel playChannelInfoDModel);
    }



    /**
     * Play the Current channel in DB
     */
    void playCurrentChannel();

    /**
     * 播放下一个节目
     * Play the next channel : channel down
     */
    void playNextChannel();

    /**
     * 播放上一个节目
     * Play the up channel: channel up
     */
    void playUpChannel();

    /**
     * 根据num来播放指定节目
     * @param num Play the channel by channel Num
     */
    void playChannelByNum(int num);

    /**
     * @param channelUnit 根据某个节目来进行播放
     */
    void playCertainChannel(ChannelUnitModel channelUnit);

    /**
     * @param index 根据progIndex来播放某个节目
     */
    void playChannelByIndex(int index);


    void getALLChannels();
    /**
     * 获取所有直播TV视频节目列表
     * do get ALL the TV channels in DB
     */
    void getALLTVChannels();

    /**
     * 获取所有直播广播节目列表
     * do get ALL the Radio channels in DB
     */
    void getALLRadioChannels();

    /**
     * do get the current Playing channel Info
     * callback void showCurrentChannelInfo(ChannelUnitModel channelUnitModel);
     * @return
     */
    ChannelUnitModel getCurrentChannelInfo();

    /**
     * do get the Playing channel info
     * callback void showChannelPlayInfo(PlayChannelInfoDModel mPlayChannelInfoDModel);
     */
    void getShowChannelPlayInfo();

    /**
     * do get Tuner info ,such as SSI/SQI
     * Callback void showTunerStatus(TunerInfoDModel tunerInfoDModel);
     * @return 信号强度，质量，误码率
     */
    TunerInfoDModel getTunerStatus();

    /**
     * 获取
     * @return 获取Now / next信息
     */
    EpgInfoDModel getShowChannelPresentInfo();

    /**
     * 获取
     * @return Next 信息
     */
    EpgInfoDModel getShowChannelFollowingInfo();

    /**
     * @return 获取当前播放器的状态，直播/时移/PVR等
     */
    DvbPlayerStatus checkPlayerStatus();

    boolean playChannelStop();

    boolean isCurrentChannelPlaying();
}
