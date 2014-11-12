package com.company;

/**
 * Created by Helen on 10/8/14.
 */
public class CornHoleEvent extends Event{

    private int numBeanBags;

    public void setNumBeanBags(int numBeanBags) {

        this.numBeanBags = numBeanBags;
    }

    public int getNumBeanBags() {

        return numBeanBags;
    }

    public String getExtraInfo(){

        return this.numBeanBags + " ";
    }
}
