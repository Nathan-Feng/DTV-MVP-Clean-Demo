package com.nathan.arch.domain.model;

public final class ModulationQAM {
    public static final ModulationQAM UNDEFINED = new ModulationQAM(0);
    public static final ModulationQAM QAM16     = new ModulationQAM(1);
    public static final ModulationQAM QAM32     = new ModulationQAM(2);
    public static final ModulationQAM QAM64     = new ModulationQAM(3);
    public static final ModulationQAM QAM128    = new ModulationQAM(4);
    public static final ModulationQAM QAM256    = new ModulationQAM(5);


    private int qam ;
    private ModulationQAM(int qam){
        this.qam = qam;
    }

    public int getValue(){
        return qam;
    }

    public static ModulationQAM getQAM(int value){
        switch (value){
            case 0:
                return UNDEFINED;
            case 1:
                return QAM16;
            case 2:
                return QAM32;
            case 3:
                return QAM64;
            case 4:
                return QAM128;
            case 5:
                return QAM256;
            default:
                break;
        }
        return null;
    }

    public static String getStringName(int value){
        switch (value){
            case 0:
                return "UNDEFINED";
            case 1:
                return "QAM16";
            case 2:
                return "QAM32";
            case 3:
                return "QAM64";
            case 4:
                return "QAM128";
            case 5:
                return "QAM256";
            default:
                break;
        }
        return null;
    }

    @Override
    public String toString() {
        return "ModulationQAM{" +
                "qam=" + qam +
                '}';
    }
}
