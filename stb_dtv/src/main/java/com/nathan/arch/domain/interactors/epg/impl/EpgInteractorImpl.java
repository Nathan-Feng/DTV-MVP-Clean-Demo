package com.nathan.arch.domain.interactors.epg.impl;

import com.nathan.arch.domain.interactors.epg.EpgInteractor;
import com.nathan.arch.domain.model.BookTypeDModel;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.model.EpgInfoDModel;
import com.nathan.arch.domain.repository.EpgRepository;
import com.nathan.arch.presentation.presenters.IDVBEpgPresenter;
import com.nathan.arch.storage.EpgRepositoryImpl;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.List;

public class EpgInteractorImpl implements EpgInteractor , IDVBEpgPresenter.Callback {

    private Callback mCallback = null;
    private EpgRepository mRepository = null;
    public EpgInteractorImpl(){
        mRepository = EpgRepositoryImpl.getInstance();
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
    }

    @Override
    public List<EpgInfoDModel> getEpgListByChannel(ChannelUnitModel pInfo) {
        return mRepository.getEpgListByChannel(pInfo);
    }

    @Override
    public boolean epgBook(EpgInfoDModel evtInfo, BookTypeDModel type) {
        return mRepository.epgBook(evtInfo,type);
    }

    @Override
    public boolean epgConflictBook(EpgInfoDModel evtInfo, BookTypeDModel type, int bookId) {
        return mRepository.epgConflictBook(evtInfo,type,bookId);
    }

    @Override
    public boolean epgCancelBook(EpgInfoDModel evtInfo) {
        return mRepository.epgCancelBook(evtInfo);
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(mRepository)){
            mRepository.detach();
            mRepository = null;
            mCallback = null;
        }
    }

    @Override
    public void showEpgBookConflict(int bookId) {
        mCallback.showEpgBookConflict(bookId);
    }
}
