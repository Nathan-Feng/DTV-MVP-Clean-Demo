package com.nathan.arch.storage.dvb.impl;

import com.nathan.arch.storage.dvb.ICallbackChannelFavMethod;

import java.util.ArrayList;
import java.util.List;

public class ChannelFavManagerMethodFromDVB implements ICallbackChannelFavMethod {

    private List<String> mFavList = new ArrayList<>();

    public ChannelFavManagerMethodFromDVB(){
        initDVB();
    }

    private void initDVB() {
    }


    /**
     * ************************************************************************************
     *
     */


    @Override
    public void detach() {

    }

    @Override
    public List<String> getALLFavTypeList(){
        return mFavList;
    }



    @Override
    public boolean renameFavType(int position,String newName){
        return false;
    }

}
