package com.nathan.arch.presentation.presenters.impl;

import com.nathan.arch.domain.interactors.epg.EpgInteractor;
import com.nathan.arch.domain.interactors.epg.impl.EpgInteractorImpl;
import com.nathan.arch.domain.model.BookTypeDModel;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.model.EpgInfoDModel;
import com.nathan.arch.presentation.presenters.IDVBEpgPresenter;
import com.nathan.arch.storage.tools.EmptyTool;

import java.lang.ref.WeakReference;
import java.util.List;

public class IDVBEpgPresenterImpl implements IDVBEpgPresenter ,EpgInteractor.Callback {

    private EpgInteractor mInteractor = null;
    private Callback mCallback = null;

    public IDVBEpgPresenterImpl(){
        mInteractor = new EpgInteractorImpl();
    }


    @Override
    public void attach(Callback callback) {
        mCallback = callback;
        mInteractor.attach(this);
    }

    @Override
    public List<EpgInfoDModel> getEpgListByChannel(ChannelUnitModel pInfo) {
        return mInteractor.getEpgListByChannel(pInfo);
    }

    @Override
    public boolean epgBook(EpgInfoDModel evtInfo, BookTypeDModel type) {
        return mInteractor.epgBook(evtInfo,type);
    }

    @Override
    public boolean epgConflictBook(EpgInfoDModel evtInfo, BookTypeDModel type, int bookId) {
        return mInteractor.epgConflictBook(evtInfo,type,bookId);
    }

    @Override
    public boolean epgCancelBook(EpgInfoDModel evtInfo) {
        return mInteractor.epgCancelBook(evtInfo);
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(mInteractor)){
            mInteractor.detach();
            mInteractor = null;
            mCallback = null;
        }
    }

    @Override
    public void showEpgBookConflict(int bookId) {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showEpgBookConflict(bookId);
        }
    }


    private boolean checkNullable(WeakReference<Callback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }
}
