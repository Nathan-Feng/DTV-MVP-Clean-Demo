package com.nathan.arch.domain.interactors.impl;

import com.nathan.arch.domain.interactors.MainInteractor;
import com.nathan.arch.domain.repository.MainRepository;
import com.nathan.arch.storage.MainRepositoryImpl;

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
public class MainInteractorImpl implements MainInteractor {

    private MainInteractor.Callback mCallback;
    private MainRepository mMainRepository;

    public MainInteractorImpl(Callback callback) {
        mCallback = callback;
        mMainRepository = MainRepositoryImpl.getInstance();
        if (mMainRepository == null){
            Timber.d("Nathan mMainRepository == null");
        }
    }

    private void notifyError() {
        mCallback.onRetrievalFailed("Nothing to welcome you with :(");
    }

    private void postMessage(final String msg) {
        mCallback.onMessageRetrieved(msg);
    }

    @Override
    public void resume() {
        mMainRepository.resume();
    }

    public void execute() {//run()
        Timber.d("Nathan execute");
        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                Timber.d("Nathan onSubscribe");
                // retrieve the message

                String message = "test";
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
                postMessage(s);
            }

            @Override
            public void onError(Throwable e) {
                Timber.d("Nathan onError "+e.getMessage());
                notifyError();
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
    public void detach() {
        mMainRepository.detach();
    }
}
