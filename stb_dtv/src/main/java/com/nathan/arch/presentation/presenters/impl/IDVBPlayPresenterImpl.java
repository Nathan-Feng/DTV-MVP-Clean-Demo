package com.nathan.arch.presentation.presenters.impl;

import com.nathan.arch.domain.interactors.play.EventCallbackInteractor;
import com.nathan.arch.domain.interactors.play.GetPlayChannelInteractor;
import com.nathan.arch.domain.interactors.play.GetTunerStatusInteractor;
import com.nathan.arch.domain.interactors.play.GetPlayChannelStatusInteractor;
import com.nathan.arch.domain.interactors.play.PlayCurrentChannelInteractor;
import com.nathan.arch.domain.interactors.play.impl.EventCallbackInteractorImpl;
import com.nathan.arch.domain.interactors.play.impl.GetPlayChannelInteractorImpl;
import com.nathan.arch.domain.interactors.play.impl.GetTunerStatusInteractorImpl;
import com.nathan.arch.domain.interactors.play.impl.GetPlayChannelStatusInteractorImpl;
import com.nathan.arch.domain.interactors.play.impl.PlayCurrentChannelInteractorImpl;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.model.DvbPlayerStatus;
import com.nathan.arch.domain.model.EpgInfoDModel;
import com.nathan.arch.domain.model.PlayChannelInfoDModel;
import com.nathan.arch.domain.model.TipMessage;
import com.nathan.arch.domain.model.TunerInfoDModel;
import com.nathan.arch.presentation.presenters.IDVBPlayPresenter;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.storage.tools.EmptyTool;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Nathan on 07/08/19.
 */
public class IDVBPlayPresenterImpl implements IDVBBasePresenter, IDVBPlayPresenter,
        PlayCurrentChannelInteractor.Callback , GetPlayChannelInteractor.Callback ,
        GetPlayChannelStatusInteractor.Callback, GetTunerStatusInteractor.Callback,
        EventCallbackInteractor.Callback
{

    private Callback mCallback;
//    private WeakReference<EventCallback> mEventCallback;
    private EventCallback mEventCallback;
//    private WeakReference<ChannelCallback> mChannelCallback;
    private ChannelCallback mChannelCallback;
    private PlayCurrentChannelInteractor playCurrentChannelInteractor;
    private GetPlayChannelInteractor getPlayChannelInteractor;
    private GetPlayChannelStatusInteractor playChannelStatusInteractor;
    private GetTunerStatusInteractor getTunerStatusInteractor;
    private EventCallbackInteractorImpl eventInteractor;

    public IDVBPlayPresenterImpl() {
        initInteractor();
    }

    private void initInteractor(){
        playCurrentChannelInteractor = new PlayCurrentChannelInteractorImpl();
        getPlayChannelInteractor = new GetPlayChannelInteractorImpl();
        playChannelStatusInteractor = new GetPlayChannelStatusInteractorImpl();
        getTunerStatusInteractor = new GetTunerStatusInteractorImpl();
        playCurrentChannelInteractor.attach(this);
        getPlayChannelInteractor.attach(this);
        playChannelStatusInteractor.attach(this);
        getTunerStatusInteractor.attach(this);
        eventInteractor = new EventCallbackInteractorImpl();
        eventInteractor.attach(this);
    }


   private void deInit(){
       playCurrentChannelInteractor = null;
       getPlayChannelInteractor = null;
       mCallback=null;
    }

    /**
     * &&&&&&&&&&&&&&&&&&&&&&&&&& DO Function &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
     */

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
    }

    @Override
    public void attach(EventCallback callback) {
//        this.mEventCallback = new WeakReference<>(callback);
        this.mEventCallback = callback;
    }

    @Override
    public void attach(ChannelCallback callback) {
//        this.mChannelCallback = new WeakReference<>(callback);
        this.mChannelCallback = callback;
    }

    /**
     * **************************************Play related****************************************************
     */
    @Override
    public void playCurrentChannel() {
        playCurrentChannelInteractor.playCurrentChannel();
    }

    @Override
    public void playNextChannel() {
        playCurrentChannelInteractor.playNextChannel();
    }

    @Override
    public void playUpChannel() {
        playCurrentChannelInteractor.playUpChannel();
    }

    @Override
    public void playChannelByNum(int num) {
        playCurrentChannelInteractor.playChannelByNum(num);
    }

    @Override
    public void playCertainChannel(ChannelUnitModel channelUnit) {
        playCurrentChannelInteractor.playCertainChannel(channelUnit);
    }

    @Override
    public void playChannelByIndex(int index) {
        playCurrentChannelInteractor.playChannelByIndex(index);
    }

    @Override
    public void getALLChannels() {
        getPlayChannelInteractor.getALLChannels();
    }

    /**
     * **************************************Get related****************************************************
     */
    @Override
    public void getALLTVChannels() {
        getPlayChannelInteractor.getAllTvChannels();
    }

    @Override
    public void getALLRadioChannels() {
        getPlayChannelInteractor.getAllRadioChannels();
    }

    @Override
    public ChannelUnitModel getCurrentChannelInfo() {
        return getPlayChannelInteractor.getCurrentChannelInfo();
    }

    @Override
    public void getShowChannelPlayInfo() {
       playChannelStatusInteractor.getShowChannelPlayInfo();
    }

    @Override
    public TunerInfoDModel getTunerStatus() {
        return getTunerStatusInteractor.getTunerStatus();
    }

    @Override
    public EpgInfoDModel getShowChannelPresentInfo() {
        return playChannelStatusInteractor.getShowChannelPresentInfo();
    }

    @Override
    public EpgInfoDModel getShowChannelFollowingInfo() {
        return playChannelStatusInteractor.getShowChannelFollowingInfo();
    }

    @Override
    public DvbPlayerStatus checkPlayerStatus() {
        return getTunerStatusInteractor.checkPlayerStatus();
    }

    @Override
    public boolean playChannelStop() {
        return playCurrentChannelInteractor.playChannelStop();
    }

    @Override
    public boolean isCurrentChannelPlaying() {
        return playCurrentChannelInteractor.isCurrentChannelPlaying();
    }


/**
 * &&&&&&&&&&&&&&&&&&&&&&&&&& Callback &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
 */

    /***************************************Callback**************************************************
     * **************************************List Related**************************************************
     */
    @Override
    public void showAllChannels(List<ChannelUnitModel> channelUnitModelList) {
        if (EmptyTool.isNotEmpty(mCallback)) {
                mCallback.showAllChannels(channelUnitModelList);
        }
    }

    @Override
    public void showAllTvChannels(List<ChannelUnitModel> channelUnitModelList) {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showAllTvChannels(channelUnitModelList);
        }
    }

    @Override
    public void showAllRadioChannels(List<ChannelUnitModel> channelUnitModelList) {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showAllRadioChannels(channelUnitModelList);
        }
    }


    @Override
    public void showChannelPlayInfo(PlayChannelInfoDModel playChannelInfoDModel) {
        //TODO
        if (EmptyTool.isNotEmpty(mChannelCallback)) {
            mChannelCallback.showChannelPlayInfo(playChannelInfoDModel);
        }
    }


    @Override
    public void showChannelLockPasswordDialog() {
        if (EmptyTool.isNotEmpty(mEventCallback)) {
            mEventCallback.showChannelLockPasswordDialog();
        }
    }

    @Override
    public void showTunerTipMessage(TipMessage tipMessage) {
        if (EmptyTool.isNotEmpty(mEventCallback)) {
            mEventCallback.showTunerTipMessage(tipMessage);
        }
    }

    @Override
    public void showTunerChannelUpdate() {
        if (EmptyTool.isNotEmpty(mEventCallback)) {
            mEventCallback.showTunerChannelUpdate();
        }
    }

    @Override
    public void showChannelPlayFinish() {
        if (EmptyTool.isNotEmpty(mEventCallback)) {
            mEventCallback.showChannelPlayFinish();
        }
    }

    @Override
    public void showChannelPlayChange() {
        if (EmptyTool.isNotEmpty(mEventCallback)) {
            mEventCallback.showChannelPlayChange();
        }
    }

    @Override
    public void showPVRTunerNotEnough() {
        if (EmptyTool.isNotEmpty(mEventCallback)) {
            mEventCallback.showPVRTunerNotEnough();
        }
    }


    @Override
    public void showError(String message) {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showError(message);
        }
    }

    @Override
    public void detach() {
        playCurrentChannelInteractor.detach();
        getPlayChannelInteractor.detach();
        playChannelStatusInteractor.detach();
        getTunerStatusInteractor.detach();
        deInit();
    }

    private boolean checkNullable(WeakReference<Callback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }
    private boolean checkNullableEvent(WeakReference<EventCallback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }
    private boolean checkNullableChannel(WeakReference<ChannelCallback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }
}
