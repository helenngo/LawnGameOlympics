package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Helen on 11/2/14.
 */
public class TeamManager {

    List<Olympian> male;
    List<Olympian>female;
    Olympian[] shorter;
    Olympian[] longer;
    Olympian[] Roster;
    Olympian[] randomRoster;
    Random arbitrary = new Random();
    int players = Roster.length;
    int random = arbitrary.nextInt(players-1);
    Olympian person = Roster[random];
    Team[] teams;

    public void TeamManager() {

        OlympianManager OlympianManager = new OlympianManager();
        Roster = OlympianManager.list.toArray(new Olympian[OlympianManager.list.size()]);

        for (int i = 0; i < players; i++ ){
            random = arbitrary.nextInt(players-1);
            while (person == null){
                random = arbitrary.nextInt(players-1);
            }
            randomRoster[i]= new Olympian(person.getName(),person.getSex(),person.getAge());
            person = null;
        }


        male = new ArrayList<Olympian>();
        female = new ArrayList<Olympian>();
        for (int i = 0; i < players; i++) {
            if (randomRoster[i].getSex() == Sex.MALE) {
                male.add(randomRoster[i]);
            } else {
                female.add(randomRoster[i]);
            }
        }

        int M = male.size();
        int F = female.size();
        int n = M+F;

        Olympian[] males = male.toArray(new Olympian[M]);
        Olympian[] females = female.toArray(new Olympian[F]);
        if (M > F){
            longer = males;
            shorter = females;
        }else{
            longer = females;
            shorter = males;
        }

        int S = shorter.length;
        int omission = 0;

        teams = new Team[n/2];
        for (int i = 0; i < S;i++ ){
            teams[i].getOlympian1() = Olympian(shorter[i].getName(),shorter[i].getSex(),shorter[i].getAge());
            teams[i].getOlympian2() = Olympian(longer[i].getName(),longer[i].getSex(),longer[i].getAge());
            teams[i].getWins() = omission;
            teams[i].getLosses() = omission;
        }
        for (int i = S; i < n/2; i++){
            int other = i + n/2 - S;
            teams[i].getOlympian1() = Olympian(longer[i].getName(),longer[i].getSex(),longer[i].getAge());
            teams[i].getOlympian2() = Olympian(longer[other].getName(),longer[other].getSex(),longer[other].getAge());
            teams[i].getWins() = omission;
            teams[i].getLosses() = omission;
        }
    }
}
