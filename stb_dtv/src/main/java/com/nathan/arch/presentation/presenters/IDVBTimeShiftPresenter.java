package com.nathan.arch.presentation.presenters;


import com.nathan.arch.domain.model.PlaySpeed;
import com.nathan.arch.domain.model.TimeProgressDModel;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.presentation.ui.IDVBBaseCallback;

/**
 * For DVB Timeshift control
 *
 */
public interface IDVBTimeShiftPresenter extends IDVBBasePresenter {

    void attach(Callback callback);

    interface Callback extends IDVBBaseCallback{

        /**
         * @param speed callback timeshift FF/FB speed, such as 2x/4x/8x or -2x -4x
         */
        void showCurrentPlaySpeed(PlaySpeed speed);

        /**
         * 当快退时移时，回到起点时回调
         */
        void showTimeShiftPlayBOF();

        /**
         * 当快退时，退到终点时回调
         */
        void showTimeShiftPlayEOF();

        /**
         * when in Timeshift, if USB/sdcard is full ,callback this.
         */
        void showTimeShiftStorageFull();

        /**
         * 启动时移成功时的回调
         */
        void showStartTimeShiftSuccess();

        /**
         * 启动时移失败时的回调
         */
        void showStartTimeShiftFailed();

    }

    /**
     *启动时移，画面暂停
     */
    void startTimeShift();

    /**
     * @return 暂停或者播放时移，返回值代表动作是否成功
     */
    boolean pauseOrPlayTimeShift();

    /**
     * @return 停止时移，返回值代表动作是否成功
     */
    boolean stopTimeShift();

    /**
     * @return 快进时移，
     */
    boolean fastForwardTimeShift();

    /**
     * @return 快退时移
     */
    boolean fastRewindTimeShift();

    /**
     * @return 或者当前时移进度
     */
    TimeProgressDModel getShowTimeShiftProgress();

    /**
     * @param second 选时播放
     */
    boolean seekTimeShift(int second);

    /**
     * @return 返回时移下播放器的状态，true=Pause,
     */
    boolean getTimeShiftPauseStatus();

    /**
     * @return 实时返回当前播放节目的速度
     */
    PlaySpeed getCurrentPlaySpeed();


    boolean playTimeShift();
    boolean pauseTimeShift();
}
