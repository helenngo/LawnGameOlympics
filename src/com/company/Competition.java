package com.company;

/**
 * Created by Helen on 11/13/14.
 */
public class Competition {

    private Event event;
    private Team team1;
    private Team team2;

    public Competition (Event event, Team team1, Team team2){
        this.event = event;
        this.team1 = team1;
        this.team2 = team2;
    }

    public void setEvent(Event event){
        this.event = event;
    }

    public Event getEvent(){
        return this.event;
    }

    public void setTeam1(Team team1){
        this.team1 = team1;
    }

    public Team getTeam1(){
        return this.team1;
    }

    public void setTeam2(Team team2){
        this.team2 = team2;
    }

    public Team getTeam2(){
        return this.team2;
    }
}
