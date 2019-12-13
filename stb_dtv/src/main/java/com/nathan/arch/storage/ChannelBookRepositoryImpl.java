package com.nathan.arch.storage;

import com.nathan.arch.domain.model.BookParamDModel;
import com.nathan.arch.domain.model.BookTypeDModel;
import com.nathan.arch.domain.repository.ChannelBookRepository;
import com.nathan.arch.storage.converters.StorageModelConverter;
import com.nathan.arch.storage.dvb.impl.ChannelBookMethodFromDVB;
import com.nathan.arch.storage.dvb.ICallbackBookMethod;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.List;

import timber.log.Timber;


public class ChannelBookRepositoryImpl implements ChannelBookRepository,
        ICallbackBookMethod.Callback {

    private ChannelBookMethodFromDVB methodFromDVB;
    private ChannelBookRepository.Callback mCallback;

    /**
     * set this class to Singleton
     */
    private static ChannelBookRepositoryImpl instance = null;

    public static synchronized ChannelBookRepositoryImpl getInstance(){
        Timber.d("Nathan ChannelBookRepositoryImpl ==getInstance   ");
        if (instance ==null){
            Timber.d("Nathan ChannelBookRepositoryImpl ==instance ==null ");
            instance = new ChannelBookRepositoryImpl();
        }
        return instance;
    }

    private ChannelBookRepositoryImpl(){
        methodFromDVB = new ChannelBookMethodFromDVB(this);
    }


    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
    }

    @Override
    public boolean channelBook(BookParamDModel model){
        return methodFromDVB.channelBook(model);
    }

    @Override
    public boolean channelBookConflict(BookParamDModel model, int boodId) {
       return methodFromDVB.channelBookConflict(model,boodId);
    }

    @Override
    public void showChannelBookConflict(int bookId) {
        if (EmptyTool.isNotEmpty(mCallback)) mCallback.showChannelBookConflict(bookId);
    }

    @Override
    public void showReBookConflict(int bookId) {
        if (EmptyTool.isNotEmpty(mCallback)) mCallback.showReBookConflict(bookId);
    }

    @Override
    public List<BookParamDModel> getAllBookTaskList(){
        return null;
    }

    @Override
    public List<BookParamDModel> getBookTaskListByType(BookTypeDModel taskType) {

        return null;
    }

    @Override
    public boolean deleteOneBookTask(BookParamDModel model) {
        return methodFromDVB.deleteOneBookTask(model);
    }

    @Override
    public boolean deleteAllBookTaskList(List<BookParamDModel> taskList) {
        return methodFromDVB.deleteAllBookTaskList(taskList);
    }

    @Override
    public boolean rebookTask(BookParamDModel model) {
        return methodFromDVB.rebookTask(model);
    }

    @Override
    public boolean rebookConflict(BookParamDModel model, int bookId) {
        return methodFromDVB.rebookConflict(model,bookId);
    }

    @Override
    public BookParamDModel getBookTaskById(int bookId) {
       return null;
    }

    @Override
    public BookParamDModel getBookHintGoingTask() {
        return null;
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(methodFromDVB)){
            methodFromDVB.detach();
            methodFromDVB = null;
            mCallback = null;
            instance = null;
        }
    }

}
