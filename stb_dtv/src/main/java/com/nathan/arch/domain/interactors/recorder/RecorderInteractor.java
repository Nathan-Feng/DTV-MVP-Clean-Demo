package com.nathan.arch.domain.interactors.recorder;


import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.PlaySpeed;
import com.nathan.arch.domain.model.RecorderFileUnitDModel;
import com.nathan.arch.domain.model.TimeProgressDModel;

import java.util.List;

/**
 * A repository that is responsible for getting our welcome message.
 */
public interface RecorderInteractor extends Interactor {

    interface Callback extends IDVBBaseInteractorCallback {
        void showFilePlayEnd();
        void showFilePlayPasswordDialog();
        void showDeleteALLFileSuccess();
        void showFilePlayStartSuccess();
        void showFilePlayStartFailed();
        void showCurrentPlaySpeed(PlaySpeed speed);
        void showPlayingFilePauseSuccess();
        void showAllFileList(List<RecorderFileUnitDModel> mList);
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

    boolean pauseOrPlayFile();
    boolean stopPlayingFile();
    boolean playingFileFastForward();
    boolean playingFileFastRewind();
    boolean filePlaySeek(int second);
    void attach(Callback callback);

    PlaySpeed getCurrentSpeed();
    boolean pauseRecorderFile();
    boolean checkFilePlayIsPause();
    void playNextFile();
    void playPreviousFile();
}
