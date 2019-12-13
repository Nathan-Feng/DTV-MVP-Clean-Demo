package com.nathan.arch.domain.interactors.book.impl;

import com.nathan.arch.domain.interactors.book.ChannelBookMonitorInteractor;
import com.nathan.arch.domain.model.BookParamDModel;
import com.nathan.arch.domain.repository.ChannelBookMonitorRepository;
import com.nathan.arch.storage.ChannelBookMonitorRepositoryImpl;
import com.nathan.arch.storage.tools.EmptyTool;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class ChannelBookMonitorInteractorImpl implements ChannelBookMonitorInteractor, ChannelBookMonitorRepository.Callback{

    private Callback mCallback;
    private ChannelBookMonitorRepository bookRepository;

    public ChannelBookMonitorInteractorImpl() {
        bookRepository = ChannelBookMonitorRepositoryImpl.getInstance();
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        bookRepository.attach(this);
    }


    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(bookRepository)){
            bookRepository.detach();
            bookRepository = null;
            mCallback = null;
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
    }
}
