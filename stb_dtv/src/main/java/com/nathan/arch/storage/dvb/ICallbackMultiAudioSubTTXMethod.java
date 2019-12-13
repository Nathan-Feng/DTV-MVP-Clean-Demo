package com.nathan.arch.storage.dvb;


import com.nathan.arch.domain.interactors.base.Interactor;

import java.util.Map;


public interface ICallbackMultiAudioSubTTXMethod extends Interactor {

    interface Callback {
        void showError(String message);
    }

    Map<Integer,String> getALLAudioList();

}
