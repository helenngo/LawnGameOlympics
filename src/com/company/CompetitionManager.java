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

/*    public CompetitionManager() {
        EventManager EventManager = new EventManager();
        TeamManager TeamManager = new TeamManager();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine(); //returns user input as string
            String[] selection = input.split(","); //splits the string and puts into array
            int[] index = new int[3];//size of the array (event, team1, team2)

            //casts strings into integers so it can be used as index numbers
            for (int i = 0; i < 3; i++) {
                index[i] = Integer.parseInt(selection[i]);
            }

            int a = index[0];//index number for event
            int b = index[1];//index number for team1
            int c = index[2];//index number for team 2

            event = EventManager.eventsArray[a];//assigns the event in the competition
            //assigns the teams in the competition
            team1 = TeamManager.teams[b];
            team2 = TeamManager.teams[c];

        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found");
        } catch (IOException ioe) {
            System.out.println("Problem reading from file");
        }
*/
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
                curr.prev = curr;
                curr = curr.next;
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