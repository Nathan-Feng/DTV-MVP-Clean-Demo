package com.nathan.arch.domain.interactors.play.impl;

import com.nathan.arch.domain.interactors.play.MultiAudioSubTTXInteractor;
import com.nathan.arch.domain.repository.MultiAudioSubTTXRepository;
import com.nathan.arch.storage.MultiAudioSubTTXRepositoryImpl;

import java.util.Map;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class MultiAudioSubTTXInteractorImpl implements MultiAudioSubTTXInteractor,
             MultiAudioSubTTXRepository.Callback   {

    private MultiAudioSubTTXInteractor.Callback mCallback;
    private MultiAudioSubTTXRepository mRepository;

    public MultiAudioSubTTXInteractorImpl() {
        mRepository = MultiAudioSubTTXRepositoryImpl.getInstance();
    }



    @Override
    public Map<Integer,String> getAllAudioList() {
        Map<Integer,String> audList =mRepository.getAllAudioList();
        return audList;
    }

    @Override
    public Map<Integer,String> getAllSubtitleList() {
        Map<Integer,String> subtitleList =  mRepository.getAllSubtitleList();
        return subtitleList;
    }

    @Override
    public Map<Integer,String> getAllTTXList() {
        Map<Integer,String> ttxList = mRepository.getAllTTXList();
        return ttxList;
    }

    @Override
    public boolean setAudioByIndex(int audioIndex) {
        return mRepository.setAudioByIndex(audioIndex);
    }

    @Override
    public boolean setSubtitleByIndex(int subtitleIndex) {
        return mRepository.setSubtitleByIndex(subtitleIndex);
    }

    @Override
    public boolean setTTXByIndex(int ttxIndex) {
       return mRepository.setTTXByIndex(ttxIndex);
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        mRepository.attach(this);
    }

    @Override
    public int getAudioSelectIndex() {
        return mRepository.getAudioSelectIndex();
    }

    @Override
    public int getSubtitleSelectIndex() {
        return mRepository.getSubtitleSelectIndex();
    }

    @Override
    public int getTTXSelectIndex() {
        return mRepository.getTTXSelectIndex();
    }

    @Override
    public void sendTtxKey(int code) {
        mRepository.sendTtxKey(code);
    }

    @Override
    public void showError(String message) {
        mCallback.showError(message);
    }


    @Override
    public void detach() {
        mRepository.detach();
        mRepository = null;
        mCallback = null;
    }
}
