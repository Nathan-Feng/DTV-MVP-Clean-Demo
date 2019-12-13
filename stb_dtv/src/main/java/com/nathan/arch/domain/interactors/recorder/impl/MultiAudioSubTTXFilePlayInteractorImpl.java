package com.nathan.arch.domain.interactors.recorder.impl;

import com.nathan.arch.domain.interactors.play.MultiAudioSubTTXInteractor;
import com.nathan.arch.domain.repository.MultiAudioSubTTXRepository;
import com.nathan.arch.storage.MultiAudioSubTTXRecorderRepositoryImpl;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.Map;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class MultiAudioSubTTXFilePlayInteractorImpl implements MultiAudioSubTTXInteractor,
             MultiAudioSubTTXRepository.Callback   {

    private Callback mCallback;
    private MultiAudioSubTTXRecorderRepositoryImpl mRepository;

    public MultiAudioSubTTXFilePlayInteractorImpl() {
        mRepository = MultiAudioSubTTXRecorderRepositoryImpl.getInstance();

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
        this.mCallback =callback;
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
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showError(message);
        }

    }


    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(mRepository)){
            mRepository.detach();
            mRepository = null;
            mCallback = null;
        }
    }
}
