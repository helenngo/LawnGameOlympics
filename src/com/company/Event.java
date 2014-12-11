package com.company;

/**
 * Created by Helen on 10/8/14.
 */
public abstract class Event {

    private BracketQueue BQ = new BracketQueue();
    private PlacingStack PS = new PlacingStack();
    private String name;
    private int playTo;
    private boolean isPlaytoExact;
    private int playDistance;

    public abstract String getExtraInfo();

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return this.name;
    }

    public void setPlayTo(int playTo) {

        this.playTo = playTo;
    }

    public int getPlayTo() {

        return this.playTo;
    }

    public void setIsPlaytoExact(boolean isPlaytoExact) {

        this.isPlaytoExact = isPlaytoExact;
    }

    public boolean getIsPlaytoExact() {
        return this.isPlaytoExact;
    }


    public void setPlayDistance(int playDistance) {

        this.playDistance = playDistance;
    }

    public int getPlayDistance() {

        return this.playDistance;
    }

    void startQueue(Team[] tempTeam) {
        for (int j = 0; j < tempTeam.length; j++) {
            BQ.enqueue(tempTeam[j]);
        }
    }

    public Team[] PeekNextTeams() {
        Team[] peek = new Team[2];
        if (BQ.isEmpty() == false) {
            peek[0] = BQ.PeekNextTeams()[0];
            peek[1] = BQ.PeekNextTeams()[0];
        }
        return (peek);
    }

    public Team[] GetNextTeams() {
        Team[] get = new Team[2];
        try {
            get[0] = BQ.dequeue();
            get[1] = BQ.dequeue();
        } catch (Exception e) {
            System.out.println("There are no more teams to dequeue.");
        }
        return (get);
    }

    public Team[] ReturnPlacing() {
        Team[] placing = new Team[3];
        if (BQ.isEmpty()) {
            try {
                placing[0] = PS.pop();
                placing[1] = PS.pop();
                placing[2] = PS.pop();
            } catch (Exception e) {
                System.out.println("There are no teams to pop.");
            }
        }
        return (placing);
    }

    public boolean isEmpty(){
        return BQ.isEmpty();
    }

    void ReturnTeams(Team winner, Team loser){
        PS.push(loser);

        if(!BQ.isEmpty()){
            BQ.enqueue(winner);
        }else{
            PS.push(winner);
        }
    }
}
