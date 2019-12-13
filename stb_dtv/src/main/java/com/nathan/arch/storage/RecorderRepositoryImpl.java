package com.nathan.arch.storage;

import com.nathan.arch.domain.model.PlaySpeed;
import com.nathan.arch.domain.model.RecorderFileUnitDModel;
import com.nathan.arch.domain.model.StorageDModel;
import com.nathan.arch.domain.model.TimeProgressDModel;
import com.nathan.arch.domain.repository.RecorderRepository;
import com.nathan.arch.domain.repository.StorageManagerRepository;
import com.nathan.arch.storage.androidapi.StorageManagerRepositoryImpl;
import com.nathan.arch.storage.converters.StorageModelConverter;
import com.nathan.arch.storage.dvb.ICallbackMultiAudioSubTTXMethod;
import com.nathan.arch.storage.dvb.ICallbackRecorderMethod;
import com.nathan.arch.storage.dvb.impl.MultiAudioSubTTXMethodForFilePlayFromDVB;
import com.nathan.arch.storage.dvb.impl.RecorderMethodFromDVB;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import timber.log.Timber;

/**
 * Created by Nathan on 1/29/16.
 */
public class RecorderRepositoryImpl implements RecorderRepository,RecorderMethodFromDVB.Callback
{
    private ICallbackRecorderMethod recorderMethod ;
    private RecorderRepository.Callback callback;
    private ICallbackMultiAudioSubTTXMethod multiAudioSubTTXMethod;
    private StorageManagerRepository mStorageManagerRepository;
    private List<RecorderFileUnitDModel> allFileModelList = new LinkedList<>();
    private int mCurrentPlayIndex = -1;
    /**
     * set this class to Singleton
     */
    private static RecorderRepositoryImpl instance = null;
    public static synchronized  RecorderRepositoryImpl getInstance(){
        if (instance == null){
            instance=new RecorderRepositoryImpl();
        }
        return instance;
    }

    public RecorderRepositoryImpl(){
        Timber.d("Nathan new RecorderRepositoryImpl :");
        recorderMethod = new RecorderMethodFromDVB(this);
        multiAudioSubTTXMethod =  MultiAudioSubTTXMethodForFilePlayFromDVB.getInstance();
        mStorageManagerRepository = StorageManagerRepositoryImpl.getInstance();
    }

    @Override
    public void attach(Callback mCallback) {
        this.callback = mCallback;
    }


    @Override
    public void showFilePlayStartOK() {
        if (EmptyTool.isNotEmpty(callback)) callback.showFilePlayStartOK();
    }

    @Override
    public void showFilePlayStartFailed() {
        if (EmptyTool.isNotEmpty(callback)) callback.showFilePlayStartFailed();
    }

    @Override
    public void showFilePlayPasswordDialog() {
        if (EmptyTool.isNotEmpty(callback)) callback.showFilePlayPasswordDialog();
    }


    @Override
    public void showDeleteALLFileOK() {
        if (EmptyTool.isNotEmpty(callback)) callback.showDeleteALLFileOK();
    }

    @Override
    public void showPlayingFilePauseOK() {
        if (EmptyTool.isNotEmpty(callback)) callback.showPlayingFilePauseOK();
    }


    @Override
    public void showCurrentPlaySpeed(int speed) {
        PlaySpeed playSpeed = StorageModelConverter.convertToPlaySpeed(speed);
        if (EmptyTool.isNotEmpty(callback)) callback.showCurrentPlaySpeed(playSpeed);
    }

    @Override
    public void showError(String message) {
        if (EmptyTool.isNotEmpty(callback)) callback.showError(message);
    }


    @Override
    public void showFilePlayEnd() {
        if (EmptyTool.isNotEmpty(callback)) callback.showFilePlayEnd();
    }


    @Override
    public void startFilePlay(RecorderFileUnitDModel model) {

    }

    @Override
    public List<RecorderFileUnitDModel> getALLFileList() {
        return null;
    }

    @Override
    public void deleteALLFiles() {
    }

    @Override
    public boolean deletePlayFile() {
        return false;
    }

    @Override
    public boolean deleteOneFile(RecorderFileUnitDModel model) {
        return false;
    }


    @Override
    public String getFilePlayResolution() {
        return "";
    }

    @Override
    public String getFilePlayDuration() {
        return "";
    }

    @Override
    public boolean setFilePlayPos(int left, int top, int width, int height) {
        return false;
    }

    @Override
    public TimeProgressDModel getFilePlayTime() {
        return null;
    }

    @Override
    public boolean pauseOrPlayFile() {
        return false;
    }

    @Override
    public boolean stopPlayingFile() {
        return false;
    }

    @Override
    public boolean playingFileFastForward() {
        return false;
    }

    @Override
    public boolean playingFileFastRewind() {
        return false;
    }

    @Override
    public boolean FilePlaySeek(long second) {
        return false;
    }

    @Override
    public PlaySpeed getCurrentSpeed() {
        return null;
    }

    @Override
    public boolean pauseRecorderFile() {
        return false;
    }

    @Override
    public boolean checkFilePlayIsPause() {
        return false;
    }

    @Override
    public void playNextFile() {
        if (EmptyTool.isNotEmpty(allFileModelList)){
            if (mCurrentPlayIndex == allFileModelList.size()-1){
                startFilePlay(allFileModelList.get(0));
            } else {
                startFilePlay(allFileModelList.get(mCurrentPlayIndex+1));
            }
        }
    }

    @Override
    public void playPreviousFile() {
        if (EmptyTool.isNotEmpty(allFileModelList)){
            if (mCurrentPlayIndex == 0){
                startFilePlay(allFileModelList.get(allFileModelList.size()-1));
            } else {
                startFilePlay(allFileModelList.get(mCurrentPlayIndex-1));
            }
        }
    }


    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(recorderMethod)){
            recorderMethod.detach();
            recorderMethod = null;
        }
        if (EmptyTool.isNotEmpty(callback)){
            callback = null;
        }
        if (EmptyTool.isNotEmpty(multiAudioSubTTXMethod)){
            multiAudioSubTTXMethod.detach();
            multiAudioSubTTXMethod = null;
        }

        if (EmptyTool.isNotEmpty(instance)){
            instance = null;
        }
    }

}
