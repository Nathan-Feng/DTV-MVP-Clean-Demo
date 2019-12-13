package com.nathan.arch.domain.interactors.clock.impl;

import com.nathan.arch.domain.interactors.clock.ClockInteractor;
import com.nathan.arch.domain.model.TimeDModel;
import com.nathan.arch.domain.repository.ClockRepository;
import com.nathan.arch.storage.ClockRepositoryImpl;
import com.nathan.arch.storage.tools.EmptyTool;

public class ClockInteractorImpl implements ClockInteractor ,ClockRepository.Callback{
    private Callback mCallback;
    private ClockRepository repository;
    private TimeDModel currentTime = new TimeDModel();

    public ClockInteractorImpl(){
        repository = ClockRepositoryImpl.getInstance();
    }


    @Override
    public void showClock(TimeDModel time) {
        currentTime = time;
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showClock(time);
        }

    }

    @Override
    public TimeDModel getCurrentDvbClockTime() {
        return repository.getCurrentDvbClockTime();
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        repository.attach(this);
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(repository)){
            repository.detach();
            repository = null;
            mCallback = null;
        }
    }
}
