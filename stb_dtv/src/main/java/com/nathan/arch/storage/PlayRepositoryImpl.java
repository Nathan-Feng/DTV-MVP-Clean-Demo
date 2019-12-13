package com.nathan.arch.storage;


import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.model.DvbPlayerStatus;
import com.nathan.arch.domain.model.EpgInfoDModel;
import com.nathan.arch.domain.model.PlayChannelInfoDModel;
import com.nathan.arch.domain.model.TipMessage;
import com.nathan.arch.domain.model.TunerInfoDModel;
import com.nathan.arch.domain.repository.PlayRepository;
import com.nathan.arch.storage.dvb.ICallbackPlayMethod;
import com.nathan.arch.storage.dvb.impl.PlayMethodFromDVB;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.List;

import timber.log.Timber;

/**
 * Created by Nathan on 2019/7/10
 */
public class PlayRepositoryImpl implements PlayRepository , ICallbackPlayMethod.callback {

    @Override
    public void detach() {
        if (mPlayMethodFromDVB != null){
            mPlayMethodFromDVB.detach();
            mPlayMethodFromDVB = null;
        }
        if (callbackUIEvent != null){
            callbackUIEvent = null;
        }
        if (callbackPlayStatus != null){
            callbackPlayStatus = null;
        }
        instance = null;
    }

    /**
     * set this class to Singleton
     */
    private static PlayRepositoryImpl instance = null;
    public static PlayRepositoryImpl getInstance(){
        if (EmptyTool.isEmpty(instance)){
            instance = new PlayRepositoryImpl();
        }
        return instance;
    }

    private ICallbackPlayMethod mPlayMethodFromDVB;

    private PlayRepository.CallbackUIEvent callbackUIEvent;
    private PlayRepository.CallbackPlayStatus callbackPlayStatus;

    private static final String FORMAT = "%02d:%02d";


    private PlayRepositoryImpl(){
        Timber.d("Nathan PlayMethodFromDVB ");
        initPlayDVB();
    }

    private void initPlayDVB() {
        mPlayMethodFromDVB = new PlayMethodFromDVB(this);
    }


    @Override
    public void setCallbackUIEvent(PlayRepository.CallbackUIEvent callbackUIEvent){
        this.callbackUIEvent = callbackUIEvent;
    }

    @Override
    public void setCallbackPlayStatus(PlayRepository.CallbackPlayStatus callbackPlayStatus){
        this.callbackPlayStatus = callbackPlayStatus;
    }


    @Override
    public void playCurrentChannel() {

    }

    @Override
    public void playNextChannel() {

    }

    @Override
    public void playUpChannel() {

    }

    @Override
    public void playChannelByNum(int num) {
        if (EmptyTool.isNotEmpty(callbackUIEvent)) callbackUIEvent.showChannelPlayFinish();
    }

    @Override
    public void playChannelByIndex(int index) {

    }

    @Override
    public void resetCurrentPlayChannel(int type, int group, int subgroup, int progno) {

    }

    @Override
    public void playCertainChannel(ChannelUnitModel channelUnit) {

    }

    @Override
    public List<ChannelUnitModel> getAllTvChannels() {
        return null;
    }

    @Override
    public List<ChannelUnitModel> getAllRadioChannels() {
        return null;
    }

    @Override
    public ChannelUnitModel getCurrentChannelInfo() {
        return null;
    }


    @Override
    public EpgInfoDModel getShowChannelPresentInfo() {
        return null;
    }

    @Override
    public EpgInfoDModel getShowChannelFollowingInfo() {
        return null;
    }


    @Override
    public PlayChannelInfoDModel getShowChannelPlayInfo() {
        PlayChannelInfoDModel playChannelInfoDModel = new PlayChannelInfoDModel();
        return playChannelInfoDModel;
    }

    @Override
    public TunerInfoDModel getTunerStatus() {
        TunerInfoDModel infoDModel = new TunerInfoDModel();
        return infoDModel;
    }

    @Override
    public DvbPlayerStatus checkPlayerStatus() {
        return null;
    }

    @Override
    public boolean playChannelStop() {
        return false;
    }

    @Override
    public boolean isCurrentChannelPlaying() {
        return false;
    }


    /**
     * ************************************ Callback from ICallbackPlayMethod **********************************************
     */

    @Override
    public void showTunerTipMessage(TipMessage tipMessage) {
        if (EmptyTool.isNotEmpty(callbackUIEvent)) callbackUIEvent.showTunerTipMessage(tipMessage);
    }

    @Override
    public void showTunerChannelUpdate() {
        if (EmptyTool.isNotEmpty(callbackUIEvent)) callbackUIEvent.showTunerChannelUpdate();
    }

    @Override
    public void showPasswordDialog() {
        if (EmptyTool.isNotEmpty(callbackUIEvent)) callbackUIEvent.showPasswordDialog();
    }

    @Override
    public void showChannelPlayFinish() {
        if (EmptyTool.isNotEmpty(callbackUIEvent)) callbackUIEvent.showChannelPlayFinish();
    }

    @Override
    public void showChannelPlayChange() {
        if (EmptyTool.isNotEmpty(callbackUIEvent)) callbackUIEvent.showChannelPlayChange();
    }

    @Override
    public void showPVRTunerNotEnough() {
        if (EmptyTool.isNotEmpty(callbackUIEvent)) callbackUIEvent.showPVRTunerNotEnough();
    }


}
