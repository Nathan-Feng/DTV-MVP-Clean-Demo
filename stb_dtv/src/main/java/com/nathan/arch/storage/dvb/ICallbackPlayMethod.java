package com.nathan.arch.storage.dvb;

import com.nathan.arch.domain.model.TipMessage;

public interface ICallbackPlayMethod {

    interface callback{
        // only for notify UI
        void showTunerTipMessage(TipMessage tipMessage);
        void showTunerChannelUpdate();
        void showPasswordDialog();
        void showChannelPlayFinish();
        void showChannelPlayChange();
        void showPVRTunerNotEnough();
    }
    void detach();

}
