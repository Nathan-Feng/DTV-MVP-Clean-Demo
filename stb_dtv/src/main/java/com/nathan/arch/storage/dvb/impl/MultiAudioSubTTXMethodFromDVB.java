package com.nathan.arch.storage.dvb.impl;

import com.nathan.arch.storage.dvb.ICallbackMultiAudioSubTTXMethod;
import java.util.Map;

import timber.log.Timber;

public class MultiAudioSubTTXMethodFromDVB implements ICallbackMultiAudioSubTTXMethod {
    private Callback callback;

    public MultiAudioSubTTXMethodFromDVB(Callback callback){
        Timber.d("Nathan MultiAudioSubTTXMethodFromDVB ");
        this.callback = callback;
        initDVB();
    }

    private void initDVB() {
    }

    @Override
    public Map<Integer,String> getALLAudioList() {
        return null;
    }


    @Override
    public void detach() {

    }
}
