package com.nathan.arch.domain.repository;


import com.nathan.arch.domain.interactors.base.Interactor;

import java.util.Map;


public interface MultiAudioSubTTXRepository extends Interactor {

    void attach(Callback callback);

    interface Callback {
        void showError(String message);
    }

    Map<Integer,String> getAllAudioList();

    Map<Integer,String> getAllSubtitleList();

    Map<Integer,String> getAllTTXList();

    boolean setAudioByIndex(int audioIndex);

    boolean setSubtitleByIndex(int subtitleIndex);

    boolean setTTXByIndex(int ttxIndex);

    int getAudioSelectIndex();
    int getSubtitleSelectIndex();
    int getTTXSelectIndex();
    void sendTtxKey(int code);
}
