package com.nathan.arch.domain.interactors.play;


import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;

import java.util.Map;


public interface MultiAudioSubTTXInteractor extends Interactor {

    interface Callback extends IDVBBaseInteractorCallback {
    }

    Map<Integer,String> getAllAudioList();

    Map<Integer,String> getAllSubtitleList();

    Map<Integer,String> getAllTTXList();

    boolean setAudioByIndex(int audioIndex);

    boolean setSubtitleByIndex(int subtitleIndex);

    boolean setTTXByIndex(int ttxIndex);

    void attach(Callback callback);

    int getAudioSelectIndex();
    int getSubtitleSelectIndex();
    int getTTXSelectIndex();
    void sendTtxKey(int code);
}
