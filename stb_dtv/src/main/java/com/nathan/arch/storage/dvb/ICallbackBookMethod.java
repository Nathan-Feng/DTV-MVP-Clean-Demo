package com.nathan.arch.storage.dvb;


import com.nathan.arch.domain.model.BookParamDModel;

import java.util.List;

public interface ICallbackBookMethod {

    interface Callback  {
        void showChannelBookConflict(int bookId);
        void showReBookConflict(int bookId);
    }

    boolean channelBook(BookParamDModel model);

    boolean channelBookConflict(BookParamDModel model, int boodId);

    boolean deleteOneBookTask(BookParamDModel model);

    boolean deleteAllBookTaskList(List<BookParamDModel> taskList);

    boolean rebookTask(BookParamDModel model);

    boolean rebookConflict(BookParamDModel model,int bookId);


    void detach();
}
