package com.company;

/**
 * Created by Helen on 12/9/14.
 */
public class BracketQueue {
    private Team first;
    private Team last;

    //adds a new team to the queue
    public void enqueue(Olympian olympian1, Olympian olympian2, int wins, int losses) {
            Team newTeam = new Team(olympian1, olympian2, wins, losses);
            if (last != null) {
                last.next = newTeam;
            }
            last = newTeam;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public Team dequeue() throws Exception{
        Team currTeam = first;
        if (first == null) {
            throw new Exception("Nothing to dequeue");
        }
        first = first.next;
        if(first == null){
            last = null;
        }
        return currTeam;
    }

    Team[]PeekNextTeams(){
        Team[] peek = new Team[2];
        if(isEmpty() == false){
            peek[0] = last;
            peek[1] = last.prev;
        }
        return (peek);
    }
}
