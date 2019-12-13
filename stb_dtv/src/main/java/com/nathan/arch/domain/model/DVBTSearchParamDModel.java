package com.nathan.arch.domain.model;

public class DVBTSearchParamDModel {
    private int mFrequency;
    private int mBandWidth;
    private boolean mEnableNIT =false;
    private CAFilterDModel mCAFilter =CAFilterDModel.ALL;
    private ProgFilterDModel mProgFilter = ProgFilterDModel.ALL;

    @Override
    public String toString() {
        return "DVBTSearchParamDModel{" +
                "mFrequency=" + mFrequency +
                ", mBandWidth=" + mBandWidth +
                ", mEnableNIT=" + mEnableNIT +
                ", mCAFilter=" + mCAFilter +
                ", mProgFilter=" + mProgFilter +
                '}';
    }

    public DVBTSearchParamDModel() {
    }

    public DVBTSearchParamDModel(int frequency, int bandWidth, boolean enableNIT, CAFilterDModel CAFilter, ProgFilterDModel progFilter) {
        mFrequency = frequency;
        mBandWidth = bandWidth;
        mEnableNIT = enableNIT;
        mCAFilter = CAFilter;
        mProgFilter = progFilter;
    }

    public int getBandWidth() {
        return mBandWidth;
    }

    public void setBandWidth(int bandWidth) {
        mBandWidth = bandWidth;
    }

    public int getFrequency() {
        return mFrequency;
    }

    public void setFrequency(int frequency) {
        mFrequency = frequency;
    }


    public CAFilterDModel getCAFilter() {
        return mCAFilter;
    }

    public void setCAFilter(CAFilterDModel CAFilter) {
        mCAFilter = CAFilter;
    }

    public ProgFilterDModel getProgFilter() {
        return mProgFilter;
    }

    public void setProgFilter(ProgFilterDModel progFilter) {
        mProgFilter = progFilter;
    }

    public boolean isEnableNIT() {
        return mEnableNIT;
    }

    public void setEnableNIT(boolean enableNIT) {
        mEnableNIT = enableNIT;
    }

}
