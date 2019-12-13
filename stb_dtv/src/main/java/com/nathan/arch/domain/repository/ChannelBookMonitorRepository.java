package com.nathan.arch.domain.repository;


import com.nathan.arch.domain.model.BookParamDModel;

public interface ChannelBookMonitorRepository {
    void attach(Callback callback);
    interface Callback  {
        void showBookRecAlarm(BookParamDModel bookInfo);//60s count down
        void showBookRecStart();
        void showBookPlayAlarm(BookParamDModel bookInfo);//60s count down
        void showBookPlayStart();
    }
    void detach();
}
