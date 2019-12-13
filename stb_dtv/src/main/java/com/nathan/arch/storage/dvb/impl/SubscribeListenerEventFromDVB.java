package com.nathan.arch.storage.dvb.impl;

import com.nathan.arch.storage.model.TimeSModel;
import com.nathan.arch.storage.tools.EmptyTool;

public class SubscribeListenerEventFromDVB {

    private TimeSModel mTimeSModel = new TimeSModel();


    private MessagePlayCallback mPlayCallback;
    private MessageTunerCallback mTunerCallback;
    private MessageTimeShiftCallback mTimeShiftCallback;
    private MessagePVRCallback mPVRCallback;
    private MessageRecorderCallback mRecorderCallback;
    private MessageClockCallback clockCallback;
    private MessageBookMonitorCallback bookCallback;

    public interface MessagePlayCallback{
        void showPasswordDialog();
        void showChannelPlayFinish();
        void showChannelPlayChange();
    }

    public interface MessageTunerCallback{
        void hideNoSignal();
    }

    public interface MessageTimeShiftCallback{
        void showTimeShiftStorageFull();
        void showTimeShiftPlayBOF();
        void showTimeShiftPlayEOF();
    }

    public interface MessagePVRCallback{
        void showPVRStorageFull();
        void showPVRStorageOut();
    }


    public interface MessageRecorderCallback{
        void filePlayEnd();
        void filePlayStartOK();
        void filePlayStartFailed();
        void showRecorderPlayBOF();
    }

    public interface MessageClockCallback{
        void showClock(TimeSModel timeSModel);
    }

    public interface MessageBookMonitorCallback {
        void showBookRecAlarm();//60s count down
        void showBookRecStart();
        void showBookPlayAlarm();//60s count down
    }

    public void setOnMessageBookMonitorCallback(MessageBookMonitorCallback bookCallback){
        this.bookCallback = bookCallback;
    }

    public  void setOnMessagePlayCallback(MessagePlayCallback callback){
        this.mPlayCallback=callback;
    }
    public  void setOnMessageTunerCallback(MessageTunerCallback callback){
        this.mTunerCallback=callback;
    }
    public  void setOnMessageTimeShiftCallback(MessageTimeShiftCallback callback){
        this.mTimeShiftCallback=callback;
    }
    public  void setOnMessagePVRCallback(MessagePVRCallback callback){
        this.mPVRCallback=callback;
    }
    public void setOnMessageRecorderCallback(MessageRecorderCallback mRecorderCallback){
        this.mRecorderCallback = mRecorderCallback;
    }

    public void setOnMessageClockCallback(MessageClockCallback clockCallback){
        this.clockCallback = clockCallback;
    }

    /**
     * set this class to Singleton
     */
    private static  SubscribeListenerEventFromDVB instance = null;
    public static SubscribeListenerEventFromDVB getInstance(){
        if (EmptyTool.isEmpty(instance)){
            instance = new SubscribeListenerEventFromDVB();
        }
        return instance;
    }
    private SubscribeListenerEventFromDVB(){

    }




    private void showTime(int utcdate, int utcsecond){

    }


    public void detach(){
        if (EmptyTool.isNotEmpty(mPlayCallback)){
            mPlayCallback = null;
            mTunerCallback = null;
            mTimeShiftCallback = null;
            mPVRCallback = null;
            mRecorderCallback = null;
            clockCallback = null;
            bookCallback = null;
            instance = null;
        }
    }

}
