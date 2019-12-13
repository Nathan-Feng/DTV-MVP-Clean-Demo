package com.nathan.arch.domain.interactors.book;


import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.BookParamDModel;

public interface ChannelBookMonitorInteractor extends Interactor {

    interface Callback extends IDVBBaseInteractorCallback {
        void showBookRecAlarm(BookParamDModel bookInfo);//60s count down
        void showBookRecStart();
        void showBookPlayAlarm(BookParamDModel bookInfo);//60s count down
        void showBookPlayStart();
    }

    void attach(Callback callback);
}
