package com.nathan.arch.domain.interactors.timeshift;


import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.PlaySpeed;
import com.nathan.arch.domain.model.TimeProgressDModel;


public interface TimeShiftInteractor extends Interactor {

    interface Callback extends IDVBBaseInteractorCallback {

        void showTimeShiftStorageFull();

        void showCurrentPlaySpeed(PlaySpeed speed);

        void showTimeShiftPlayBOF();

        void showTimeShiftPlayEOF();

        void showStartTimeShiftSuccess();

        void showStartTimeShiftFailed();

    }

    void startTimeShift();

    boolean pauseOrPlayTimeShift();

    boolean stopTimeShift();

    boolean timeShiftFastForward();

    boolean timeShiftFastRewind();

    TimeProgressDModel getShowTimeShiftProgress();

    boolean timeshiftSeek(int second);

    boolean getTimeShiftPauseStatus();

    void attach(Callback callback);

    PlaySpeed getCurrentPlaySpeed();

    boolean playTimeShift();
    boolean pauseTimeShift();
}
