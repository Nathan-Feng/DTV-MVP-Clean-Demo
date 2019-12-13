package com.nathan.arch.domain.interactors.play.impl;

import com.nathan.arch.domain.interactors.play.PlayCurrentChannelInteractor;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.storage.PlayRepositoryImpl;

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
public class PlayCurrentChannelInteractorImpl implements PlayCurrentChannelInteractor {

    private Callback mCallback;
    private PlayRepositoryImpl playRepository;

    public PlayCurrentChannelInteractorImpl() {
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

    private void notifyError(String mess) {
        mCallback.showError("Nothing to welcome you with :(");
    }

    @Override
    public void playCurrentChannel() {
        //TODO
        playRepository.playCurrentChannel();
    }

    @Override
    public void playNextChannel() {
        playRepository.playNextChannel();
    }

    @Override
    public void playUpChannel() {
        playRepository.playUpChannel();
    }

    @Override
    public void playChannelByNum(int num) {
        playRepository.playChannelByNum(num);
    }

    @Override
    public void playCertainChannel(ChannelUnitModel channelUnit) {
        playRepository.playCertainChannel(channelUnit);
    }

    @Override
    public void playChannelByIndex(int index) {
        playRepository.playChannelByIndex(index);
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
    }

    @Override
    public boolean playChannelStop() {
        return playRepository.playChannelStop();
    }

    @Override
    public boolean isCurrentChannelPlaying() {
        return playRepository.isCurrentChannelPlaying();
    }

    @Override
    public void detach() {
        playRepository.detach();
        mCallback = null;
        playRepository = null;
    }
}
