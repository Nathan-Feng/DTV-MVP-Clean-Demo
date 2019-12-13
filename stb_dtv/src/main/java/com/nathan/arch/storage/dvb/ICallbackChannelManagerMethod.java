package com.nathan.arch.storage.dvb;


import java.util.List;

public interface ICallbackChannelManagerMethod {

    interface Callback{
        void showError(String message);
    }
    List<String> getProgGroupList();
    void detach();
}
