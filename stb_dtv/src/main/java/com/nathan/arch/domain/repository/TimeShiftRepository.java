package com.nathan.arch.domain.repository;


import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.PlaySpeed;
import com.nathan.arch.domain.model.TimeProgressDModel;

/**
 * A repository that is responsible for getting our welcome message.
 */
public interface TimeShiftRepository extends Interactor {
    void attach(Callback callback);
    interface Callback{
        void showError(String message);

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

    TimeProgressDModel getShowTimeShiftTime();

    boolean timeshiftSeek(int second);
    boolean getTimeShiftPauseStatus();

    boolean playTimeShift();
    boolean pauseTimeShift();
    PlaySpeed getCurrentPlaySpeed();
}
