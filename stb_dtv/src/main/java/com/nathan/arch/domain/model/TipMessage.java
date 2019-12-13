package com.nathan.arch.domain.model;

public class TipMessage{

    public static final TipMessage TIPMSG_SIGNAL_OK         = new TipMessage(-1);
    public static final TipMessage TIPMSG_PARENTAL_RATING   = new TipMessage(0);
    public static final TipMessage TIPMSG_NOPROGRAM         = new TipMessage(1);
    public static final TipMessage TIPMSG_NOSIGNAL          = new TipMessage(2);
    public static final TipMessage TIPMSG_FRONTEND_ERROR    = new TipMessage(3);
    public static final TipMessage TIPMSG_CA                = new TipMessage(4);

    private int mess;
    private TipMessage(int mess){
        this.mess = mess;
    }

    @Override
    public String toString() {
        return "TipMessage{" +
                "mess=" + mess +
                '}';
    }
}

