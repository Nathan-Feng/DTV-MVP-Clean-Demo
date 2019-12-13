package com.nathan.arch.storage.dvb.impl;

import com.nathan.arch.storage.dvb.ICallbackTimeShiftMethod;
import com.nathan.arch.storage.model.TimeProgressSModel;
import com.nathan.arch.storage.model.TimeSModel;

import timber.log.Timber;


/**
 * Created by Nathan on 2019/7/10
 */
public class TimeShiftMethodFromDVB implements ICallbackTimeShiftMethod {

    private TimeProgressSModel mTimeProgressSModel = new TimeProgressSModel();
    private TimeSModel mTimeSModel = new TimeSModel();
    private boolean isChannelLock = false;
    private  ICallbackTimeShiftMethod.Callback callback;

    public TimeShiftMethodFromDVB(Callback callback){
        Timber.d("Nathan PlayMethodFromDVB ");
        this.callback = callback;
        initDVB();
        subScribeListener();
    }

    private void initDVB() {

    }

    private void subScribeListener(){
        SubscribeListenerEventFromDVB ss=SubscribeListenerEventFromDVB.getInstance();
        ss.setOnMessageTimeShiftCallback(new SubscribeListenerEventFromDVB.MessageTimeShiftCallback() {
            @Override
            public void showTimeShiftStorageFull() {
                callback.showTimeShiftStorageFull();
            }

            @Override
            public void showTimeShiftPlayBOF() {
                callback.showTimeShiftPlayBOF();
            }

            @Override
            public void showTimeShiftPlayEOF() {
                callback.showTimeShiftPlayEOF();
            }
        });

    }


    @Override
    public void detach() {
        callback = null;
    }


}
