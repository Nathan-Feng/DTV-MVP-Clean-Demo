package com.nathan.arch.presentation.presenters.impl;

import com.nathan.arch.domain.interactors.clock.ClockInteractor;
import com.nathan.arch.domain.interactors.clock.impl.ClockInteractorImpl;
import com.nathan.arch.domain.model.TimeDModel;
import com.nathan.arch.presentation.presenters.IDVBClockPresenter;
import com.nathan.arch.storage.tools.EmptyTool;

import java.lang.ref.WeakReference;


public class IDVBClockPresenterImpl implements IDVBClockPresenter, ClockInteractor.Callback {

    private Callback mCallback;
    private ClockInteractor interactor;
    public IDVBClockPresenterImpl(){
        interactor = new ClockInteractorImpl();
    }

    @Override
    public void showClock(TimeDModel time) {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showClock(time);
        }
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        interactor.attach(this);
    }

    @Override
    public TimeDModel getCurrentDvbClockTime() {
        return interactor.getCurrentDvbClockTime();
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(interactor)){
            interactor.detach();
            interactor = null;
            mCallback = null;
        }

    }

    private boolean checkNullable(WeakReference<Callback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }


}
