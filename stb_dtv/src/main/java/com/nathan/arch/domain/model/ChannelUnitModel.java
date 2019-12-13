package com.nathan.arch.domain.model;

/**
 * A sample model. Replace this with your own.
 */
public class ChannelUnitModel {


    private int mShowNo;
    private String mChannelName;
    private int mProgIndex;
    private boolean mCasType;
    private boolean mLockFlag;
    private boolean mDelFlag;
    private boolean mHideFlag;

    private boolean bFavFlag;
    private ProgFilterDModel mModel;

    private int mProgId;
    /**
     * use for get EPG
     */
    private int mServiceId;
    private int mSatId;


    public int getShowNo() {
        return mShowNo;
    }

    public void setShowNo(int showNo) {
        mShowNo = showNo;
    }

    public String getChannelName() {
        return mChannelName;
    }

    public void setChannelName(String channelName) {
        mChannelName = channelName;
    }

    public boolean getCasType() {
        return mCasType;
    }

    public void setCasType(boolean casType) {
        mCasType = casType;
    }

    public boolean getLockFlag() {
        return mLockFlag;
    }

    public void setLockFlag(boolean lockFlag) {
        mLockFlag = lockFlag;
    }

    public boolean getDelFlag() {
        return mDelFlag;
    }

    public void setDelFlag(boolean delFlag) {
        mDelFlag = delFlag;
    }

    public boolean getHideFlag() {
        return mHideFlag;
    }

    public void setHideFlag(boolean hideFlag) {
        mHideFlag = hideFlag;
    }

    public ProgFilterDModel getModel() {
        return mModel;
    }

    public void setModel(ProgFilterDModel model) {
        mModel = model;
    }

    public int getProgId() {
        return mProgId;
    }

    public void setProgId(int progId) {
        mProgId = progId;
    }

    public int getServiceId() {
        return mServiceId;
    }

    public void setServiceId(int serviceId) {
        mServiceId = serviceId;
    }

    public int getSatId() {
        return mSatId;
    }

    public void setSatId(int satId) {
        mSatId = satId;
    }

    public boolean isFavFlag() {
        return bFavFlag;
    }

    public void setFavFlag(boolean bFavFlag) {
        this.bFavFlag = bFavFlag;
    }

    public int getProgIndex() {
        return mProgIndex;
    }

    public void setProgIndex(int progIndex) {
        mProgIndex = progIndex;
    }

    @Override
    public String toString() {
        return "ChannelUnitModel{" +
                "mShowNo=" + mShowNo +
                ", mChannelName='" + mChannelName + '\'' +
                ", mProgIndex=" + mProgIndex +
                ", mCasType=" + mCasType +
                ", mLockFlag=" + mLockFlag +
                ", mDelFlag=" + mDelFlag +
                ", mHideFlag=" + mHideFlag +
                ", bFavFlag=" + bFavFlag +
                ", mModel=" + mModel +
                ", mProgId=" + mProgId +
                ", mServiceId=" + mServiceId +
                ", mSatId=" + mSatId +
                '}';
    }
}
