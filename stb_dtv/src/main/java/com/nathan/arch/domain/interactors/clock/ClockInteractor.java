package com.nathan.arch.domain.interactors.clock;


import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.TimeDModel;

public interface ClockInteractor extends Interactor {

    interface Callback extends IDVBBaseInteractorCallback {
        void showClock(TimeDModel time);
    }
    TimeDModel getCurrentDvbClockTime();
    void attach(Callback callback);
}
