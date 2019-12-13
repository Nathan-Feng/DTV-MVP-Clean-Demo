package com.nathan.arch.storage;

import com.nathan.arch.domain.model.DVBSearchTypeDModel;
import com.nathan.arch.domain.model.SearchFreqInfoDModel;
import com.nathan.arch.domain.model.DVBCSearchParamDModel;
import com.nathan.arch.domain.repository.DVBSearchRepository;
import com.nathan.arch.storage.converters.StorageModelConverter;
import com.nathan.arch.storage.dvb.ICallbackDVBSearchMethod;
import com.nathan.arch.storage.dvb.impl.DVBSearchMethodFromDVB;
import com.nathan.arch.storage.model.ScanFreqItem;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.List;

import timber.log.Timber;

public class DVBSearchRepositoryImpl<T> implements DVBSearchRepository<T>,
        ICallbackDVBSearchMethod.Callback {

    /**
     * set this class to Singleton
     */

    private static DVBSearchRepositoryImpl instance =null;

    public static synchronized DVBSearchRepositoryImpl getInstance(){
        Timber.d("Nathan DVBSearchSearchInteractorImpl ==getInstance   ");
        if (instance ==null){
            Timber.d("Nathan DVBSearchRepositoryImpl ==instance ==null ");
            instance = new DVBSearchRepositoryImpl();
        }
        return instance;
    }

    private static DVBSearchMethodFromDVB mDVBSearch = null;
    private DVBSearchRepository.Callback callback;


    private DVBSearchRepositoryImpl(){
        Timber.d("Nathan DVBSearchRepositoryImpl new  ");
        mDVBSearch =new DVBSearchMethodFromDVB(this);
        if (mDVBSearch ==null){
            Timber.d("Nathan mDVBSearch ==null  ");
        } else {
            Timber.d("Nathan mDVBSearch not null  ");
        }
    }


    @Override
    public void attach(Callback mCallback) {
        this.callback = mCallback;
    }

    @Override
    public void prepareManualSearch(Object model) {

    }


    @Override
    public void startSearch(DVBSearchTypeDModel model){
    }


    @Override
    public void finishSaveSearch(){
    }
    @Override
    public void finishNoSaveSearch(){
    }

    /**
     * ***************************************SHOW CALL BACK************************************************8
     */

    @Override
    public void showError(String message) {
        if (EmptyTool.isNotEmpty(callback)) callback.showError(message);
    }

    @Override
    public void showFinishSearch() {
        if (EmptyTool.isNotEmpty(callback)) callback.showFinishSearch();
    }

    @Override
    public void showSaveSearchDialog() {
        if (EmptyTool.isNotEmpty(callback)) callback.showSaveSearchDialog();
    }

    @Override
    public void showFinishSearchSuccess() {
        if (EmptyTool.isNotEmpty(callback)) callback.showFinishSearchOK();
    }

    @Override
    public void showFinishSearchError() {
        if (EmptyTool.isNotEmpty(callback)) callback.showFinishSearchError();
    }

    @Override
    public void showSignalStrength(int strengthNum) {
        if (EmptyTool.isNotEmpty(callback)) callback.showSignalStrength(strengthNum);
    }

    @Override
    public void showSignalQuality(int qualityNum) {
        if (EmptyTool.isNotEmpty(callback)) callback.showSignalQuality(qualityNum);
    }

    @Override
    public void showUpdateScanFreqList(List<ScanFreqItem> mListFreqData) {
        List<SearchFreqInfoDModel> modelList = StorageModelConverter.convertToSearchFreqModel((List<ScanFreqItem>)mListFreqData);
        if (EmptyTool.isNotEmpty(callback)) callback.showUpdateScanFreqList(modelList);
    }

    @Override
    public void showSearchTvCount(int tvCount) {
        if (EmptyTool.isNotEmpty(callback)) callback.showSearchTvCount(tvCount);
    }

    @Override
    public void showSearchRadioCount(int radioCount) {
        if (EmptyTool.isNotEmpty(callback)) callback.showSearchRadioCount(radioCount);
    }

    @Override
    public void showUpdateSearchProgress(int percent) {
        if (EmptyTool.isNotEmpty(callback)) callback.showUpdateSearchProgress(percent);
    }

    @Override
    public void showUpdateSearchTvList(List<String> mTvDataList) {
        if (EmptyTool.isNotEmpty(callback)) callback.showUpdateSearchTvList(mTvDataList);
    }

    @Override
    public void showUpdateSearchRadioList(List<String> mRadioDataList) {
        if (EmptyTool.isNotEmpty(callback)) callback.showUpdateSearchRadioList(mRadioDataList);
    }

    @Override
    public void detach() {
        mDVBSearch.destory();
        mDVBSearch = null;
        instance = null;
        callback = null;
    }
}
