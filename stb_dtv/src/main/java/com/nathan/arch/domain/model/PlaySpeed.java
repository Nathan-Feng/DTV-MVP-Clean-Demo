package com.nathan.arch.domain.model;

public class PlaySpeed {
    public static final PlaySpeed NORMAL_F    = new PlaySpeed(8);
    public static final PlaySpeed FORWARD_2X  = new PlaySpeed(9);
    public static final PlaySpeed FORWARD_4X  = new PlaySpeed(10);
    public static final PlaySpeed FORWARD_8X  = new PlaySpeed(11);
    public static final PlaySpeed FORWARD_16X = new PlaySpeed(12);
    public static final PlaySpeed FORWARD_32X = new PlaySpeed(13);

    public static final PlaySpeed NORMAL = new PlaySpeed(80);

    public static final PlaySpeed NORMAL_B      = new PlaySpeed(0);
    public static final PlaySpeed BACKWARD_2X   = new PlaySpeed(1);
    public static final PlaySpeed BACKWARD_4X   = new PlaySpeed(2);
    public static final PlaySpeed BACKWARD_8X   = new PlaySpeed(3);
    public static final PlaySpeed BACKWARD_16X  = new PlaySpeed(4);

    @Override
    public String toString() {
        return "PlaySpeed{" +
                "speed=" + speed +
                '}';
    }

    public static final PlaySpeed  BACKWARD_32X = new PlaySpeed(5);

    private int speed;
    private  PlaySpeed (int speed){
        this.speed = speed;
    }

    public int getSpeed(){
        return speed;
    }
}
