package com.nathan.arch.storage.dvb.impl;

import com.nathan.arch.storage.dvb.ICallbackRecorderMethod;
import com.nathan.arch.storage.tools.EmptyTool;

public class RecorderMethodFromDVB implements ICallbackRecorderMethod {

    private Callback callback;

    public RecorderMethodFromDVB(Callback callback){
        this.callback = callback;
        initDVB();
        subScribeListener();
    }

    private void initDVB() {

    }

    private void subScribeListener(){
        SubscribeListenerEventFromDVB ss=SubscribeListenerEventFromDVB.getInstance();
        ss.setOnMessageRecorderCallback(new SubscribeListenerEventFromDVB.MessageRecorderCallback() {
            @Override
            public void filePlayEnd() {
                callback.showFilePlayEnd();
            }

            @Override
            public void filePlayStartOK() {
                callback.showFilePlayStartOK();
            }

            @Override
            public void filePlayStartFailed() {
                callback.showFilePlayStartFailed();
            }

            @Override
            public void showRecorderPlayBOF() {

            }
        });
    }



    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(callback)){
            callback = null;
        }
    }


}
