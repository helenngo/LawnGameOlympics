package com.company;

/**
 * Created by Helen on 12/9/14.
 */
public class PlacingStack {

    private Team head;
    private Team listTeam;

    void push(Olympian olympian1, Olympian olympian2, int wins, int losses){
        Team Loser = new Team(olympian1, olympian2, wins, losses);
        listTeam.next = head;
        head = listTeam;
    }
}

