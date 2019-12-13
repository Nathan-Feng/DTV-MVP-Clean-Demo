package com.nathan.arch.domain.interactors.book.impl;

import com.nathan.arch.domain.interactors.book.ChannelBookInteractor;
import com.nathan.arch.domain.model.BookParamDModel;
import com.nathan.arch.domain.model.BookTypeDModel;
import com.nathan.arch.domain.repository.ChannelBookRepository;
import com.nathan.arch.storage.ChannelBookRepositoryImpl;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.List;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class ChannelBookInteractorImpl implements ChannelBookInteractor, ChannelBookRepository.Callback{

    private Callback mCallback;
    private ChannelBookRepository bookRepository;

    public ChannelBookInteractorImpl() {
        bookRepository = ChannelBookRepositoryImpl.getInstance();
    }


    @Override
    public boolean channelBook(BookParamDModel model) {
        return bookRepository.channelBook(model);
    }

    @Override
    public boolean channelBookConflict(BookParamDModel model, int boodId) {
        return bookRepository.channelBookConflict(model,boodId);
    }

    @Override
    public List<BookParamDModel> getAllBookTaskList() {
        return bookRepository.getAllBookTaskList();
    }

    @Override
    public List<BookParamDModel> getBookTaskListByType(BookTypeDModel taskType) {
        return bookRepository.getBookTaskListByType(taskType);
    }

    @Override
    public boolean deleteOneBookTask(BookParamDModel model) {
        return bookRepository.deleteOneBookTask(model);
    }

    @Override
    public boolean deleteAllBookTaskList(List<BookParamDModel> taskList) {
        return bookRepository.deleteAllBookTaskList(taskList);
    }

    @Override
    public boolean rebookTask(BookParamDModel model) {
        return bookRepository.rebookTask(model);
    }

    @Override
    public boolean rebookConflict(BookParamDModel model, int bookId) {
        return bookRepository.rebookConflict(model,bookId);
    }

    @Override
    public BookParamDModel getBookTaskById(int bookId) {
        return bookRepository.getBookTaskById(bookId);
    }

    @Override
    public BookParamDModel getBookHintGoingTask() {
        return bookRepository.getBookHintGoingTask();
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        bookRepository.attach(this);
    }

    @Override
    public void showChannelBookConflict(int bookId) {
        mCallback.showChannelBookConflict(bookId);
    }

    @Override
    public void showReBookConflict(int bookId) {
        mCallback.showReBookConflict(bookId);
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(bookRepository)){
            bookRepository.detach();
            bookRepository = null;
            mCallback = null;
        }
    }
}
