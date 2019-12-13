package com.nathan.arch.storage.dvb.impl;

import com.nathan.arch.storage.dvb.ICallbackEpgMethod;
import com.nathan.arch.storage.tools.EmptyTool;
import java.util.concurrent.TimeUnit;


public class EpgMethodFromDVB implements ICallbackEpgMethod {

    private static final long DAY_SECOND = TimeUnit.DAYS.toSeconds(1);
    private Callback mCallback;


    public EpgMethodFromDVB(Callback callback){
        this.mCallback = callback;
    }


    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback = null;
        }
    }
}
