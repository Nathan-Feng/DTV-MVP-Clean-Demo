package com.nathan.arch.presentation.presenters.impl;

import com.nathan.arch.domain.interactors.recorder.RecorderInteractor;
import com.nathan.arch.domain.interactors.recorder.impl.RecorderInteractorImpl;
import com.nathan.arch.domain.model.PlaySpeed;
import com.nathan.arch.domain.model.RecorderFileUnitDModel;
import com.nathan.arch.domain.model.TimeProgressDModel;
import com.nathan.arch.presentation.presenters.IDVBRecorderPresenter;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.storage.tools.EmptyTool;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Nathan on 07/08/19.
 */
public class IDVBRecorderPresenterImpl implements IDVBBasePresenter, IDVBRecorderPresenter,
        RecorderInteractor.Callback  {

    private Callback mCallback;
    private AllFilesCallback mAllFilesCallback;
    private RecorderInteractor recorderInteractor;

    public IDVBRecorderPresenterImpl() {
        initInteractor();
    }

    private void initInteractor(){
        recorderInteractor = new RecorderInteractorImpl();
    }


    @Override
    public void showError(String message) {

    }

    @Override
    public void showFilePlayEnd() {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showFilePlayEnd();
        }
    }

    @Override
    public void showFilePlayPasswordDialog() {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showFilePlayPasswordDialog();
        }
    }


    @Override
    public void showDeleteALLFileSuccess() {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showDeleteAllFileSuccess();
        }
    }

    @Override
    public void showFilePlayStartSuccess() {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showFilePlayStartSuccess();
        }
    }

    @Override
    public void showFilePlayStartFailed() {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showFilePlayStartFailed();
        }
    }


    @Override
    public void showCurrentPlaySpeed(PlaySpeed speed) {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showCurrentPlaySpeed(speed);
        }
    }

    @Override
    public void showPlayingFilePauseSuccess() {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showPlayingFilePauseSuccess();
        }
    }

    @Override
    public void showAllFileList(List<RecorderFileUnitDModel> mList) {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showAllFileList(mList);
        }

        if (EmptyTool.isNotEmpty(mAllFilesCallback)) {
            mAllFilesCallback.showAllFileList(mList);
        }
    }


    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        recorderInteractor.attach(this);
    }

    @Override
    public void attach(AllFilesCallback callback) {
        this.mAllFilesCallback = callback;
        recorderInteractor.attach(this);
    }

    @Override
    public void startFilePlay(RecorderFileUnitDModel model) {
        recorderInteractor.startFilePlay(model);
    }

    @Override
    public void getAllFileList() {
        recorderInteractor.getAllFileList();
    }

    @Override
    public void deleteAllFiles() {
        recorderInteractor.deleteAllFiles();
    }

    @Override
    public boolean deleteCurrentPlayingFile() {
        return recorderInteractor.deleteCurrentPlayingFile();
    }

    @Override
    public boolean deleteOneFile(RecorderFileUnitDModel model) {
        return recorderInteractor.deleteOneFile(model);
    }

    @Override
    public String getFilePlayResolution() {
        return recorderInteractor.getFilePlayResolution();
    }

    @Override
    public String getFilePlayDuration() {
        return recorderInteractor.getFilePlayDuration();
    }

    @Override
    public boolean setFilePlayPos(int left, int top, int width, int height) {
        return recorderInteractor.setFilePlayPos(left,top,width,height);
    }

    @Override
    public TimeProgressDModel getFilePlayTime() {
        return recorderInteractor.getFilePlayTime();
    }

    @Override
    public boolean pauseOrPlayFile() {
        return recorderInteractor.pauseOrPlayFile();
    }

    @Override
    public boolean stopPlayingFile() {
        return recorderInteractor.stopPlayingFile();
    }

    @Override
    public boolean fastForwardPlayingFile() {
       return recorderInteractor.playingFileFastRewind();
    }

    @Override
    public boolean fastRewindPlayingFile() {
        return recorderInteractor.playingFileFastRewind();
    }

    @Override
    public boolean seekPlayingFile(int second) {
        return recorderInteractor.filePlaySeek(second);
    }

    @Override
    public PlaySpeed getCurrentSpeed() {
        return recorderInteractor.getCurrentSpeed();
    }

    @Override
    public boolean pauseRecorderFile() {
        return recorderInteractor.pauseRecorderFile();
    }

    @Override
    public boolean checkFilePlayIsPause() {
        return recorderInteractor.checkFilePlayIsPause();
    }

    @Override
    public void playNextFile() {
        recorderInteractor.playNextFile();
    }

    @Override
    public void playPreviousFile() {
        recorderInteractor.playPreviousFile();
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback = null;
        }

        if (EmptyTool.isNotEmpty(recorderInteractor)){
            recorderInteractor.detach();
            recorderInteractor = null;
        }
    }

    private boolean checkNullable(WeakReference<Callback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }
}
