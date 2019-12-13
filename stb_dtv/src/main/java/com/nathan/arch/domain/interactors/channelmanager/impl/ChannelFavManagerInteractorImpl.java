package com.nathan.arch.domain.interactors.channelmanager.impl;

import com.nathan.arch.domain.interactors.channelmanager.ChannelFavManagerInteractor;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.repository.ChannelFavManagerRepository;
import com.nathan.arch.storage.ChannelFavManagerRepositoryImpl;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.List;

public class ChannelFavManagerInteractorImpl implements ChannelFavManagerInteractor,
        ChannelFavManagerRepository.Callback {
    private ChannelFavManagerRepository repository;
    private Callback callback;
    public ChannelFavManagerInteractorImpl(){
        repository = ChannelFavManagerRepositoryImpl.getInstance();
    }


    @Override
    public List<String> getAllFavTypeList() {
        return repository.getALLFavTypeList();
    }

    @Override
    public List<ChannelUnitModel> getTvChannelsByFav(int mFavIndex) {
        return repository.getTVChannelsByFav(mFavIndex);
    }

    @Override
    public List<ChannelUnitModel> getRadioChannelsByFav(int mFavIndex) {
        return repository.getRadioChannelsByFav(mFavIndex);
    }

    @Override
    public boolean renameFavType(int position, String newName) {
        return repository.renameFavType(position,newName);
    }

    @Override
    public boolean addChannelToFavType(ChannelUnitModel progInfo, int mFavIndex) {
        return repository.addChannelToFavType(progInfo,mFavIndex);
    }

    @Override
    public boolean removeChannelFromFavType(ChannelUnitModel progInfo, int mFavIndex) {
        return repository.removeChannelFromFavType(progInfo,mFavIndex);
    }

    @Override
    public List<ChannelUnitModel> getTvChannelsByFavType(int mFavIndex) {
        return repository.getTVChannelsByFavType(mFavIndex);
    }

    @Override
    public List<ChannelUnitModel> getRadioChannelsByFavType(int mFavIndex) {
        return repository.getRadioChannelsByFavType(mFavIndex);
    }


    @Override
    public void attach(Callback callback) {
        this.callback = callback;
        repository.attach(this);
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(repository)){
            repository.detach();
            repository = null;
            callback = null;
        }
    }
}
