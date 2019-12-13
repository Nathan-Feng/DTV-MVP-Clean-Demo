package com.nathan.arch.presentation.presenters;

import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.presentation.ui.IDVBBaseCallback;

import java.util.Map;

/**
 * <p>
 * This interface represents For Multi Audio action.
 * </p>
 */
public interface IDVBMultiAudioSubTTXPresenter extends IDVBBasePresenter {

    void attach(Callback callback);

    /**
     * <p>
     * This interface represents a  Callback to UI.
     * </p>
     */
    interface Callback extends IDVBBaseCallback {
    }


    /**
     * get ALL the Audio List from the current Playing channel
     */
    Map<Integer,String> getAllAudioList();

    /**
     * do get ALL SubtitleList from the current Playing channel
     */
    Map<Integer,String> getAllSubtitleList();

    /**
     * do get ALL the TTX from the current Playing channel
     */
    Map<Integer,String> getAllTTXList();

    /**
     * @param audioIndex set the Audio by index. audioIndex where come from Integer of
     *                   showAllAudioList(List<Map<Integer,String>> audList);
     */
    boolean setAudioByIndex(int audioIndex);

    /**
     * @param subtitleIndex set the Audio by index. audioIndex where come from Integer of
     *                      showAllSubtitleList(List<Map<Integer,String>>  subtitleList)
     */
    boolean setSubtitleByIndex(int subtitleIndex);

    /**
     * @param ttxIndex set the Audio by index. audioIndex where come from Integer of
     *                       showAllTTXList(List<Map<Integer,String>>  ttxList);
     */
    boolean setTTXByIndex(int ttxIndex);

    /**
     * @return 获取当前选择的多音轨的index，默认0
     */
    int getAudioSelectIndex();

    /**
     * @return 获取当前多字幕的index 默认0
     */
    int getSubtitleSelectIndex();

    /**
     * @return 获取当前TTX的index 默认0
     */
    int getTTXSelectIndex();

    void sendTtxKey(int code);

}
