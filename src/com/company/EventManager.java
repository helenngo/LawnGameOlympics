package com.company;

import java.util.Random;

/**
 * Created by Helen on 10/6/14.
 */
public class EventManager{

    Event[] eventsArray = new Event[6];

    public EventManager(TeamManager TM) {

        //enqueue every team into qeueue for every event
        for (int i=0; i>getEvents().length; i++){

            Team[] tempTeam = TM.getTeams();
            tempTeam = RandomizeArray(tempTeam); //randomize the order of the teams that go into queue
            getEvents()[i].startQueue(tempTeam);
        }

        CanJamEvent CanJam = new CanJamEvent();
        CanJam.setName("Cam Jam");
        CanJam.setIsPlaytoExact(true);
        CanJam.setPlayTo(10);
        CanJam.setPlayDistance(15);
        CanJam.setFrisbeeSize(180);

        eventsArray[0] = CanJam;

        CornHoleEvent CornHoles = new CornHoleEvent();
        CornHoles.setName("Corn Holes");
        CornHoles.setIsPlaytoExact(true);
        CornHoles.setPlayTo(10);
        CornHoles.setPlayDistance(15);
        CornHoles.setNumBeanBags(180);

        eventsArray[1] = CornHoles;

        HorseShoesEvent HorseShoes = new HorseShoesEvent();
        HorseShoes.setName("Horse Shoes");
        HorseShoes.setIsPlaytoExact(true);
        HorseShoes.setPlayTo(10);
        HorseShoes.setPlayDistance(15);
        HorseShoes.setNumHorseShoes(180);

        eventsArray[2] = HorseShoes;

        LadderBallEvent LadderBall = new LadderBallEvent();
        LadderBall.setName("Ladder Ball");
        LadderBall.setIsPlaytoExact(true);
        LadderBall.setPlayTo(10);
        LadderBall.setPlayDistance(15);
        LadderBall.setNumRungs(180);

        eventsArray[3] = LadderBall;

        StickGameEvent StickGame = new StickGameEvent();
        StickGame.setName("Stick Game");
        StickGame.setIsPlaytoExact(true);
        StickGame.setPlayTo(10);
        StickGame.setPlayDistance(15);
        StickGame.setFrisbeeSize(180);

        eventsArray[4] = StickGame;

        WashoosEvent Washoos = new WashoosEvent();
        Washoos.setName("Washoos");
        Washoos.setIsPlaytoExact(true);
        Washoos.setPlayTo(10);
        Washoos.setPlayDistance(15);
        Washoos.setHasAutoWinStick(true);
        Washoos.setNumWashoos(5);

        eventsArray[5] = Washoos;
    }

    public Event[] getEvents()
    {
        return eventsArray;
    }

    //Method to randomize team array; used to randomize teams before going to array
    public static Team[] RandomizeArray(Team[] array){
        Random r = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = r.nextInt(array.length);
            Team temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

}
