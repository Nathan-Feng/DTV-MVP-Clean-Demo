package com.nathan.arch.storage.dvb.impl;

import com.nathan.arch.domain.model.BookParamDModel;
import com.nathan.arch.storage.dvb.ICallbackBookMethod;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.List;


public class ChannelBookMethodFromDVB implements ICallbackBookMethod {

    private ICallbackBookMethod.Callback callback;


    public ChannelBookMethodFromDVB (Callback callback){
        this.callback = callback;
        initDVB();
    }

    private void initDVB(){

    }

    /**
     * ********************************Public method*******************************************
     */

    @Override
    public boolean  channelBook(BookParamDModel model){

        return false;
    }

    @Override
    public boolean channelBookConflict(BookParamDModel model,int bookId){

        return false;
    }


    @Override
    public boolean deleteOneBookTask(BookParamDModel model){

        return false;
    }

    @Override
    public boolean deleteAllBookTaskList(List<BookParamDModel> taskList){
        for (BookParamDModel dModel : taskList){
            if (!deleteOneBookTask(dModel)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean rebookTask(BookParamDModel model){
        return false;
    }


    @Override
    public boolean rebookConflict(BookParamDModel model,int bookId){
        return false;
    }


    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(callback)) {
            callback = null;
        }
    }

}
