package com.company;

/**
 * Created by Helen on 10/8/14.
 */
public class StickGameEvent extends Event{

    private int frisbeeSize;

    public void setFrisbeeSize(int frisbeeSize) {
        this.frisbeeSize = frisbeeSize;
    }

    public int getFrisbeeSize() {
        return frisbeeSize;
    }

    public String getExtraInfo(){

        return this.frisbeeSize + " ";
    }
}
