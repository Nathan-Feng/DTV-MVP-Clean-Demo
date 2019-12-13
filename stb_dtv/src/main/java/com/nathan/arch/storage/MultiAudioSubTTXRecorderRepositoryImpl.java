package com.nathan.arch.storage;


import com.nathan.arch.domain.repository.MultiAudioSubTTXRepository;
import com.nathan.arch.storage.dvb.impl.MultiAudioSubTTXMethodForFilePlayFromDVB;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.Map;

public class MultiAudioSubTTXRecorderRepositoryImpl implements MultiAudioSubTTXRepository ,
        MultiAudioSubTTXMethodForFilePlayFromDVB.Callback{
    private static MultiAudioSubTTXRecorderRepositoryImpl ourInstance = null;

    public static MultiAudioSubTTXRecorderRepositoryImpl getInstance() {
        if (EmptyTool.isEmpty(ourInstance)){
            ourInstance = new MultiAudioSubTTXRecorderRepositoryImpl();
        }
        return ourInstance;
    }

    private Callback callback;
    private MultiAudioSubTTXMethodForFilePlayFromDVB methodFromDVB;

    private MultiAudioSubTTXRecorderRepositoryImpl() {
        methodFromDVB= MultiAudioSubTTXMethodForFilePlayFromDVB.getInstance();
    }


    @Override
    public void attach(Callback mCallback) {
        this.callback =mCallback;
    }

    @Override
    public Map<Integer,String> getAllAudioList() {
        return methodFromDVB.getALLAudioList();
    }

    @Override
    public Map<Integer,String> getAllSubtitleList() {
        return null;
    }

    @Override
    public Map<Integer,String> getAllTTXList() {
        return null;
    }

    @Override
    public boolean setAudioByIndex(int audioIndex) {
        return false;
    }

    @Override
    public boolean setSubtitleByIndex(int subtitleIndex) {
        return false;
    }

    @Override
    public boolean setTTXByIndex(int ttxIndex) {
        return false;
    }

    @Override
    public int getAudioSelectIndex() {
        return 0;
    }

    @Override
    public int getSubtitleSelectIndex() {
        return 0;
    }

    @Override
    public int getTTXSelectIndex() {
        return 0;
    }

    @Override
    public void sendTtxKey(int code) {
    }


    @Override
    public void showError(String message) {
        if (EmptyTool.isNotEmpty(callback)) callback.showError(message);
    }


    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(methodFromDVB)){
            methodFromDVB.detach();
            methodFromDVB = null;
            callback = null;
            ourInstance = null;
        }
    }
}
