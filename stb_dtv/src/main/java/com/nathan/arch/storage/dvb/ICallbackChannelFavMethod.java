package com.nathan.arch.storage.dvb;



import java.util.List;

public interface ICallbackChannelFavMethod {

    List<String> getALLFavTypeList();
    boolean renameFavType(int position,String newName);
    void detach();
}
