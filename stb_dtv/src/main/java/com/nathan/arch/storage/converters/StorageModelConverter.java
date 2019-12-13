package com.nathan.arch.storage.converters;


import com.nathan.arch.domain.model.PlaySpeed;
import com.nathan.arch.domain.model.SearchFreqInfoDModel;
import com.nathan.arch.domain.model.SwitchOnOffDModel;
import com.nathan.arch.domain.model.TimeDModel;
import com.nathan.arch.domain.model.TimeProgressDModel;
import com.nathan.arch.storage.model.ScanFreqItem;
import com.nathan.arch.storage.model.SwitchOnOffSModel;
import com.nathan.arch.storage.model.TimeProgressSModel;
import com.nathan.arch.storage.model.TimeSModel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nathan
 */
public class StorageModelConverter {

    private static final int NUMBER = 1024;

    public static PlaySpeed convertToPlaySpeed(int speed){
        if (speed == PlaySpeed.NORMAL_B.getSpeed() || speed == PlaySpeed.NORMAL_F.getSpeed()){
            return PlaySpeed.NORMAL;
        }
//        if (speed == PlaySpeed.NORMAL_F.getSpeed()){
//            return PlaySpeed.NORMAL_F;
//        }
        if (speed == PlaySpeed.FORWARD_2X.getSpeed()){
            return PlaySpeed.FORWARD_2X;
        }
        if (speed == PlaySpeed.FORWARD_4X.getSpeed()){
            return PlaySpeed.FORWARD_4X;
        }
        if (speed == PlaySpeed.FORWARD_8X.getSpeed()){
            return PlaySpeed.FORWARD_8X;
        }
        if (speed == PlaySpeed.FORWARD_16X.getSpeed()){
            return PlaySpeed.FORWARD_16X;
        }
        if (speed == PlaySpeed.FORWARD_32X.getSpeed()){
            return PlaySpeed.FORWARD_32X;
        }
        if (speed == PlaySpeed.BACKWARD_2X.getSpeed()){
            return PlaySpeed.BACKWARD_2X;
        }
        if (speed == PlaySpeed.BACKWARD_4X.getSpeed()){
            return PlaySpeed.BACKWARD_4X;
        }
        if (speed == PlaySpeed.BACKWARD_8X.getSpeed()){
            return PlaySpeed.BACKWARD_8X;
        }
        if (speed == PlaySpeed.BACKWARD_16X.getSpeed()){
            return PlaySpeed.BACKWARD_16X;
        }
        if (speed == PlaySpeed.BACKWARD_32X.getSpeed()){
            return PlaySpeed.BACKWARD_32X;
        }
        return null;
    }

    public static List<SearchFreqInfoDModel> convertToSearchFreqModel(List<ScanFreqItem> mListFreqData){
        List<SearchFreqInfoDModel> mSearchFreqInfoDModel = new ArrayList<>();
        if (mListFreqData != null && mListFreqData.size() >0){
            for (int i = 0;i < mListFreqData.size(); i++){
                ScanFreqItem item = mListFreqData.get(i);
                SearchFreqInfoDModel model = new SearchFreqInfoDModel(item.Total,
                        item.currCount,item.Freq,item.SymbolRate,item.Qam,item.Status);
                mSearchFreqInfoDModel.add(model);
            }
        }
        return mSearchFreqInfoDModel;
    }



    private static String getFileSize(long length){
        String fileSize = null;
        DecimalFormat format = new DecimalFormat("#.##");
        if (0 == (length /NUMBER)){
            float size = (float) length;
            fileSize = format.format(size) + "B";
        } else if (0 == (length/(NUMBER*NUMBER))){
            float size = ((float)length)/NUMBER;
            fileSize = format.format(size) + "KB";
        } else if (0 == (length/(NUMBER*NUMBER*NUMBER))){
            float size = ((float)length)/(NUMBER*NUMBER);
            fileSize = format.format(size) + "MB";
        } else {
            float size = ((float) length) / (NUMBER*NUMBER*NUMBER);
            fileSize = format.format(size)+"GB";
        }
        return fileSize;
    }


    public static TimeDModel convertToTimeDModel(TimeSModel sModel){
        TimeDModel dModel = new TimeDModel(sModel.getYear(),sModel.getMonth(),sModel.getDay(),
                sModel.getHour(),sModel.getMinute(),sModel.getSecond());
        return dModel;
    }


    public static SwitchOnOffSModel convertToSwitchSModel(SwitchOnOffDModel dModel){
        if (dModel == SwitchOnOffDModel.OFF) {
            return SwitchOnOffSModel.OFF;
        }
        if (dModel == SwitchOnOffDModel.ON) {
            return SwitchOnOffSModel.ON;
        }
        return SwitchOnOffSModel.OFF;
    }

    public static TimeProgressDModel convertToTimeProgressDModel(TimeProgressSModel sModel){
        TimeProgressDModel dModel = new TimeProgressDModel();
        dModel.setStartTime(sModel.getStartTime());
        dModel.setPlayTime(sModel.getPlayTime());
        dModel.setTotalTime(sModel.getTotalTime());
        dModel.setPercent(sModel.getPercent());
        dModel.setStartTimeDModel(convertToTimeDModel(sModel.getStartTimeSModel()));
        dModel.setPlayTimeDModel(convertToTimeDModel(sModel.getPlayTimeSModel()));
        dModel.setNowTimeDModel(convertToTimeDModel(sModel.getNowTimeSModel()));
        return dModel;
    }

}
