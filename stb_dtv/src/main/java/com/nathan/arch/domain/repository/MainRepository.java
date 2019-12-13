package com.nathan.arch.domain.repository;

import android.view.SurfaceHolder;

import com.nathan.arch.domain.interactors.base.Interactor;

/**
 * A repository that is responsible for getting our welcome message.
 */
public interface MainRepository extends Interactor {
    void setSurfaceHolder(SurfaceHolder holder);
    void resume();
}
