package com.nathan.arch.presentation.presenters;


import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.presentation.presenters.base.IDVBMainLifeCycle;
import com.nathan.arch.presentation.ui.IDVBBaseCallback;


public interface IDVBMainPresenter extends IDVBBasePresenter, IDVBMainLifeCycle {
    void attach(Callback callback);
    interface Callback extends IDVBBaseCallback {
    }
}
