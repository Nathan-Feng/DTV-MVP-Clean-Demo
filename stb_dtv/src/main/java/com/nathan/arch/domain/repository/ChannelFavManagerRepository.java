package com.nathan.arch.domain.repository;


import com.nathan.arch.domain.model.ChannelUnitModel;

import java.util.List;

public interface ChannelFavManagerRepository {
    void attach(Callback callback);
    interface Callback {

    }

    List<String> getALLFavTypeList();
    List<ChannelUnitModel> getTVChannelsByFav(int  favIndex);
    List<ChannelUnitModel> getRadioChannelsByFav(int  favIndex);
    boolean renameFavType(int position, String newName);
    boolean addChannelToFavType(ChannelUnitModel progInfo, int  favIndex);
    boolean removeChannelFromFavType(ChannelUnitModel progInfo, int  favIndex);
    List<ChannelUnitModel> getTVChannelsByFavType(int  favIndex);
    List<ChannelUnitModel> getRadioChannelsByFavType(int  favIndex);
    void detach();
}
