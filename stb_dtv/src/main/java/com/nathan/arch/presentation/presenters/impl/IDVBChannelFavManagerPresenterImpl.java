package com.nathan.arch.presentation.presenters.impl;

import com.nathan.arch.domain.interactors.channelmanager.ChannelFavManagerInteractor;
import com.nathan.arch.domain.interactors.channelmanager.impl.ChannelFavManagerInteractorImpl;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.presentation.presenters.IDVBChannelFavManagerPresenter;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.storage.tools.EmptyTool;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Nathan on 07/08/19.
 */
public class IDVBChannelFavManagerPresenterImpl implements IDVBBasePresenter, IDVBChannelFavManagerPresenter,
    ChannelFavManagerInteractor.Callback
{
    private ChannelFavManagerInteractor interactor;
    private Callback mCallback;

    public IDVBChannelFavManagerPresenterImpl() {
        interactor = new ChannelFavManagerInteractorImpl();
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        interactor.attach(this);
    }

    @Override
    public List<String> getAllFavTypeList() {
        return interactor.getAllFavTypeList();
    }

    @Override
    public List<ChannelUnitModel> getTvChannelsByFav(int mFavIndex) {
        return interactor.getTvChannelsByFav(mFavIndex);
    }

    @Override
    public List<ChannelUnitModel> getRadioChannelsByFav(int mFavIndex) {
        return interactor.getRadioChannelsByFav(mFavIndex);
    }

    @Override
    public boolean renameFavType(int position, String newName) {
        return interactor.renameFavType(position,newName);
    }

    @Override
    public boolean addChannelToFavType(ChannelUnitModel progInfo, int mFavIndex) {
        return interactor.addChannelToFavType(progInfo,mFavIndex);
    }

    @Override
    public boolean removeChannelFromFavType(ChannelUnitModel progInfo, int mFavIndex) {
        return interactor.removeChannelFromFavType(progInfo,mFavIndex);
    }

    @Override
    public List<ChannelUnitModel> getTvChannelsByFavType(int mFavIndex) {
        return interactor.getTvChannelsByFavType(mFavIndex);
    }

    @Override
    public List<ChannelUnitModel> getRadioChannelsByFavType(int mFavIndex) {
        return interactor.getRadioChannelsByFavType(mFavIndex);
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(interactor)){
            interactor.detach();
            interactor = null;
            mCallback = null;
        }
    }

    @Override
    public void showError(String message) {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showError(message);
        }
    }


    private boolean checkNullable(WeakReference<Callback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }
}
