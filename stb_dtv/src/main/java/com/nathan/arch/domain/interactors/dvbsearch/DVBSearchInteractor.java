package com.nathan.arch.domain.interactors.dvbsearch;


import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.DVBSearchTypeDModel;
import com.nathan.arch.domain.model.SearchFreqInfoDModel;

import java.util.List;


public interface DVBSearchInteractor<T> extends Interactor {


    interface Callback extends IDVBBaseInteractorCallback {

        void showFinishSearch();
        void showSaveSearchDialog();
        void showFinishSearchSuccess();
        void showFinishSearchError();

        void showSignalStrength(int strengthNum);
        void showSignalQuality(int qualityNum);

        void showUpdateScanFreqList(List<SearchFreqInfoDModel> mSearchFreqInfoDModel);
        void showSearchTvCount(int tvCount);
        void showSearchRadioCount(int radioCount);
        void showUpdateSearchProgress(int percent);

        void showUpdateSearchTvList(List<String> mTvDataList);
        void showUpdateSearchRadioList(List<String> mRadioDataList);
    }

    //step 1
//    void prepareManualSearch(DVBCSearchParamDModel model);
    void prepareManualSearch(T model);

    //step 2
    void startSearch(DVBSearchTypeDModel model);
    //step 3
    void finishSaveSearch();
    //step 3
    void finishNoSaveSearch();

    void attach(Callback callback);
}
