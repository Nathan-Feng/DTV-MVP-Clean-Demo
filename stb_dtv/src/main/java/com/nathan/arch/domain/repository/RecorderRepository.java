package com.nathan.arch.domain.repository;


import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.PlaySpeed;
import com.nathan.arch.domain.model.RecorderFileUnitDModel;
import com.nathan.arch.domain.model.TimeProgressDModel;

import java.util.List;

/**
 * A repository that is responsible for getting our welcome message.
 */
public interface RecorderRepository extends Interactor {
    void attach(Callback callback);
    interface Callback  {
        void showError(String message);
        void showFilePlayEnd();
        void showFilePlayPasswordDialog();
        void showDeleteALLFileOK();
        void showFilePlayStartOK();
        void showFilePlayStartFailed();
        void showPlayingFilePauseOK();

        void showCurrentPlaySpeed(PlaySpeed speed);
    }

    void startFilePlay(RecorderFileUnitDModel model);
    List<RecorderFileUnitDModel> getALLFileList();
    void deleteALLFiles();
    boolean deletePlayFile();
    boolean deleteOneFile(RecorderFileUnitDModel model);
    String getFilePlayResolution();
    String getFilePlayDuration();
    boolean setFilePlayPos(int left,int top,int width,int height);
    TimeProgressDModel getFilePlayTime();


    boolean pauseOrPlayFile();
    boolean stopPlayingFile();
    boolean playingFileFastForward();
    boolean playingFileFastRewind();
    boolean FilePlaySeek(long second);

    PlaySpeed getCurrentSpeed();
    boolean pauseRecorderFile();
    boolean checkFilePlayIsPause();

    void playNextFile();
    void playPreviousFile();
}
