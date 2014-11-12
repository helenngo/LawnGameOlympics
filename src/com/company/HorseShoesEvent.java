package com.company;

/**
 * Created by Helen on 10/8/14.
 */
public class HorseShoesEvent extends Event{

    private int numHorseShoes;

    public void setNumHorseShoes(int numHorseShoes) {

        this.numHorseShoes = numHorseShoes;
    }

    public int getNumHorseShoes() {

        return numHorseShoes;
    }

    public String getExtraInfo(){

        return this.numHorseShoes + " ";
    }
}
