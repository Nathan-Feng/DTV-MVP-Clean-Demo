package com.nathan.arch.domain.interactors.play.impl;

import com.nathan.arch.domain.interactors.play.EventCallbackInteractor;
import com.nathan.arch.domain.model.TipMessage;
import com.nathan.arch.domain.repository.PlayRepository;
import com.nathan.arch.storage.PlayRepositoryImpl;
import com.nathan.arch.storage.tools.EmptyTool;

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
public class EventCallbackInteractorImpl implements EventCallbackInteractor,
        PlayRepository.CallbackUIEvent {

    private Callback mCallback;
    private PlayRepositoryImpl playRepository;

    public EventCallbackInteractorImpl() {
        playRepository = PlayRepositoryImpl.getInstance();
    }

    private void notifyError(String mess) {

    }



    public void execute() {//run()
        Timber.d("Nathan execute");
        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                Timber.d("Nathan onSubscribe");
                // retrieve the message
                String message = "" ;
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
    public void showTunerTipMessage(TipMessage tipMessage) {
        //TODO
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showTunerTipMessage(tipMessage);
        }

    }

    @Override
    public void showTunerChannelUpdate() {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showTunerChannelUpdate();
        }

    }

    @Override
    public void showPasswordDialog() {
        //TODO
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showChannelLockPasswordDialog();
        }

    }

    @Override
    public void showChannelPlayFinish() {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showChannelPlayFinish();
        }

    }

    @Override
    public void showChannelPlayChange() {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showChannelPlayChange();
        }

    }

    @Override
    public void showPVRTunerNotEnough() {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showPVRTunerNotEnough();
        }
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        playRepository.setCallbackUIEvent(this);
    }

    @Override
    public void detach() {
        playRepository.detach();
        playRepository = null;
        mCallback = null;
    }
}
