package com.nathan.arch.domain.repository;


import com.nathan.arch.domain.model.BookParamDModel;
import com.nathan.arch.domain.model.BookTypeDModel;

import java.util.List;

public interface ChannelBookRepository {
    void attach(Callback callback);
    interface Callback  {
        void showChannelBookConflict(int bookId);
        void showReBookConflict(int bookId);
    }

    boolean channelBook(BookParamDModel model);

    boolean channelBookConflict(BookParamDModel model, int boodId);

    List<BookParamDModel> getAllBookTaskList();
    List<BookParamDModel> getBookTaskListByType(BookTypeDModel taskType);

    boolean deleteOneBookTask(BookParamDModel model);

    boolean deleteAllBookTaskList(List<BookParamDModel> taskList);

    boolean rebookTask(BookParamDModel model);

    boolean rebookConflict(BookParamDModel model,int bookId);
    BookParamDModel getBookTaskById(int bookId);
    BookParamDModel getBookHintGoingTask();
    void detach();
}
