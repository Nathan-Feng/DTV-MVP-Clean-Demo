package com.nathan.arch.presentation.presenters.impl;

import com.nathan.arch.domain.interactors.timeshift.TimeShiftInteractor;
import com.nathan.arch.domain.interactors.timeshift.impl.TimeShiftInteractorImpl;
import com.nathan.arch.domain.model.PlaySpeed;
import com.nathan.arch.domain.model.TimeProgressDModel;
import com.nathan.arch.presentation.presenters.IDVBTimeShiftPresenter;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.storage.tools.EmptyTool;

import java.lang.ref.WeakReference;


/**
 * Created by Nathan on 07/08/19.
 */
public class IDVBTimeShiftPresenterImpl implements IDVBBasePresenter, IDVBTimeShiftPresenter,
        TimeShiftInteractor.Callback  {

//    private WeakReference<Callback> mCallback;
    private TimeShiftInteractor timeShiftInteractor;
    private Callback mCallback;

    public IDVBTimeShiftPresenterImpl() {
        initInteractor();
    }

    private void initInteractor(){
        timeShiftInteractor = new TimeShiftInteractorImpl();
    }


   private void deInit(){
        if (timeShiftInteractor != null){
            timeShiftInteractor.detach();
            timeShiftInteractor=null;
        }
       if (mCallback != null){
           mCallback=null;
       }
    }


    @Override
    public void attach(Callback callback) {
//        this.mCallback = new WeakReference<>(callback);
        this.mCallback = callback;
        timeShiftInteractor.attach(this);
    }

    @Override
    public void startTimeShift() {
        timeShiftInteractor.startTimeShift();
    }

    @Override
    public boolean pauseOrPlayTimeShift() {
       return timeShiftInteractor.pauseOrPlayTimeShift();
    }

    @Override
    public boolean stopTimeShift() {
        return timeShiftInteractor.stopTimeShift();
    }

    @Override
    public boolean fastForwardTimeShift() {
        return timeShiftInteractor.timeShiftFastForward();
    }

    @Override
    public boolean fastRewindTimeShift() {
       return timeShiftInteractor.timeShiftFastRewind();
    }

    @Override
    public TimeProgressDModel getShowTimeShiftProgress() {
       return timeShiftInteractor.getShowTimeShiftProgress();
    }

    @Override
    public boolean seekTimeShift(int second) {
       return timeShiftInteractor.timeshiftSeek(second);
    }

    @Override
    public boolean getTimeShiftPauseStatus() {
        return timeShiftInteractor.getTimeShiftPauseStatus();
    }

    @Override
    public PlaySpeed getCurrentPlaySpeed() {
        return timeShiftInteractor.getCurrentPlaySpeed();
    }

    @Override
    public boolean playTimeShift() {
        return timeShiftInteractor.playTimeShift();
    }

    @Override
    public boolean pauseTimeShift() {
        return timeShiftInteractor.pauseTimeShift();
    }


    @Override
    public void showError(String message) {
//        if (checkNullable(mCallback)) {
//            mCallback.get().showError(message);
//        }
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showError(message);
        }
    }


    @Override
    public void showCurrentPlaySpeed(PlaySpeed speed) {
//        if (checkNullable(mCallback)) {
//            mCallback.get().showCurrentPlaySpeed(speed);
//        }
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showCurrentPlaySpeed(speed);
        }
    }

    @Override
    public void showTimeShiftStorageFull() {
//        if (checkNullable(mCallback)) {
//            mCallback.get().showTimeShiftStorageFull();
//        }
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showTimeShiftStorageFull();
        }
    }

    @Override
    public void showTimeShiftPlayBOF() {
//        if (checkNullable(mCallback)) {
//            mCallback.get().showTimeShiftPlayBOF();
//        }
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showTimeShiftPlayBOF();
        }
    }

    @Override
    public void showTimeShiftPlayEOF() {
//        if (checkNullable(mCallback)) {
//            mCallback.get().showTimeShiftPlayEOF();
//        }
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showTimeShiftPlayEOF();
        }
    }

    @Override
    public void showStartTimeShiftSuccess() {
//        if (checkNullable(mCallback)) {
//            mCallback.get().showStartTimeShiftSuccess();
//        }
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showStartTimeShiftSuccess();
        }
    }

    @Override
    public void showStartTimeShiftFailed() {
//        if (checkNullable(mCallback)) {
//            mCallback.get().showStartTimeShiftFailed();
//        }
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showStartTimeShiftFailed();
        }
    }

    @Override
    public void detach() {
        deInit();
    }

    private boolean checkNullable(WeakReference<Callback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }
}
