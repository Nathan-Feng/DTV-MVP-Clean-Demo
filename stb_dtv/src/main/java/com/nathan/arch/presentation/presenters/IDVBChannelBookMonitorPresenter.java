package com.nathan.arch.presentation.presenters;

import com.nathan.arch.domain.model.BookParamDModel;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.presentation.ui.IDVBBaseCallback;

public interface IDVBChannelBookMonitorPresenter extends IDVBBasePresenter {

    void attach(Callback callback);
    void attach(PlayCallback callback);
    interface Callback extends IDVBBaseCallback {
        void showBookRecAlarm(BookParamDModel bookInfo);//60s count down
        void showBookRecStart();
        void showBookPlayAlarm(BookParamDModel bookInfo);//60s count down
        void showBookPlayStart();
    }

    interface PlayCallback extends IDVBBaseCallback {
        void showBookPlayStart();
    }
}
