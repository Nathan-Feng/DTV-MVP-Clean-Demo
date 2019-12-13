package com.nathan.arch.domain.interactors.timeshift.impl;

import com.nathan.arch.domain.interactors.timeshift.TimeShiftInteractor;
import com.nathan.arch.domain.model.PlaySpeed;
import com.nathan.arch.domain.model.TimeProgressDModel;
import com.nathan.arch.domain.repository.TimeShiftRepository;
import com.nathan.arch.storage.TimeShiftRepositoryImpl;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class TimeShiftInteractorImpl implements TimeShiftInteractor ,TimeShiftRepository.Callback{

    private Callback mCallback;
    private TimeShiftRepository timeShiftRepository;

    public TimeShiftInteractorImpl() {
        timeShiftRepository = TimeShiftRepositoryImpl.getInstance();
    }

    @Override
    public void startTimeShift() {
        timeShiftRepository.startTimeShift();
    }

    @Override
    public boolean pauseOrPlayTimeShift() {
        return timeShiftRepository.pauseOrPlayTimeShift();
    }

    @Override
    public boolean stopTimeShift() {
        return timeShiftRepository.stopTimeShift();
    }

    @Override
    public boolean timeShiftFastForward() {
        return timeShiftRepository.timeShiftFastForward();
    }

    @Override
    public boolean timeShiftFastRewind() {
        return timeShiftRepository.timeShiftFastRewind();
    }

    @Override
    public TimeProgressDModel getShowTimeShiftProgress() {
       return timeShiftRepository.getShowTimeShiftTime();
    }

    @Override
    public boolean timeshiftSeek(int second) {
        return timeShiftRepository.timeshiftSeek(second);
    }

    @Override
    public boolean getTimeShiftPauseStatus() {
        return timeShiftRepository.getTimeShiftPauseStatus();
    }


    @Override
    public void showError(String message) {
        mCallback.showError(message);
    }


    @Override
    public void showTimeShiftStorageFull() {
        mCallback.showTimeShiftStorageFull();
    }


    @Override
    public void showCurrentPlaySpeed(PlaySpeed speed) {
        mCallback.showCurrentPlaySpeed(speed);
    }

    @Override
    public void showTimeShiftPlayBOF() {
        mCallback.showTimeShiftPlayBOF();
    }

    @Override
    public void showTimeShiftPlayEOF() {
        mCallback.showTimeShiftPlayEOF();
    }

    @Override
    public void showStartTimeShiftSuccess() {
        mCallback.showStartTimeShiftSuccess();
    }

    @Override
    public void showStartTimeShiftFailed() {
        mCallback.showStartTimeShiftFailed();
    }


    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        timeShiftRepository.attach(this);
    }

    @Override
    public PlaySpeed getCurrentPlaySpeed() {
        return timeShiftRepository.getCurrentPlaySpeed();
    }

    @Override
    public boolean playTimeShift() {
        return timeShiftRepository.playTimeShift();
    }

    @Override
    public boolean pauseTimeShift() {
        return timeShiftRepository.pauseTimeShift();
    }

    @Override
    public void detach() {
        if (mCallback !=null){
            mCallback = null;
        }
        if (timeShiftRepository !=null){
            timeShiftRepository.detach();
            timeShiftRepository = null;
        }
    }
}
