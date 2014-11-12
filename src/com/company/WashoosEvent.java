package com.company;

/**
 * Created by Helen on 10/8/14.
 */
public class WashoosEvent extends Event{

    private boolean hasAutoWinStick;
    private int numWashoos;

    public void setHasAutoWinStick(boolean hasAutoWinStick) {

        this.hasAutoWinStick = hasAutoWinStick;
    }

    public boolean getHasAutoWinStick() {

        return hasAutoWinStick;
    }

    public String getExtraInfo(){

        return this.hasAutoWinStick + " "+ numWashoos;
    }

    public void setNumWashoos(int numWashoos) {

        this.numWashoos = numWashoos;
    }

    public int getNumWashoos() {

        return numWashoos;
    }
}
