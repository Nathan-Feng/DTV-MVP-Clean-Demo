package com.nathan.arch.domain.repository;


import com.nathan.arch.domain.model.TimeDModel;

public interface ClockRepository {
    void attach(Callback callback);

    interface Callback  {
        void showClock(TimeDModel time);
    }
    TimeDModel getCurrentDvbClockTime();
    void detach();
}
