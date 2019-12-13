package com.nathan.arch.domain.model;

public class TunerInfoDModel {

    private String mTunerBER;
    private int mTunerSignalQuality;
    private int mTunerSignalStrength;

    public String getTunerBER() {
        return mTunerBER;
    }

    public void setTunerBER(String mTunerBER) {
        this.mTunerBER = mTunerBER;
    }

    public int getTunerSignalQuality() {
        return mTunerSignalQuality;
    }

    public void setTunerSignalQuality(int mTunerSignalQuality) {
        this.mTunerSignalQuality = mTunerSignalQuality;
    }

    public int getTunerSignalStrength() {
        return mTunerSignalStrength;
    }

    public void setTunerSignalStrength(int mTunerSignalStrength) {
        this.mTunerSignalStrength = mTunerSignalStrength;
    }


    @Override
    public String toString() {
        return "TunerInfoDModel{" +
                "mTunerBER='" + mTunerBER + '\'' +
                ", mTunerSignalQuality=" + mTunerSignalQuality +
                ", mTunerSignalStrength=" + mTunerSignalStrength +
                '}';
    }
}
