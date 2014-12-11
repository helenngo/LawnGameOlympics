package com.company;

/**
 * Created by Helen on 12/9/14.
 */
public class PlacingStack {

    private Team head;

    void push(Team listTeam){
        listTeam.next = head;
        head = listTeam;
    }

    Team pop() throws Exception{
        if(head == null){
            throw new Exception("Nothing to pop.");
        }
        Team listTeam = head;
        head = listTeam.next;
        return listTeam;
    }
}

