package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Helen on 11/2/14.
 */
public class TeamManager {

    private List<Olympian> male;
    private List<Olympian>female;
    private Olympian[] shorter;
    private Olympian[] longer;
    private Olympian[] Roster;
    public Team[] teams;

    public TeamManager() {

        OlympianManager OlympianManager = new OlympianManager();
        //Turn array list of Olympian to an array
        Roster = OlympianManager.list.toArray(new Olympian[OlympianManager.list.size()]);
        //The number of total Olympians
        int players = Roster.length;

        //Creates an array list for each gender
        male = new ArrayList<Olympian>();
        female = new ArrayList<Olympian>();
        for (int i = 0; i < players; i++) {
            if (Roster[i].getSex() == Sex.MALE) {
                male.add(Roster[i]);
            } else {
                female.add(Roster[i]);
            }
        }

        //The number of Olympians for each gender
        int M = male.size();
        int F = female.size();
        int n = M+F;

        //Turns gender list arrays to arrays
        Olympian[] males = male.toArray(new Olympian[M]);
        Olympian[] females = female.toArray(new Olympian[F]);
        //Classifies the gender arrays based on number of Olympians in each
        if (M > F){
            longer = males;
            shorter = females;
        }else{
            longer = females;
            shorter = males;
        }

        int S = shorter.length;
        int omission = 0;

        //Creates teams
        teams = new Team[n/2];
        for (int i = 0; i < S;i++ ){

            Olympian Olympian1 =  new Olympian(shorter[i].getName(),shorter[i].getSex(),shorter[i].getAge());
            Olympian Olympian2 =  new Olympian(longer[i].getName(),longer[i].getSex(),longer[i].getAge());

            teams[i] = new Team(Olympian1, Olympian2, omission, omission);
        }
        for (int i = S; i < n/2; i++){
            int other = i + n/2 - S;
            Olympian Olympian1 =  new Olympian(longer[i].getName(),longer[i].getSex(),longer[i].getAge());
            Olympian Olympian2 =  new Olympian(longer[other].getName(),longer[other].getSex(),longer[other].getAge());

            teams[i] = new Team(Olympian1, Olympian2, omission, omission);
        }
    }
}
