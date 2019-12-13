package com.nathan.arch.storage.dvb.impl;


import com.nathan.arch.domain.model.DVBCSearchParamDModel;
import com.nathan.arch.domain.model.DVBSearchTypeDModel;
import com.nathan.arch.domain.model.DVBTSearchParamDModel;
import com.nathan.arch.storage.dvb.ICallbackDVBSearchMethod;
import com.nathan.arch.storage.model.ScanFreqItem;
import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Created by Nathan on 2019/7/17
 */
public class DVBSearchMethodFromDVB<T> implements ICallbackDVBSearchMethod<T> {

    private int currTuner;
    private int mNitEnable =0;
    private DVBCSearchParamDModel mDVBCSearchParamDModel;
    private DVBTSearchParamDModel mDVBTSearchParamDModel;


    private List<ScanFreqItem> mListFreqData = new ArrayList<>();
    private List<String> mTvDataList = new ArrayList<>();
    private List<String> mRadioDataList = new ArrayList<>();

    private Callback callback;

    private int mOldFreq = 0;
    private static final String FAIL = "fail";
    private static final String OK = "OK";
    private static final int SEARCH_DVBC = 0;
    private static final int SEARCH_DVBT = 1;

    public DVBSearchMethodFromDVB(Callback callback){
        Timber.d("Nathan new DVBOldSearchMethodFromDVB  timer start ");
        this.callback = callback;
    }




    public void resume() {

    }

    public void destory() {
    }

    /**
     * FOR  DVB C /T /S  Scan call back
     */


    private int toMhz(int hz){
        float toHz = hz;
        return hz/1000;
    }

    private ScanFreqItem getItemIndexByFreq(int freq){
        int temp = 0;
        for (int i =(mListFreqData.size() -1);i>0;i--){
            ScanFreqItem item = mListFreqData.get(i);
            if (item != null && item.Freq == freq/1000 ){
                temp = i;
                break;
            }
        }
        return mListFreqData.get(temp);
    }

    private void deInit(){
        mListFreqData.clear();
        mTvDataList.clear();
        mRadioDataList.clear();
    }
}
