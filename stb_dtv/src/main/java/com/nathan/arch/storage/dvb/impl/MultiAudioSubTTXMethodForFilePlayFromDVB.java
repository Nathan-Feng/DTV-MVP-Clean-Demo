package com.nathan.arch.storage.dvb.impl;

import com.nathan.arch.storage.dvb.ICallbackMultiAudioSubTTXMethod;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.Map;

import timber.log.Timber;

public class MultiAudioSubTTXMethodForFilePlayFromDVB implements ICallbackMultiAudioSubTTXMethod {
    private Callback callback;

    /**
     * set this class to Singleton
     */
    private static MultiAudioSubTTXMethodForFilePlayFromDVB instance = null;
    public static synchronized MultiAudioSubTTXMethodForFilePlayFromDVB getInstance(){
        if (instance == null){
            instance=new MultiAudioSubTTXMethodForFilePlayFromDVB();
        }
        return instance;
    }
    private MultiAudioSubTTXMethodForFilePlayFromDVB(){
        Timber.d("Nathan MultiAudioSubTTXMethodFromDVB ");
        this.callback = callback;
        initDVB();
    }

    private void initDVB() {

    }


    @Override
    public Map<Integer,String> getALLAudioList() {
        callback.showError("No Audio List ");
        return null;
    }


    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(instance)){
            instance = null;
            callback = null;
        }
    }
}
