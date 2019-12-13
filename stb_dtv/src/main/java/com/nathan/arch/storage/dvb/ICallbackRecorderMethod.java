package com.nathan.arch.storage.dvb;


public interface ICallbackRecorderMethod {

    interface Callback  {
        void showError(String message);
        void showFilePlayEnd();
        void showFilePlayStartOK();
        void showFilePlayStartFailed();
        void showFilePlayPasswordDialog();
        void showDeleteALLFileOK();
        void showPlayingFilePauseOK();
        void showCurrentPlaySpeed(int speed);
    }
    void detach();

}
