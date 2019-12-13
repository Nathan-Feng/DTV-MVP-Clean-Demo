package com.nathan.arch.domain.interactors.play.impl;

import com.nathan.arch.domain.interactors.play.GetPlayChannelInteractor;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.repository.PlayRepository;
import com.nathan.arch.storage.PlayRepositoryImpl;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class GetPlayChannelInteractorImpl implements GetPlayChannelInteractor {

    private Callback mCallback;
    private PlayRepository playRepository;

    public GetPlayChannelInteractorImpl() {
        playRepository = PlayRepositoryImpl.getInstance();
    }


    public void execute() {//run()
        Timber.d("Nathan execute");
        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                Timber.d("Nathan onSubscribe");
                // retrieve the message
                String message = "";
                // check if we have failed to retrieve our message

                if (message == null || message.length() == 0) {
                    // notify the failure on the main thread
                    emitter.onError(new Throwable("Nothing to welcome you"));
                }else {
                    emitter.onNext(message);
                    emitter.onComplete();
                }
            }
        });
        Observer observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Timber.d("Nathan onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Timber.d("Nathan onNext "+s);
                // we have retrieved our message, notify the UI on the main thread
                //postMessage(s);
            }

            @Override
            public void onError(Throwable e) {
                Timber.d("Nathan onError "+e.getMessage());
                notifyError(e.getMessage());
            }

            @Override
            public void onComplete() {
                Timber.d("Nathan onComplete ");
            }
        };

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        Timber.d("Nathan end ");
    }


    @Override
    public void getALLChannels() {
        //TODO
        List<ChannelUnitModel> listTv = playRepository.getAllTvChannels();
        List<ChannelUnitModel> listRadio = playRepository.getAllRadioChannels();
        if (EmptyTool.isNotEmpty(listRadio)){
            if (EmptyTool.isNotEmpty(listTv)){
                listTv.addAll(listRadio);
            }
            showALLChannels(listTv);
        }else {
            showALLChannels(listRadio);
        }
    }

    @Override
    public void getAllTvChannels() {
        //TODO
        List<ChannelUnitModel> listTv = playRepository.getAllTvChannels();
        showAllTvChannels(listTv);
    }

    @Override
    public void getAllRadioChannels() {
        //TODO
        List<ChannelUnitModel> list =playRepository.getAllRadioChannels();
        showAllRadioChannels(list);
    }
    @Override
    public ChannelUnitModel getCurrentChannelInfo() {
        //TODO
        return playRepository.getCurrentChannelInfo();
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
    }

    private void showALLChannels(List<ChannelUnitModel> channelUnitModelList){
        mCallback.showAllChannels(channelUnitModelList);
    }
    private void showAllRadioChannels(List<ChannelUnitModel> channelUnitModelList){
        mCallback.showAllRadioChannels(channelUnitModelList);
    }
    private void showAllTvChannels(List<ChannelUnitModel> channelUnitModelList){
        mCallback.showAllTvChannels(channelUnitModelList);
    }

    private void notifyError(String mess) {
        mCallback.showError(mess);
    }

    @Override
    public void detach() {
        playRepository.detach();
        playRepository = null;
        mCallback = null;
    }
}
