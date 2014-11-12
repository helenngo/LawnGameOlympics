package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Lawn Game Olympics");
        System.out.println("Press e for events, o for olympians and h for more help.");

        Scanner myScanner = new Scanner(System.in);
        String myString = myScanner.next();

        if (myString.equals("e") || myString.equals("events")) {
            eventMethod();
        } else if (myString.equals("o") || myString.equals("olympians")) {
            olympiansMethod();
        } else if (myString.equals("h") || myString.equals("help")) {
            System.out.println("Help Menu:");
        } else {
            System.out.println("You need to learn how to spell.");
        }
    }

    public static void eventMethod() {
        System.out.println("The events are:");
        String[] eventArray;
        eventArray = new String[6];
        eventArray[0] = "Washoos";
        eventArray[1] = "CanJam";
        eventArray[2] = "Horseshoes";
        eventArray[3] = "Cornhole";
        eventArray[4] = "Ladderball";
        eventArray[5] = "Stickgame";
        for (int i = 0; i < eventArray.length; i++) {
            System.out.println(eventArray[i]);
        }
    }

    public static void olympiansMethod() {
        System.out.println("The olympians are:");
        String[][] olympiansArray;
        olympiansArray = new String[16][3];
        olympiansArray[0][0] = "Cat";
        olympiansArray[0][1] = "F";
        olympiansArray[0][2] = "13";
        olympiansArray[1][0] = "Jimmy";
        olympiansArray[1][1] = "F";
        olympiansArray[1][2] = "13";
        olympiansArray[2][0] = "Bobby";
        olympiansArray[2][1] = "F";
        olympiansArray[2][2] = "13";
        olympiansArray[3][0] = "Sandra";
        olympiansArray[3][1] = "F";
        olympiansArray[3][2] = "13";
        olympiansArray[4][0] = "Nicky";
        olympiansArray[4][1] = "F";
        olympiansArray[4][2] = "13";
        olympiansArray[5][0] = "Luke";
        olympiansArray[5][1] = "F";
        olympiansArray[5][2] = "13";
        olympiansArray[6][0] = "Tudor";
        olympiansArray[6][1] = "F";
        olympiansArray[6][2] = "13";
        olympiansArray[7][0] = "Mary";
        olympiansArray[7][1] = "F";
        olympiansArray[7][2] = "13";
        olympiansArray[8][0] = "Henry";
        olympiansArray[8][1] = "F";
        olympiansArray[8][2] = "13";
        olympiansArray[9][0] = "Kathrine";
        olympiansArray[9][1] = "F";
        olympiansArray[9][2] = "13";
        olympiansArray[10][0] = "Elizabeth";
        olympiansArray[10][1] = "F";
        olympiansArray[10][2] = "13";
        olympiansArray[11][0] = "George";
        olympiansArray[11][1] = "F";
        olympiansArray[11][2] = "13";
        olympiansArray[12][0] = "Zeus";
        olympiansArray[12][1] = "F";
        olympiansArray[12][2] = "13";
        olympiansArray[13][0] = "Hades";
        olympiansArray[13][1] = "F";
        olympiansArray[13][2] = "13";
        olympiansArray[14][0] = "Athena";
        olympiansArray[14][1] = "F";
        olympiansArray[14][2] = "13";
        olympiansArray[15][0] = "James";
        olympiansArray[15][1] = "F";
        olympiansArray[15][2] = "13";
        for (int i = 0; i < olympiansArray.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(olympiansArray[i][j]);
            }
        }
    }
}

