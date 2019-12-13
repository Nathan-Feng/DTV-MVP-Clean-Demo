package com.nathan.arch.presentation.presenters.impl;

import com.nathan.arch.domain.interactors.book.ChannelBookMonitorInteractor;
import com.nathan.arch.domain.interactors.book.impl.ChannelBookMonitorInteractorImpl;
import com.nathan.arch.domain.model.BookParamDModel;
import com.nathan.arch.presentation.presenters.IDVBChannelBookMonitorPresenter;
import com.nathan.arch.storage.tools.EmptyTool;

import java.lang.ref.WeakReference;

/**
 * Created by Nathan on 07/08/19.
 */
public class IDVBChannelBookMonitorPresenterImpl implements IDVBChannelBookMonitorPresenter,
        ChannelBookMonitorInteractor.Callback  {

    private Callback mCallback;
    private PlayCallback mPlayCallback;
    private ChannelBookMonitorInteractor interactor;



    public IDVBChannelBookMonitorPresenterImpl() {
        interactor = new ChannelBookMonitorInteractorImpl();
    }

    private boolean checkNullable(WeakReference<Callback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }



    @Override
    public void attach(Callback callback) {
        mCallback = callback;
        interactor.attach(this);
    }

    @Override
    public void attach(PlayCallback callback) {
        mPlayCallback = callback;
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
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showError(message);
        }
    }

    @Override
    public void showBookRecAlarm(BookParamDModel bookInfo) {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showBookRecAlarm(bookInfo);
        }
    }

    @Override
    public void showBookRecStart() {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showBookRecStart();
        }
    }

    @Override
    public void showBookPlayAlarm(BookParamDModel bookInfo) {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showBookPlayAlarm(bookInfo);
        }
    }

    @Override
    public void showBookPlayStart() {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showBookPlayStart();
        }

        if (EmptyTool.isNotEmpty(mPlayCallback)){
            mPlayCallback.showBookPlayStart();
        }
    }
}
