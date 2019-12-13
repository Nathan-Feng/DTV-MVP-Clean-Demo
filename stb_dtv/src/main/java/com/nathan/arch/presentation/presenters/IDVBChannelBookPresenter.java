package com.nathan.arch.presentation.presenters;


import com.nathan.arch.domain.model.BookParamDModel;
import com.nathan.arch.domain.model.BookTypeDModel;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.presentation.ui.IDVBBaseCallback;

import java.util.List;


/**
 * use for Live Chanel book functions
 * @author Nathan
 */
public interface IDVBChannelBookPresenter extends IDVBBasePresenter {
    /**
     * @param callback 注册回调接口，调用后可以接收回调的所有方法
     */
    void attach(Callback callback);

    interface Callback extends IDVBBaseCallback {
        /**
         * @param bookId when Live channel Booking, if conflict ,callback this and bookID
         */
        void showChannelBookConflict(int bookId);

        /**
         * If book Success , callback this
         */
        void showChannelBookSuccess();

        /**
         * if book failed, callback this.
         */
        void showChannelBookFail();

        void showReBookConflict(int bookId);
    }

    /**
     * @param model use for Live channel start Book.
     *              model is params for booking
     */
    boolean channelBook(BookParamDModel model);

    /**
     * @param model params when booking conflict.
     * @param boodId ,if you want to book anyway when conflict ,do call this function.
     */
    void channelBookConflict(BookParamDModel model, int boodId);

    List<BookParamDModel> getAllBookTaskList();
    List<BookParamDModel> getBookTaskListByType(BookTypeDModel taskType);

    boolean deleteOneBookTask(BookParamDModel model);

    boolean deleteAllBookTaskList(List<BookParamDModel> taskList);

    boolean rebookTask(BookParamDModel model);

    boolean rebookConflict(BookParamDModel model,int bookId);

    BookParamDModel getBookTaskById(int bookId);
    BookParamDModel getBookHintGoingTask();
}
