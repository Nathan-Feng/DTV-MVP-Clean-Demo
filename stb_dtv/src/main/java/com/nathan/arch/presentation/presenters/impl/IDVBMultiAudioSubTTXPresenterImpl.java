package com.nathan.arch.presentation.presenters.impl;

import com.nathan.arch.domain.interactors.play.MultiAudioSubTTXInteractor;
import com.nathan.arch.domain.interactors.play.impl.MultiAudioSubTTXInteractorImpl;
import com.nathan.arch.presentation.presenters.IDVBMultiAudioSubTTXPresenter;
import com.nathan.arch.storage.tools.EmptyTool;

import java.lang.ref.WeakReference;
import java.util.Map;

public class IDVBMultiAudioSubTTXPresenterImpl implements IDVBMultiAudioSubTTXPresenter,
        MultiAudioSubTTXInteractor.Callback
{

    private Callback mCallback;
    private MultiAudioSubTTXInteractor interactor;

    public IDVBMultiAudioSubTTXPresenterImpl(){
        interactor = new MultiAudioSubTTXInteractorImpl();
    }


    @Override
    public void attach(Callback callback) {
        this.mCallback =callback;
        interactor.attach(this);
    }

    @Override
    public Map<Integer,String> getAllAudioList() {
        return interactor.getAllAudioList();
    }

    @Override
    public Map<Integer,String> getAllSubtitleList() {
        return interactor.getAllSubtitleList();
    }

    @Override
    public Map<Integer,String> getAllTTXList() {
        return interactor.getAllTTXList();
    }

    @Override
    public boolean setAudioByIndex(int audioIndex) {
       return interactor.setAudioByIndex(audioIndex);
    }

    @Override
    public boolean setSubtitleByIndex(int subtitleIndex) {
        return interactor.setSubtitleByIndex(subtitleIndex);
    }

    @Override
    public boolean setTTXByIndex(int ttxIndex) {
        return interactor.setTTXByIndex(ttxIndex);
    }

    @Override
    public int getAudioSelectIndex() {
        return interactor.getAudioSelectIndex();
    }

    @Override
    public int getSubtitleSelectIndex() {
        return interactor.getSubtitleSelectIndex();
    }

    @Override
    public int getTTXSelectIndex() {
        return interactor.getTTXSelectIndex();
    }

    @Override
    public void sendTtxKey(int code) {
        interactor.sendTtxKey(code);
    }

    @Override
    public void showError(String message) {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showError(message);
        }

    }

    @Override
    public void detach() {
        mCallback = null;
    }

    private boolean checkNullable(WeakReference<Callback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }

}
