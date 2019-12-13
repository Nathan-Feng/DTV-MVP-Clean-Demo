package com.nathan.arch.storage;

import com.nathan.arch.domain.model.TimeProgressDModel;
import com.nathan.arch.domain.repository.TimeShiftRepository;
import com.nathan.arch.storage.dvb.ICallbackTimeShiftMethod;
import com.nathan.arch.storage.dvb.impl.TimeShiftMethodFromDVB;

import timber.log.Timber;

/**
 * Created by Nathan on 1/29/16.
 */
public abstract class TimeShiftRepositoryImpl implements TimeShiftRepository ,
        ICallbackTimeShiftMethod.Callback
{

    @Override
    public void detach() {
        if (timeShiftMethodFromDVB != null){
            timeShiftMethodFromDVB.detach();
        }
        if (callback != null){
            callback = null;
        }
        INSTANCE = null;
    }

    /**
     * set this class to Singleton
     */
    private static TimeShiftRepositoryImpl INSTANCE = null;
    public static TimeShiftRepositoryImpl getInstance(){
        return INSTANCE;
    }

    private ICallbackTimeShiftMethod timeShiftMethodFromDVB ;
    private TimeShiftRepository.Callback callback;


    private TimeShiftRepositoryImpl(){
        Timber.d("Nathan new TimeShiftRepositoryImpl :callback");
        initTimeShiftDVB();
    }

    private void initTimeShiftDVB() {
        timeShiftMethodFromDVB= new TimeShiftMethodFromDVB(this);
    }


    @Override
    public void attach(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void startTimeShift() {

    }

    @Override
    public boolean pauseOrPlayTimeShift() {
        return false;
    }

    @Override
    public boolean stopTimeShift() {
        return false;
    }

    @Override
    public boolean timeShiftFastForward() {
        return false;
    }

    @Override
    public boolean timeShiftFastRewind() {
        return false;
    }

    @Override
    public TimeProgressDModel getShowTimeShiftTime() {
        return null;
    }

    @Override
    public boolean timeshiftSeek(int second) {
        return false;
    }

    @Override
    public boolean getTimeShiftPauseStatus() {
        return false;
    }

    @Override
    public boolean playTimeShift() {
        return false;
    }

}
