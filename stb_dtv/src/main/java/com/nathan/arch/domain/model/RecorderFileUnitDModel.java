package com.nathan.arch.domain.model;

public class RecorderFileUnitDModel {
    private String mDirPath = "";//SDcard or USB1 or USB2
    private String mEventName = "";
    private String mFileName = "";
    private String mFileSize = "";
    private String mPCLevel = "";
    private String mEventDesc = "";
    private String mDuration = "";
    private String mResolution = "";

    public String getDirPath() {
        return mDirPath;
    }

    public void setDirPath(String dirPath) {
        mDirPath = dirPath;
    }

    public String getEventName() {
        return mEventName;
    }

    public void setEventName(String eventName) {
        mEventName = eventName;
    }

    public String getFileName() {
        return mFileName;
    }

    public void setFileName(String fileName) {
        mFileName = fileName;
    }

    public String getFileSize() {
        return mFileSize;
    }

    public void setFileSize(String fileSize) {
        mFileSize = fileSize;
    }

    public String getPCLevel() {
        return mPCLevel;
    }

    public void setPCLevel(String PCLevel) {
        mPCLevel = PCLevel;
    }

    public String getEventDesc() {
        return mEventDesc;
    }

    public void setEventDesc(String eventDesc) {
        mEventDesc = eventDesc;
    }

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String duration) {
        mDuration = duration;
    }

    public String getResolution() {
        return mResolution;
    }

    public void setResolution(String resolution) {
        mResolution = resolution;
    }

    @Override
    public String toString() {
        return "RecorderFileUnitDModel{" +
                "mDirPath='" + mDirPath + '\'' +
                ", mEventName='" + mEventName + '\'' +
                ", mFileName='" + mFileName + '\'' +
                ", mFileSize='" + mFileSize + '\'' +
                ", mPCLevel='" + mPCLevel + '\'' +
                ", mEventDesc='" + mEventDesc + '\'' +
                ", mDuration='" + mDuration + '\'' +
                ", mResolution='" + mResolution + '\'' +
                '}';
    }
}
