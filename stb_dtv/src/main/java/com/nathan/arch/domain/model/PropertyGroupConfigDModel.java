package com.nathan.arch.domain.model;

/**
 * @author Nathan
 */
public class PropertyGroupConfigDModel {

    /**
     *
     */
    public static final PropertyGroupConfigDModel PC_RATE = new PropertyGroupConfigDModel(100);


    public static final PropertyGroupConfigDModel TIMESHIFT_LENGTH = new PropertyGroupConfigDModel(2);
    public static final PropertyGroupConfigDModel PVR_START_INADV = new PropertyGroupConfigDModel(3);
    public static final PropertyGroupConfigDModel PVR_END_DELAY = new PropertyGroupConfigDModel(4);



    public static final PropertyGroupConfigDModel EPG_LANG = new PropertyGroupConfigDModel(5);
    public static final PropertyGroupConfigDModel SUBTITLE_LANG = new PropertyGroupConfigDModel(6);
    public static final PropertyGroupConfigDModel SUBTITLE_LANG2 = new PropertyGroupConfigDModel(6);
//    public static final PropertyGroupConfigDModel TELETEXTLANG = new PropertyGroupConfigDModel(7);
    public static final PropertyGroupConfigDModel AUDIO_LANG0 = new PropertyGroupConfigDModel(8);
    public static final PropertyGroupConfigDModel AUDIO_LANG1 = new PropertyGroupConfigDModel(9);
    public static final PropertyGroupConfigDModel AUDIO_LANG2 = new PropertyGroupConfigDModel(9);
    public static final PropertyGroupConfigDModel DIG_AUDIO_BYPASS = new PropertyGroupConfigDModel(10);
    public static final PropertyGroupConfigDModel TRACK_OF_UNIFY = new PropertyGroupConfigDModel(11);

    public static final PropertyGroupConfigDModel UTC_TOT_REGION_ID = new PropertyGroupConfigDModel(12);

    /**
     * SCREEN_RATIO : 4:3,16:9
     * ASPECT_RATIO: pan_scan,combined,letter box,ignore
     */
    public static final PropertyGroupConfigDModel SCREEN_RATIO = new PropertyGroupConfigDModel(13);
    public static final PropertyGroupConfigDModel ASPECT_RATIO = new PropertyGroupConfigDModel(14);

    public static final PropertyGroupConfigDModel DURATION_TIME  = new PropertyGroupConfigDModel(15);
    public static final PropertyGroupConfigDModel P_SHOW_NO_TYPE  = new PropertyGroupConfigDModel(16);
    public static final PropertyGroupConfigDModel P_SORT_TYPE  = new PropertyGroupConfigDModel(17);

    private int type;
    private PropertyGroupConfigDModel(int type){
        this.type = type;
    }

    public int getValue(){
        return type;
    }

    @Override
    public String toString() {
        return "PropertyGroupConfigDModel{" +
                "type=" + type +
                '}';
    }
}
