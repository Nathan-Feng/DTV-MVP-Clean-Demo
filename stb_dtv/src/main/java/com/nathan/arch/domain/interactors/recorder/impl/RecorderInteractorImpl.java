package com.nathan.arch.domain.interactors.recorder.impl;

import com.nathan.arch.domain.interactors.recorder.RecorderInteractor;
import com.nathan.arch.domain.model.PlaySpeed;
import com.nathan.arch.domain.model.RecorderFileUnitDModel;
import com.nathan.arch.domain.model.TimeProgressDModel;
import com.nathan.arch.domain.repository.RecorderRepository;
import com.nathan.arch.storage.RecorderRepositoryImpl;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class RecorderInteractorImpl implements RecorderInteractor,RecorderRepository.Callback {

    private RecorderInteractor.Callback mCallback;

    private RecorderRepository recorderRepository;

    public RecorderInteractorImpl(){
        recorderRepository = RecorderRepositoryImpl.getInstance();
    }


    @Override
    public void showError(String message) {
        mCallback.showError(message);
    }

    @Override
    public void showFilePlayEnd() {
        mCallback.showFilePlayEnd();
    }

    @Override
    public void showFilePlayPasswordDialog() {
        mCallback.showFilePlayPasswordDialog();
    }


    @Override
    public void showDeleteALLFileOK() {
        mCallback.showDeleteALLFileSuccess();
    }

    @Override
    public void showFilePlayStartOK() {
        mCallback.showFilePlayStartSuccess();
    }

    @Override
    public void showFilePlayStartFailed() {
        mCallback.showFilePlayStartFailed();
    }

    @Override
    public void showPlayingFilePauseOK() {
        mCallback.showPlayingFilePauseSuccess();
    }


    @Override
    public void showCurrentPlaySpeed(PlaySpeed speed) {
        mCallback.showCurrentPlaySpeed(speed);
    }

    @Override
    public void startFilePlay(RecorderFileUnitDModel model) {
        recorderRepository.startFilePlay(model);
    }

    @Override
    public void getAllFileList() {
        Timber.d("Nathan getAllFileList start");
        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                Timber.d("Nathan onSubscribe");
                // retrieve the message
                List<RecorderFileUnitDModel> mList = recorderRepository.getALLFileList();

                if (mList == null || mList.size() == 0) {
                    emitter.onError(new Throwable(" getAllFileList == null"));
                    Timber.d("Nathan onSubscribe mList == null");
                }else {
                    emitter.onNext(mList);
                }
                emitter.onComplete();
            }
        });
        Observer observer = new Observer<List<RecorderFileUnitDModel>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Timber.d("Nathan onSubscribe");
            }

            @Override
            public void onNext(List<RecorderFileUnitDModel> s) {
                Timber.d("Nathan onNext get List ");
                // we have retrieved our message, notify the UI on the main thread
                mCallback.showAllFileList(s);
            }

            @Override
            public void onError(Throwable e) {
                Timber.d("Nathan onError "+e.getMessage());
                mCallback.showAllFileList(null);
            }

            @Override
            public void onComplete() {
                Timber.d("Nathan onComplete ");
            }
        };

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        Timber.d("Nathan end ");
    }

    @Override
    public void deleteAllFiles() {
        recorderRepository.deleteALLFiles();
    }

    @Override
    public boolean deleteCurrentPlayingFile() {
       return recorderRepository.deletePlayFile();
    }

    @Override
    public boolean deleteOneFile(RecorderFileUnitDModel model) {
        return recorderRepository.deleteOneFile(model);
    }

    @Override
    public String getFilePlayResolution() {
        String reso = recorderRepository.getFilePlayResolution();
       return reso;
    }

    @Override
    public String getFilePlayDuration() {
        String duration = recorderRepository.getFilePlayDuration();
        return duration;
    }

    @Override
    public boolean setFilePlayPos(int left, int top, int width, int height) {
        return recorderRepository.setFilePlayPos(left,top,width,height);
    }

    @Override
    public TimeProgressDModel getFilePlayTime() {
        return recorderRepository.getFilePlayTime();
    }

    @Override
    public boolean pauseOrPlayFile() {
        return recorderRepository.pauseOrPlayFile();
    }

    @Override
    public boolean stopPlayingFile() {
        return recorderRepository.stopPlayingFile();
    }

    @Override
    public boolean playingFileFastForward() {
        return recorderRepository.playingFileFastForward();
    }

    @Override
    public boolean playingFileFastRewind() {
        return recorderRepository.playingFileFastRewind();
    }

    @Override
    public boolean filePlaySeek(int second) {
        return recorderRepository.FilePlaySeek(second);
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        recorderRepository.attach(this);
    }

    @Override
    public PlaySpeed getCurrentSpeed() {
        return recorderRepository.getCurrentSpeed();
    }

    @Override
    public boolean pauseRecorderFile() {
        return recorderRepository.pauseRecorderFile();
    }

    @Override
    public boolean checkFilePlayIsPause() {
        return recorderRepository.checkFilePlayIsPause();
    }

    @Override
    public void playNextFile() {
        recorderRepository.playNextFile();
    }

    @Override
    public void playPreviousFile() {
        recorderRepository.playPreviousFile();
    }


    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback = null;
        }
        if (EmptyTool.isNotEmpty(recorderRepository)){
            recorderRepository.detach();
            recorderRepository = null;
        }
    }
}
