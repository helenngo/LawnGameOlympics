package com.company;

/**
 * Created by Helen on 11/2/14.
 */
public class Team {

    private Olympian olympian1;
    private Olympian olympian2;
    private int wins;
    private int losses;

    public Team (Olympian olympian1, Olympian olympian2, int wins, int losses ){
        this.olympian1 = olympian1;
        this.olympian2 = olympian2;
        this.wins = wins;
        this.losses = losses;
    }

    public void setOlympian1(Olympian olympian1){
        this.olympian1 = olympian1;
    }

    public Olympian getOlympian1(){
        return this.olympian1;
    }

    public void setOlympian2(Olympian olympian2){
        this.olympian2 = olympian2;
    }

    public Olympian getOlympian2(){
        return this.olympian2;
    }

    public void setWins(int wins){
        this.wins = wins;
    }

    public int getWins(){
        return this.wins;
    }

    public void setLosses(int losses){
        this.losses = losses;
    }

    public int getLosses(){
        return this.losses;
    }
}
