package com.company;

/**
 * Created by Helen on 10/8/14.
 */
public class LadderBallEvent extends Event{

    private int numRungs;

    public void setNumRungs(int numRungs) {

        this.numRungs = numRungs;
    }

    public int getNumRungs() {

        return numRungs;
    }

    public String getExtraInfo(){

        return this.numRungs + " ";
    }
}
