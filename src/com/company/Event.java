package com.company;

/**
 * Created by Helen on 10/8/14.
 */
public abstract class Event {

    public String name;
    private int playTo;
    private boolean isPlaytoExact;
    private int playDistance;

    public abstract String getExtraInfo();

    public void setName(String name){

        this.name = name;
    }

    public String getName(){

        return this.name;
    }

    public void setPlayTo(int playTo){

        this.playTo = playTo;
    }

    public int getPlayTo(){

        return this.playTo;
    }

    public void setIsPlaytoExact(boolean isPlaytoExact){

        this.isPlaytoExact = isPlaytoExact;
    }

    public boolean getIsPlaytoExact(){
        return this.isPlaytoExact;
    }


    public void setPlayDistance(int playDistance){

        this.playDistance = playDistance;
    }

    public int getPlayDistance(){

        return this.playDistance;
    }
}
