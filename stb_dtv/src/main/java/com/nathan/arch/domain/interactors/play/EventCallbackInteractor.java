package com.nathan.arch.domain.interactors.play;


import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.TipMessage;


public interface EventCallbackInteractor extends Interactor {

    interface Callback extends IDVBBaseInteractorCallback {
        /**
         * when play the lock channel ,callback this .
         */
        // EventCallback
        void showChannelLockPasswordDialog();

        /**
         * @param tipMessage callback some tip messge ,see TipMessage
         */
        void showTunerTipMessage(TipMessage tipMessage);

        /**
         * when Current Freq channels update, callback this.
         */
        void showTunerChannelUpdate();

        void showChannelPlayFinish();
        void showChannelPlayChange();

        void showPVRTunerNotEnough();
    }
    void attach(Callback callback);
}
