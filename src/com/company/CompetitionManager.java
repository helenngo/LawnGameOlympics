package com.company;

import sun.jvm.hotspot.HelloWorld;

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

    private Competition head;
    private Competition tail;

    //adds a new competition to the linked list
    public void startCompetition(Event event, Team team1, Team team2) {
        Competition select = new Competition(event, team1, team2);
        if (tail == null) {
            head = select;
        } else {
            tail.next = select;
            select.prev = tail;
        }
        tail = select;
    }

    //removes a competition from the linked list
    public void endCompetition(ICompetition competition, Team winningTeam) {
        for (Competition curr = head; curr.next != null; curr = curr.next) {
            if(curr == competition) {
                if(curr.prev != null && curr.next != null){
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }else if (curr.prev == null && curr.next == null){
                    head = null;
                    tail = null;
                }else if(curr.prev == null){
                    head = curr.next;
                    curr.next.prev = null;
                }else if (curr.next == null){
                    tail = curr.prev;
                    curr.prev.next = null;
                }
                break;
            }
        }

        //indicates the winning and the losing teams, then passes those teams into event so that they can enqueued and stacked accordingly
        if (competition.getTeam1() == winningTeam){
            competition.getTeam1().indicateWin();
            competition.getTeam2().indicateLosses();
            competition.getEvent().ReturnTeams(competition.getTeam1(),competition.getTeam2());

        }else{
            competition.getTeam2().indicateWin();
            competition.getTeam1().indicateLosses();
            competition.getEvent().ReturnTeams(competition.getTeam2(),competition.getTeam1());
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