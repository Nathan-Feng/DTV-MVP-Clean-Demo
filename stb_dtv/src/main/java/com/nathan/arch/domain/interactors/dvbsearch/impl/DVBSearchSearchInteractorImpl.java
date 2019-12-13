package com.nathan.arch.domain.interactors.dvbsearch.impl;

import com.nathan.arch.domain.interactors.dvbsearch.DVBSearchInteractor;
import com.nathan.arch.domain.model.DVBCSearchParamDModel;
import com.nathan.arch.domain.model.DVBSearchTypeDModel;
import com.nathan.arch.domain.model.DVBTSearchParamDModel;
import com.nathan.arch.domain.model.SearchFreqInfoDModel;
import com.nathan.arch.domain.repository.DVBSearchRepository;
import com.nathan.arch.storage.DVBSearchRepositoryImpl;

import java.util.List;

import timber.log.Timber;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class DVBSearchSearchInteractorImpl<T> implements DVBSearchInteractor<T>, DVBSearchRepository.Callback{

    private DVBSearchInteractor.Callback mCallback;
    private DVBSearchRepository dvbcRepository;

    public DVBSearchSearchInteractorImpl() {
        Timber.d("Nathan DVBSearchSearchInteractorImpl ==new   ");
        dvbcRepository = DVBSearchRepositoryImpl.getInstance();
    }


//    @Override
//    public void prepareManualSearch(DVBCSearchParamDModel model) {
//        dvbcRepository.prepareManualSearch(model);
//    }

    @Override
    public void prepareManualSearch(T model) {
        Timber.d("Nathan prepareManualSearch   ");
        if (model instanceof DVBCSearchParamDModel) {
            dvbcRepository.prepareManualSearch((DVBCSearchParamDModel)model);
        }
        if (model instanceof DVBTSearchParamDModel){
            Timber.d("Nathan prepareManualSearch   instanceof  DVBTSearchParamDModel ");
            dvbcRepository.prepareManualSearch((DVBTSearchParamDModel)model);
        }
    }

    @Override
    public void startSearch(DVBSearchTypeDModel model) {
        dvbcRepository.startSearch(model);
    }

    @Override
    public void finishSaveSearch() {
        dvbcRepository.finishSaveSearch();
    }

    @Override
    public void finishNoSaveSearch(){
        dvbcRepository.finishNoSaveSearch();
    }

    @Override
    public void showError(String message) {
        mCallback.showError(message);
    }

    @Override
    public void showFinishSearch() {
        mCallback.showFinishSearch();
    }

    @Override
    public void showSaveSearchDialog() {
        mCallback.showSaveSearchDialog();
    }

    @Override
    public void showFinishSearchOK() {
        mCallback.showFinishSearchSuccess();
    }

    @Override
    public void showFinishSearchError() {
        mCallback.showFinishSearchError();
    }

    @Override
    public void showSignalStrength(int strengthNum) {
        mCallback.showSignalStrength(strengthNum);
    }

    @Override
    public void showSignalQuality(int qualityNum) {
        mCallback.showSignalQuality(qualityNum);
    }

    @Override
    public void showUpdateScanFreqList(List<SearchFreqInfoDModel> mSearchFreqInfoDModel) {
        mCallback.showUpdateScanFreqList(mSearchFreqInfoDModel);
    }

//    @Override
//    public void showUpdateScanFreqList(List<SearchFreqInfoDModel> mSearchFreqInfoDModel) {
//        mCallback.showUpdateScanFreqList(mSearchFreqInfoDModel);
//    }

    @Override
    public void showSearchTvCount(int tvCount) {
        mCallback.showSearchTvCount(tvCount);
    }

    @Override
    public void showSearchRadioCount(int radioCount) {
        mCallback.showSearchRadioCount(radioCount);
    }

    @Override
    public void showUpdateSearchProgress(int percent) {
        mCallback.showUpdateSearchProgress(percent);
    }

    @Override
    public void showUpdateSearchTvList(List<String> mTvDataList) {
        mCallback.showUpdateSearchTvList(mTvDataList);
    }

    @Override
    public void showUpdateSearchRadioList(List<String> mRadioDataList) {
        mCallback.showUpdateSearchRadioList(mRadioDataList);
    }


    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        dvbcRepository.attach(this);
    }


    @Override
    public void detach() {
        dvbcRepository.detach();
        dvbcRepository = null;
        mCallback = null;
    }
}
