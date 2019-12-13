package com.nathan.arch.storage.model;

import com.nathan.arch.domain.model.ModulationQAM;

public class ScanFreqItem {

    public int Total;

    public int currCount;

    public int Freq;

    public int SymbolRate;

    public ModulationQAM Qam;

    public String Status;

    public int Sat;

    @Override
    public String toString() {
        return "ScanFreqItem{" +
                "Total=" + Total +
                ", currCount=" + currCount +
                ", Freq=" + Freq +
                ", SymbolRate=" + SymbolRate +
                ", Qam=" + Qam +
                ", Status='" + Status + '\'' +
                ", Sat=" + Sat +
                '}';
    }
}
