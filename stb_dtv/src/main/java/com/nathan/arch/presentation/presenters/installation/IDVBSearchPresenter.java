package com.nathan.arch.presentation.presenters.installation;


import com.nathan.arch.domain.model.DVBSearchTypeDModel;
import com.nathan.arch.domain.model.SearchFreqInfoDModel;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.presentation.ui.IDVBBaseCallback;

import java.util.List;

/**
 * For DVB T
 */
public interface IDVBSearchPresenter<T> extends IDVBBasePresenter {

    void attach(IDVBSearchPresenter.Callback callback);

    interface Callback extends IDVBBaseCallback {

        /**
         * if Search progress is finished ,callback this
         */
        void showFinishSearch();

        /**
         * if Search progress is finished and need to save Channels,
         * callback to UI to let user choose save or not ?
         */
        void showSaveSearchDialog();

        /**
         * after   do  void finishSaveSearch(); or void finishNoSaveSearch();
         *  if return OK, then call back this.         *
         */
        void showFinishSearchSuccess();

        /**
         * after   do  void finishSaveSearch(); or void finishNoSaveSearch();
         *  if return Error, then call back this.         *
         */
        void showFinishSearchError();

        /**
         * @param strengthNum after prepareSearch ,callback tuner signal Strength
         *                    from 0 to 100;
         */
        void showSignalStrength(int strengthNum);

        /**
         * @param qualityNum fter prepareSearch ,callback tuner signal Quality
        from 0 to 100;
         */
        void showSignalQuality(int qualityNum);

        /**
         * @param mSearchFreqInfoDModel when startSearch, callback all the freq List
         */
        void showUpdateScanFreqList(List<SearchFreqInfoDModel> mSearchFreqInfoDModel);

        /**
         * @param tvCount callback the current searched total TV Count
         */
        void showSearchTvCount(int tvCount);

        /**
         * @param radioCount callback the current searched total Radio Count
         */
        void showSearchRadioCount(int radioCount);

        /**
         * @param percent callback the current SearchProgress, from 0 to 100;
         */
        void showUpdateSearchProgress(int percent);

        /**
         * @param mTvDataList callback all the Tv Name List when Searching
         */
        void showUpdateSearchTvList(List<String> mTvDataList);

        /**
         * @param mRadioDataList callback all the Radio List when Searching
         */
        void showUpdateSearchRadioList(List<String> mRadioDataList);
    }

    /**
     * @param model for DVBC Manual Search ,model is params
     *              this is the 1st step for Manual Search
     */
    //step 1
    void prepareManualSearch(T model);

    /**
     * @param type start Search for Manual or Audo depended on type
     */
    //step 2
    void startSearch(DVBSearchTypeDModel type);

    /**
     * use to save Search channels to DB
     */
    //step 3
    void finishSaveSearch();

    /**
     * discard to searched channels ,not save to DB
     */
    //step 3
    void finishNoSaveSearch();

}
