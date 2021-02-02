package com.johnsaylor.diagnostic;

public class Timer {

    private final long startTime = System.currentTimeMillis();

    public long getElapsedTime(){
        return System.currentTimeMillis() - startTime;
    }

}
