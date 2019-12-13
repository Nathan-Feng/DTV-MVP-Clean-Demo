package com.nathan.arch.presentation.presenters.impl;

import com.nathan.arch.domain.interactors.book.ChannelBookInteractor;
import com.nathan.arch.domain.interactors.book.impl.ChannelBookInteractorImpl;
import com.nathan.arch.domain.model.BookParamDModel;
import com.nathan.arch.domain.model.BookTypeDModel;
import com.nathan.arch.presentation.presenters.IDVBChannelBookPresenter;
import com.nathan.arch.storage.tools.EmptyTool;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Nathan on 07/08/19.
 */
public class IDVBChannelBookPresenterImpl implements IDVBChannelBookPresenter,
        ChannelBookInteractor.Callback  {

    private Callback mCallback;
    private ChannelBookInteractor interactor;



    public IDVBChannelBookPresenterImpl() {
        interactor = new ChannelBookInteractorImpl();
    }


    /**
     * @param bookId
     */
    @Override
    public void showChannelBookConflict(int bookId) {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showChannelBookConflict(bookId);
        }
    }

    @Override
    public void showReBookConflict(int bookId) {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showReBookConflict(bookId);
        }
    }

    @Override
    public boolean channelBook(BookParamDModel model) {
        return interactor.channelBook(model);
    }

    @Override
    public void channelBookConflict(BookParamDModel model, int boodId) {
        interactor.channelBookConflict(model,boodId);
    }

    @Override
    public List<BookParamDModel> getAllBookTaskList() {
        return interactor.getAllBookTaskList();
    }

    @Override
    public List<BookParamDModel> getBookTaskListByType(BookTypeDModel taskType) {
        return interactor.getBookTaskListByType(taskType);
    }

    @Override
    public boolean deleteOneBookTask(BookParamDModel model) {
        return interactor.deleteOneBookTask(model);
    }

    @Override
    public boolean deleteAllBookTaskList(List<BookParamDModel> taskList) {
        return interactor.deleteAllBookTaskList(taskList);
    }

    @Override
    public boolean rebookTask(BookParamDModel model) {
        return interactor.rebookTask(model);
    }

    @Override
    public boolean rebookConflict(BookParamDModel model, int bookId) {
        return interactor.rebookConflict(model,bookId);
    }

    @Override
    public BookParamDModel getBookTaskById(int bookId) {
        return interactor.getBookTaskById(bookId);
    }

    @Override
    public BookParamDModel getBookHintGoingTask() {
        return interactor.getBookHintGoingTask();
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
}
