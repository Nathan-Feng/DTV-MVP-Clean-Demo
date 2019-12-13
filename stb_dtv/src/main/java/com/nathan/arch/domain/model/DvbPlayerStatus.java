package com.nathan.arch.domain.model;

public class DvbPlayerStatus {

    public static final DvbPlayerStatus PLAYER_TYPE_TIME_SHIFT_PLAY   = new DvbPlayerStatus(0);
    public static final DvbPlayerStatus PLAYER_TYPE_LIVE         = new DvbPlayerStatus(1);
    public static final DvbPlayerStatus PLAYER_TYPE_PVR_PLAY     = new DvbPlayerStatus(2);
    public static final DvbPlayerStatus PLAYER_TYPE_NULL         = new DvbPlayerStatus(3);

    private int type;
    private DvbPlayerStatus(int type){
        this.type = type;
    }

    @Override
    public String toString() {
        return "DvbPlayerStatus{" +
                "type=" + type +
                '}';
    }
}

