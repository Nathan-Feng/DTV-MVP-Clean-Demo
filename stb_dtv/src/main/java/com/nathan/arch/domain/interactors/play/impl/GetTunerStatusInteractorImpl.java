package com.nathan.arch.domain.interactors.play.impl;

import com.nathan.arch.domain.interactors.play.GetTunerStatusInteractor;
import com.nathan.arch.domain.model.DvbPlayerStatus;
import com.nathan.arch.domain.model.TunerInfoDModel;
import com.nathan.arch.domain.repository.PlayRepository;
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
public class GetTunerStatusInteractorImpl implements GetTunerStatusInteractor{

    private Callback mCallback;
    private PlayRepository playRepository;

    public GetTunerStatusInteractorImpl() {
        playRepository = PlayRepositoryImpl.getInstance();
    }

    private void notifyError(String mess) {
        mCallback.showError("Nothing to welcome you with :(");
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
    public TunerInfoDModel getTunerStatus() {
        //TODO
        TunerInfoDModel model = playRepository.getTunerStatus();
        return model;
    }

    @Override
    public DvbPlayerStatus checkPlayerStatus() {
        return playRepository.checkPlayerStatus();
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
    }


    @Override
    public void detach() {
        playRepository.detach();
        playRepository = null;
        mCallback = null;
    }
}
