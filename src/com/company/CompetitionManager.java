package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Helen on 11/13/14.
 */
public class CompetitionManager {

    private static TeamManager TeamManager = new TeamManager();
    private Competition head;
    private Competition tail;
    Event event;
    Team team1;
    Team team2;

    //adds a new competition to the linked list
    public void startCompetition() {
        Competition select = new Competition(event, team1, team2);
        if (tail == null) {
            head = select;
        } else {
            tail.next = select;
        }
        tail = select;
    }

    //removes a competition from the linked list
    public void endCompetition(ICompetition competition, Team winningTeam) {
        for (Competition curr = head; curr.next != null; curr = curr.next) {
            if(curr == competition) {
                if(curr.prev != null || curr.next != null){
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }else if (curr.prev == null && curr.next == null){
                    head = null;
                    tail = null;
                }else if(curr.prev == null){
                    head = curr.next;
                    curr.next.prev = head;
                }else if (curr.next == null){
                    tail = curr.prev;
                    curr.prev.next = tail;
                }
                break;
            }
        }

        int team1Wins = team1.getWins();
        int team1Losses = team1.getLosses();
        int team2Wins = team2.getWins();
        int team2Losses = team2.getLosses();

        if (team1 == winningTeam){
            team1.setWins(team1Wins++);
            team2.setLosses(team2Losses++);
        }else{
            team1.setLosses(team1Losses++);
            team2.setWins(team2Wins++);
        }
    }

    //constructs an array from linked list
    public ICompetition[]getCompetitions(){
        ArrayList myArray = new ArrayList();
        for(Competition curr = head; curr != null; curr = curr.next){
            myArray.add(curr);
        }
        return (ICompetition[])myArray.toArray( new ICompetition[myArray.size()]);
    }
}