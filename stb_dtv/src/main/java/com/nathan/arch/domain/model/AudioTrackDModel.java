package com.nathan.arch.domain.model;

public  class AudioTrackDModel {
    public static final AudioTrackDModel STEREO   = new AudioTrackDModel(0);
    public static final AudioTrackDModel LEFT    = new AudioTrackDModel(1);
    public static final AudioTrackDModel RIGHT = new AudioTrackDModel(2);
    public static final AudioTrackDModel MONO = new AudioTrackDModel(3);

    private int type;
    private AudioTrackDModel(int type){
        this.type = type;
    }
}
