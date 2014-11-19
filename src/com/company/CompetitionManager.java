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

    //constructs an array from linked list
    public ICompetition[]getCompetitions(){
        ArrayList myArray = new ArrayList();
        for(Competition curr = head; curr != null; curr = curr.next){
            myArray.add(curr);
        }
        return (ICompetition[])myArray.toArray();
    }

    //removes a competition from the linked list
    public void endCompetition(ICompetition competition, Team winningTeam){
        Competition select = new Competition(event, team1, team2);
        for (Competition curr = head; curr == competition; curr = curr.next){
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            curr.next = null;
            curr.next = null;
        }
    }

}
