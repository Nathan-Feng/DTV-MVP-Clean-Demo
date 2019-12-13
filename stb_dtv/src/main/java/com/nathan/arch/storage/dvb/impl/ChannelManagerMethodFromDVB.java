package com.nathan.arch.storage.dvb.impl;

import com.nathan.arch.storage.dvb.ICallbackChannelManagerMethod;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.ArrayList;
import java.util.List;


public class ChannelManagerMethodFromDVB implements ICallbackChannelManagerMethod {
    private ICallbackChannelManagerMethod.Callback callback;

    public ChannelManagerMethodFromDVB(Callback callback){
        this.callback = callback;
        initDVB();
    }


    private void initDVB() {
    }

    private void restoreDefaultTvGroup(){
    }



    @Override
    public List<String> getProgGroupList(){
        List<String> mList = new ArrayList<>();
        mList.add("TV");
        mList.add("Radio");
        return mList;
    }




    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(callback)){
            callback = null;
        }
    }

}
