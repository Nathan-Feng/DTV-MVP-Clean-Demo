package com.nathan.arch.domain.model;

public class SearchFreqInfoDModel {

    private int mTotal;

    private int mCurrentCount;

    private int mFreq;//387000

    private int mSymbolRate;//6875

    private ModulationQAM mQam;

    private String mStatus;

    public SearchFreqInfoDModel(int total, int currentCount, int freq, int symbolRate,
                                ModulationQAM qam, String status) {
        mTotal = total;
        mCurrentCount = currentCount;
        mFreq = freq;
        mSymbolRate = symbolRate;
        mQam = qam;
        mStatus = status;
    }

    public int getTotal() {
        return mTotal;
    }

    public void setTotal(int total) {
        mTotal = total;
    }

    public int getCurrentCount() {
        return mCurrentCount;
    }

    public void setCurrentCount(int currentCount) {
        mCurrentCount = currentCount;
    }

    public int getFreq() {
        return mFreq;
    }

    public void setFreq(int freq) {
        mFreq = freq;
    }

    public int getSymbolRate() {
        return mSymbolRate;
    }

    public void setSymbolRate(int symbolRate) {
        mSymbolRate = symbolRate;
    }

    public ModulationQAM getQam() {
        return mQam;
    }

    public void setQam(ModulationQAM qam) {
        mQam = qam;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    @Override
    public String toString() {
        return "SearchFreqInfoDModel{" +
                "mTotal=" + mTotal +
                ", mCurrentCount=" + mCurrentCount +
                ", mFreq=" + mFreq +
                ", mSymbolRate=" + mSymbolRate +
                ", mQam=" + mQam +
                ", mStatus='" + mStatus + '\'' +
                '}';
    }
}
