package com.nathan.arch.domain.interactors.play;


import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.DvbPlayerStatus;
import com.nathan.arch.domain.model.TunerInfoDModel;


public interface GetTunerStatusInteractor extends Interactor {

    interface Callback extends IDVBBaseInteractorCallback {

    }
    //tuner related
    TunerInfoDModel getTunerStatus();

    DvbPlayerStatus checkPlayerStatus();
    void attach(Callback callback);
}
