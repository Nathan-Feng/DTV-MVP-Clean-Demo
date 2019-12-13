package com.nathan.arch.storage.dvb;


import com.nathan.arch.domain.model.DVBSearchTypeDModel;
import com.nathan.arch.storage.model.ScanFreqItem;

import java.util.List;

public interface ICallbackDVBSearchMethod<T> {

    interface Callback{
        void showError(String message);

        void showFinishSearch();
        void showSaveSearchDialog();
        void showFinishSearchSuccess();
        void showFinishSearchError();

        void showSignalStrength(int strengthNum);
        void showSignalQuality(int qualityNum);

        void showUpdateScanFreqList(List<ScanFreqItem> mListFreqData);

        void showSearchTvCount(int tvCount);
        void showSearchRadioCount(int radioCount);
        void showUpdateSearchProgress(int percent);

        void showUpdateSearchTvList(List<String> mTvDataList);
        void showUpdateSearchRadioList(List<String> mRadioDataList);
    }

}
