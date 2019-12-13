package com.nathan.arch.presentation.presenters;


import com.nathan.arch.domain.model.PlaySpeed;
import com.nathan.arch.domain.model.RecorderFileUnitDModel;
import com.nathan.arch.domain.model.TimeProgressDModel;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.presentation.ui.IDVBBaseCallback;

import java.util.List;

/**
 * For DVB Recorder control
 *
 */
public interface IDVBRecorderPresenter extends IDVBBasePresenter {

    void attach(Callback callback);
    void attach(AllFilesCallback callback);
    interface AllFilesCallback extends IDVBBaseCallback {
        void showAllFileList(List<RecorderFileUnitDModel> mList);
    }
    interface Callback extends IDVBBaseCallback {
        void showFilePlayEnd();
        void showFilePlayPasswordDialog();
        void showDeleteOneFileSuccess();
        void showDeleteAllFileSuccess();
        void showFilePlayStartSuccess();
        void showFilePlayStartFailed();
        void showAllFileList(List<RecorderFileUnitDModel> mList);
        void showCurrentPlaySpeed(PlaySpeed speed);
        void showPlayingFilePauseSuccess();
    }
    void startFilePlay(RecorderFileUnitDModel model);
    void getAllFileList();
    void deleteAllFiles();
    boolean deleteCurrentPlayingFile();
    boolean deleteOneFile(RecorderFileUnitDModel model);
    String getFilePlayResolution();
    String getFilePlayDuration();
    boolean setFilePlayPos(int left, int top, int width, int height);
    TimeProgressDModel getFilePlayTime();

    /**
     *
     */
    boolean pauseOrPlayFile();
    boolean stopPlayingFile();
    boolean fastForwardPlayingFile();
    boolean fastRewindPlayingFile();
    boolean seekPlayingFile(int second);

    PlaySpeed getCurrentSpeed();
    boolean pauseRecorderFile();
    boolean checkFilePlayIsPause();
    void playNextFile();
    void playPreviousFile();
}
