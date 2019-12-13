package com.nathan.arch.presentation.presenters.impl;

import android.util.Log;


import androidx.lifecycle.LifecycleOwner;

import com.nathan.arch.domain.interactors.MainInteractor;
import com.nathan.arch.domain.interactors.impl.MainInteractorImpl;
import com.nathan.arch.presentation.presenters.IDVBMainPresenter;

import java.lang.ref.WeakReference;

/**
 * Created by Nathan on 07/08/19.
 */
public class IDVBMainPresenterImpl implements IDVBMainPresenter,
        MainInteractor.Callback  {

    private WeakReference<Callback> mCallback;
    private MainInteractor interactor;

    public IDVBMainPresenterImpl() {
        interactor = new MainInteractorImpl(this);
    }

    @Override
    public void detach() {
        deInit();
    }


    @Override
    public void onMessageRetrieved(String message) {

    }

    @Override
    public void onRetrievalFailed(String error) {
    }


    @Override
    public void onAny(LifecycleOwner owner) {
//        Log.d("Nathan"," OnLifecycleEvent onAny"+owner.getLifecycle().getCurrentState());
    }

    @Override
    public void onCreate(LifecycleOwner owner) {
        Log.d("Nathan"," OnLifecycleEvent onCreate");

    }

    @Override
    public void onStart(LifecycleOwner owner) {
        Log.d("Nathan"," OnLifecycleEvent onStart");
    }


    @Override
    public void onResume(LifecycleOwner owner) {
        Log.d("Nathan"," OnLifecycleEvent onResume");
        interactor.resume();
    }

    @Override
    public void onPause(LifecycleOwner owner) {
        Log.d("Nathan"," OnLifecycleEvent onPause");
    }

    @Override
    public void onStop(LifecycleOwner owner) {
        Log.d("Nathan"," OnLifecycleEvent onStop");
//        deInit();//when listener in Application
    }

    @Override
    public void onDestory(LifecycleOwner owner) {
        Log.d("Nathan"," OnLifecycleEvent onDestory");
        deInit();//when listener in Activity
    }


   private void deInit(){
        interactor.detach();
//       interactor=null;
       mCallback=null;
    }

    @Override
    public void attach(Callback callback) {
        mCallback = new WeakReference<>(callback);
    }
}
