package com.nathan.arch.domain.model;

public class PlayChannelInfoDModel {

    private String mAudioType;
    private String mVideoType;
    private String mResolution;
    private boolean isMultiAudio;
    private boolean isHavingTTX;
    private boolean isHavingSubtitle;

    public String getAudioType() {
        return mAudioType;
    }

    public void setAudioType(String audioType) {
        mAudioType = audioType;
    }

    public String getVideoType() {
        return mVideoType;
    }

    public void setVideoType(String videoType) {
        mVideoType = videoType;
    }

    public String getResolution() {
        return mResolution;
    }

    public void setResolution(String resolution) {
        mResolution = resolution;
    }

    public boolean isMultiAudio() {
        return isMultiAudio;
    }

    public void setMultiAudio(boolean multiAudio) {
        isMultiAudio = multiAudio;
    }

    public boolean isHavingTTX() {
        return isHavingTTX;
    }

    public void setHavingTTX(boolean havingTTX) {
        isHavingTTX = havingTTX;
    }

    public boolean isHavingSubtitle() {
        return isHavingSubtitle;
    }

    public void setHavingSubtitle(boolean havingSubtitle) {
        isHavingSubtitle = havingSubtitle;
    }


    @Override
    public String toString() {
        return "PlayChannelInfoDModel{" +
                "mAudioType='" + mAudioType + '\'' +
                ", mVideoType='" + mVideoType + '\'' +
                ", mResolution='" + mResolution + '\'' +
                ", isMultiAudio=" + isMultiAudio +
                ", isHavingTTX=" + isHavingTTX +
                ", isHavingSubtitle=" + isHavingSubtitle +
                '}';
    }
}
