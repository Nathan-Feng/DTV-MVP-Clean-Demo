package com.nathan.arch.presentation.presenters;

import com.nathan.arch.domain.model.TimeDModel;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.presentation.ui.IDVBBaseCallback;

public interface IDVBClockPresenter extends IDVBBasePresenter {
    /**
     * @param callback 注册回调接口，调用后可以接收回调的所有方法
     */
    void attach(Callback callback);
    interface Callback extends IDVBBaseCallback {
        /**
         * @param time 回调时间相关的model，包括年月日，时分秒，
         */
        void showClock(TimeDModel time);
    }
    TimeDModel getCurrentDvbClockTime();
}
