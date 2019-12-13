package com.nathan.arch.domain.interactors;


import com.nathan.arch.domain.interactors.base.Interactor;


public interface MainInteractor extends Interactor {

    interface Callback {
        void onMessageRetrieved(String message);

        void onRetrievalFailed(String error);
    }

    void resume();
}
