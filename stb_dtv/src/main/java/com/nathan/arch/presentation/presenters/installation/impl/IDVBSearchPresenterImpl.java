package com.nathan.arch.presentation.presenters.installation.impl;

import com.nathan.arch.domain.interactors.dvbsearch.DVBSearchInteractor;
import com.nathan.arch.domain.interactors.dvbsearch.impl.DVBSearchSearchInteractorImpl;
import com.nathan.arch.domain.model.DVBCSearchParamDModel;
import com.nathan.arch.domain.model.DVBSearchTypeDModel;
import com.nathan.arch.domain.model.DVBTSearchParamDModel;
import com.nathan.arch.domain.model.SearchFreqInfoDModel;
import com.nathan.arch.presentation.presenters.installation.IDVBSearchPresenter;

import java.lang.ref.WeakReference;
import java.util.List;

import timber.log.Timber;

public  class IDVBSearchPresenterImpl<T> implements IDVBSearchPresenter<T>, DVBSearchInteractor.Callback {

    private WeakReference<Callback> mCallback ;
    private DVBSearchInteractor mDVBSearchInteractorImpl;

    public IDVBSearchPresenterImpl(){
        Timber.d("Nathan IDVBSearchPresenterImpl ==new   ");
        mDVBSearchInteractorImpl = new DVBSearchSearchInteractorImpl();
        mDVBSearchInteractorImpl.attach(this);
    }

    @Override
    public void prepareManualSearch(T model) {
        Timber.d("Nathan prepareManualSearch   ");
        if (model instanceof DVBCSearchParamDModel) {
            mDVBSearchInteractorImpl.prepareManualSearch((DVBCSearchParamDModel) model);
        }

        if (model instanceof DVBTSearchParamDModel){
            Timber.d("Nathan prepareManualSearch   instanceof  DVBT ");
            mDVBSearchInteractorImpl.prepareManualSearch((DVBTSearchParamDModel) model);
        }
    }

    @Override
    public void startSearch(DVBSearchTypeDModel type) {
        mDVBSearchInteractorImpl.startSearch(type);
    }

    @Override
    public void finishSaveSearch() {
        mDVBSearchInteractorImpl.finishSaveSearch();
    }

    @Override
    public void finishNoSaveSearch() {
        mDVBSearchInteractorImpl.finishNoSaveSearch();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void showError(String message) {
        if (checkNullable(mCallback)) {
            mCallback.get().showError(message);
        }
    }

    @Override
    public void showFinishSearch() {
        if (checkNullable(mCallback)) {
            mCallback.get().showFinishSearch();
        }
    }

    @Override
    public void showSaveSearchDialog() {
        if (checkNullable(mCallback)) {
            mCallback.get().showSaveSearchDialog();
        }
    }

    @Override
    public void showFinishSearchSuccess() {
        if (checkNullable(mCallback)) {
            mCallback.get().showFinishSearchSuccess();
        }
    }

    @Override
    public void showFinishSearchError() {
        if (checkNullable(mCallback)) {
            mCallback.get().showFinishSearchError();
        }
    }

    @Override
    public void showSignalStrength(int strengthNum) {
        if (checkNullable(mCallback)) {
            mCallback.get().showSignalStrength(strengthNum);
        }
    }

    @Override
    public void showSignalQuality(int qualityNum) {
        if (checkNullable(mCallback)) {
            mCallback.get().showSignalQuality(qualityNum);
        }
    }

    @Override
    public void showUpdateScanFreqList(List<SearchFreqInfoDModel> mSearchFreqInfoDModel) {
        if (checkNullable(mCallback)) {
            mCallback.get().showUpdateScanFreqList(mSearchFreqInfoDModel);
        }
    }


    @Override
    public void showSearchTvCount(int tvCount) {
        if (checkNullable(mCallback)) {
            mCallback.get().showSearchTvCount(tvCount);
        }
    }

    @Override
    public void showSearchRadioCount(int radioCount) {
        if (checkNullable(mCallback)) {
            mCallback.get().showSearchRadioCount(radioCount);
        }
    }

    @Override
    public void showUpdateSearchProgress(int percent) {
        if (checkNullable(mCallback)) {
            mCallback.get().showUpdateSearchProgress(percent);
        }
    }

    @Override
    public void showUpdateSearchTvList(List<String> mTvDataList) {
        if (checkNullable(mCallback)) {
            mCallback.get().showUpdateSearchTvList(mTvDataList);
        }
    }

    @Override
    public void showUpdateSearchRadioList(List<String> mRadioDataList) {
        if (checkNullable(mCallback)) {
            mCallback.get().showUpdateSearchRadioList(mRadioDataList);
        }
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = new WeakReference<>(callback);
    }

    @Override
    public void detach() {
        mDVBSearchInteractorImpl.detach();
        mDVBSearchInteractorImpl = null;
        mCallback = null;
    }

    private boolean checkNullable(WeakReference<Callback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }
}
