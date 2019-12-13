package com.nathan.arch.domain.interactors.channelmanager.impl;

import com.nathan.arch.domain.interactors.channelmanager.ChannelManagerInteractor;
import com.nathan.arch.domain.model.ChannelSortTypeDModel;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.repository.ChannelManagerRepository;
import com.nathan.arch.storage.ChannelManagerRepositoryImpl;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.List;

public class ChannelManagerInteractorImpl implements ChannelManagerInteractor,
        ChannelManagerRepository.Callback {
    private ChannelManagerRepository repository;
    private Callback mCallback;
    public ChannelManagerInteractorImpl(){
        repository = ChannelManagerRepositoryImpl.getInstance();
    }


    @Override
    public List<ChannelUnitModel> getAllTvProgList() {
        return repository.getALLTVProgList();
    }

    @Override
    public List<ChannelUnitModel> getAllRadioProgList() {
        return repository.getALLRadioProgList();
    }

    @Override
    public ChannelUnitModel getChannelByShowNo(int showNo) {
        return repository.getChannelByShowNo(showNo);
    }

    @Override
    public List<String> getProgGroupList() {
        return repository.getProgGroupList();
    }

    @Override
    public ChannelUnitModel getChannelByUniqueIndex(int progIndex) {
        return repository.getChannelByUniqueIndex(progIndex);
    }

    @Override
    public boolean setProgDelFlag(ChannelUnitModel progInfo, boolean bDel) {
        return repository.setProgDelFlag(progInfo,bDel);
    }

    @Override
    public boolean setProgHideFlag(ChannelUnitModel progInfo, boolean bHide) {
        return repository.setProgHideFlag(progInfo,bHide);
    }

    @Override
    public boolean setProgLockFlag(ChannelUnitModel progInfo, boolean bLock) {
        return repository.setProgLockFlag(progInfo,bLock);
    }

    @Override
    public boolean setProgSortType(ChannelSortTypeDModel sort) {
        return repository.setProgSortType(sort);
    }

    @Override
    public ChannelSortTypeDModel getProgSortType() {
        return repository.getProgSortType();
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        repository.attach(this);
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(repository)){
            repository.detach();
            repository = null;
            mCallback = null;
        }
    }
}
