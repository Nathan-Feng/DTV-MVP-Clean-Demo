package com.nathan.arch.storage.dvb.impl;


import com.nathan.arch.storage.dvb.ICallbackPlayMethod;
import com.nathan.arch.storage.tools.EmptyTool;


import timber.log.Timber;

/**
 * Created by Nathan on 2019/7/10
 */
public class PlayMethodFromDVB  implements ICallbackPlayMethod {
    private  ICallbackPlayMethod.callback callback;

    @Override
    public void detach() {
       callback = null;
    }

    public PlayMethodFromDVB(callback callback){
        Timber.d("Nathan PlayMethodFromDVB ");
        this.callback = callback;
        initDVB();
        subScribeListener();
        startCheckingTunerMessage();
    }

    private void initDVB() {
    }

    private void startCheckingTunerMessage(){

    }

    private void subScribeListener(){
        SubscribeListenerEventFromDVB ss=SubscribeListenerEventFromDVB.getInstance();
        ss.setOnMessagePlayCallback(new SubscribeListenerEventFromDVB.MessagePlayCallback() {
            @Override
            public void showPasswordDialog() {
                if (EmptyTool.isNotEmpty(callback)){
                    callback.showPasswordDialog();
                }
            }

            @Override
            public void showChannelPlayFinish() {
                if (EmptyTool.isNotEmpty(callback)){
                    callback.showChannelPlayFinish();
                }
            }

            @Override
            public void showChannelPlayChange() {
                if (EmptyTool.isNotEmpty(callback)){
                    callback.showChannelPlayChange();
                }
            }
        });

        ss.setOnMessageTunerCallback(new SubscribeListenerEventFromDVB.MessageTunerCallback() {
            @Override
            public void hideNoSignal() {

            }
        });
    }

}
