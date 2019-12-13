package com.nathan.arch.storage;

import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.repository.ChannelFavManagerRepository;
import com.nathan.arch.storage.dvb.ICallbackChannelFavMethod;
import com.nathan.arch.storage.dvb.impl.ChannelFavManagerMethodFromDVB;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.List;

import timber.log.Timber;

public class ChannelFavManagerRepositoryImpl implements ChannelFavManagerRepository {

    private Callback mCallback;

    /**
     * set this class to Singleton
     */
    private static ChannelFavManagerRepositoryImpl instance = null;

    public static synchronized ChannelFavManagerRepositoryImpl getInstance(){
        Timber.d("Nathan ChannelFavManagerRepositoryImpl ==getInstance   ");
        if (instance ==null){
            Timber.d("Nathan ChannelFavManagerRepositoryImpl ==instance ==null ");
            instance = new ChannelFavManagerRepositoryImpl();
        }
        return instance;
    }

    private ICallbackChannelFavMethod favMethod;

    private ChannelFavManagerRepositoryImpl(){
        favMethod = new ChannelFavManagerMethodFromDVB();
    }


    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
    }

    @Override
    public List<String> getALLFavTypeList() {
        return favMethod.getALLFavTypeList();
    }

    @Override
    public List<ChannelUnitModel> getTVChannelsByFav(int favIndex) {
        Timber.d("Nathan,getTVChannelsByFav return null");
        return null;
    }

    @Override
    public List<ChannelUnitModel> getRadioChannelsByFav(int favIndex) {
        return null;
    }

    @Override
    public boolean renameFavType(int position, String newName) {
        return favMethod.renameFavType(position,newName);
    }

    @Override
    public boolean addChannelToFavType(ChannelUnitModel progInfo, int  favIndex) {
        return false;
    }

    @Override
    public boolean removeChannelFromFavType(ChannelUnitModel progInfo, int  favIndex) {
        return false;
    }

    @Override
    public List<ChannelUnitModel> getTVChannelsByFavType(int  favIndex) {
        return null;
    }

    @Override
    public List<ChannelUnitModel> getRadioChannelsByFavType(int  favIndex) {
        return null;
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(instance)){
            instance = null;
            mCallback = null;
            favMethod.detach();
            favMethod = null;
        }
    }

}
