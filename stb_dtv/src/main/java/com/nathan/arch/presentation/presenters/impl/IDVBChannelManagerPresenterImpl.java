package com.nathan.arch.presentation.presenters.impl;

import com.nathan.arch.domain.interactors.channelmanager.ChannelManagerInteractor;
import com.nathan.arch.domain.interactors.channelmanager.impl.ChannelManagerInteractorImpl;
import com.nathan.arch.domain.model.ChannelSortTypeDModel;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.presentation.presenters.IDVBChannelManagerPresenter;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.storage.tools.EmptyTool;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Nathan on 07/08/19.
 */
public class IDVBChannelManagerPresenterImpl implements IDVBBasePresenter, IDVBChannelManagerPresenter
    ,ChannelManagerInteractor.Callback
{
    private ChannelManagerInteractor interactor;
    private Callback mCallback;

    public IDVBChannelManagerPresenterImpl() {
        interactor = new ChannelManagerInteractorImpl();
    }



    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        interactor.attach(this);
    }

    @Override
    public List<ChannelUnitModel> getAllTvProgList() {
        return interactor.getAllTvProgList();
    }

    @Override
    public List<ChannelUnitModel> getAllRadioProgList() {
        return interactor.getAllRadioProgList();
    }

    @Override
    public ChannelUnitModel getChannelByShowNo(int showNo) {
        return interactor.getChannelByShowNo(showNo);
    }

    @Override
    public ChannelUnitModel getChannelByUniqueIndex(int progIndex) {
        return interactor.getChannelByUniqueIndex(progIndex);
    }

    @Override
    public List<String> getProgGroupList() {
        return interactor.getProgGroupList();
    }

    @Override
    public boolean setProgDelFlag(ChannelUnitModel progInfo, boolean bDel) {
        return interactor.setProgDelFlag(progInfo,bDel);
    }

    @Override
    public boolean setProgHideFlag(ChannelUnitModel progInfo, boolean bHide) {
        return interactor.setProgHideFlag(progInfo,bHide);
    }

    @Override
    public boolean setProgLockFlag(ChannelUnitModel progInfo, boolean bLock) {
        return interactor.setProgLockFlag(progInfo,bLock);
    }

    @Override
    public boolean setProgSortType(ChannelSortTypeDModel sort) {
        return interactor.setProgSortType(sort);
    }

    @Override
    public ChannelSortTypeDModel getProgSortType() {
        return interactor.getProgSortType();
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(interactor)){
            interactor.detach();
            interactor = null;
            mCallback  = null;
        }
    }

    @Override
    public void showError(String message) {

    }


    private boolean checkNullable(WeakReference<Callback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }
}
