package com.nathan.arch.storage.dvb;


import com.nathan.arch.storage.model.TimeProgressSModel;

public interface ICallbackTimeShiftMethod {

    interface Callback{
        void showError(String message);

        void showStartTimeShiftSuccess();
        void showStartTimeShiftFailed();
        void showTimeShiftStorageFull();

        void showCurrentPlaySpeed(int speed);
        void showTimeShiftPlayBOF();
        void showTimeShiftPlayEOF();
    }

    void detach();
}
