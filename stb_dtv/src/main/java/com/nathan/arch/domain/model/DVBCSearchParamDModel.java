package com.nathan.arch.domain.model;

public class DVBCSearchParamDModel {
    private int mFrequency;
    private int mSymbolRate;
    private ModulationQAM mQAM;
    private boolean mEnableNIT =false;
    private CAFilterDModel mCAFilter =CAFilterDModel.ALL;
    private ProgFilterDModel mProgFilter = ProgFilterDModel.ALL;

    public DVBCSearchParamDModel(int frequency, int symbolRate, ModulationQAM QAM, boolean enableNIT,
                                 CAFilterDModel CAFilter, ProgFilterDModel progFilter) {
        mFrequency = frequency;
        mSymbolRate = symbolRate;
        mQAM = QAM;
        mEnableNIT = enableNIT;
        mCAFilter = CAFilter;
        mProgFilter = progFilter;
    }

    public DVBCSearchParamDModel() {
    }

    public int getFrequency() {
        return mFrequency;
    }

    public void setFrequency(int frequency) {
        mFrequency = frequency;
    }

    public int getSymbolRate() {
        return mSymbolRate;
    }

    public void setSymbolRate(int symbolRate) {
        mSymbolRate = symbolRate;
    }

    public ModulationQAM getQAM() {
        return mQAM;
    }

    public void setQAM(ModulationQAM QAM) {
        mQAM = QAM;
    }

    public boolean isEnableNIT() {
        return mEnableNIT;
    }

    public void setEnableNIT(boolean enableNIT) {
        mEnableNIT = enableNIT;
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

    @Override
    public String toString() {
        return "DVBCSearchParamDModel{" +
                "mFrequency=" + mFrequency +
                ", mSymbolRate=" + mSymbolRate +
                ", mQAM=" + mQAM +
                ", mEnableNIT=" + mEnableNIT +
                ", mCAFilter=" + mCAFilter +
                ", mProgFilter=" + mProgFilter +
                '}';
    }
}
