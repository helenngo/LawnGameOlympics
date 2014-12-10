package com.company;


import java.io.IOException;

/**
 * Created by Helen on 10/8/14.
 */
public abstract class Event {

    public String name;
    private int playTo;
    private boolean isPlaytoExact;
    private int playDistance;
    private Team first;
    private Team last;
    private Team winner;
    private Team loser;

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

    Team[]PeekNextTeams(){
        Team[] peek = new Team[2];
        if(first != null){
            peek[0] = last;
            peek[1] = last.prev;
        }
        return (peek);
    }

    Team[]GetNextTeams(){
        BracketQueue BQ = new BracketQueue();
        Team[] get = new Team[2];
        try {
            get[0] = BQ.dequeue();
            get[1] = BQ.dequeue();
        }
        catch (Exception e){
            System.out.println("There are no more teams to dequeue.");
        }
        return (get);
    }

    void ReturnTeams(Team winner, Team loser){
        PlacingStack PS = new PlacingStack();
        BracketQueue BQ = new BracketQueue();
        PS.push(loser.getOlympian1(),loser.getOlympian2(),loser.getWins(),loser.getLosses());
        BQ.enqueue(winner.getOlympian1(),winner.getOlympian2(),winner.getWins(),winner.getLosses());
        if(winner == first){
            PS.push(winner.getOlympian1(),winner.getOlympian2(),winner.getWins(),winner.getLosses());
        }
    }
}
