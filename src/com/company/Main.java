package com.company;

public class Main {
    //Declaring the eventArray and olympiansArray as class variables.
    public static String[] eventArray;
    public static String[][] olympiansArray;

    //A method to create and initialize the events array, olympian matrix and help screen.
    public static void main(String[] args) {
        System.out.println("Lawn Game Olympics");//The title of the application.
        System.out.println("Enter e for events, o for olympians and h for more help.");//A bit of instructions.
        System.out.println("\n");//Create space between displayed methods.

        //The for loop goes through the user input and creates an array.
        for (int i=0; i < args.length; i++)
        //Comparing the user inputs to application arguments.
        {
            if (args[i].equals("e") || args[i].equals("events")) {
                eventMethod();
            } else if (args[i].equals("o") || args[i].equals("olympians")) {
                olympiansMethod();
            } else if (args[i].equals("h") || args[i].equals("help")) {
                helpMethod();
            } else {
                System.out.println("You need to learn how to type.");
            }
        }
    }

    //A method to display the day's events.
    public static void eventMethod() {
        System.out.println("The events are:");
        //An array to hold the event names.
        eventArray = new String[]
                {"Washoos", "CanJam", "Horseshoes", "Cornhole", "Ladderball", "Stickgame",};
        for (int i = 0; i < eventArray.length; i++) {
            System.out.println(eventArray[i]);
        }
        System.out.println("\n");
    }

    //A method to display the day's olympians.
    public static void olympiansMethod() {
        System.out.println("The olympians are:\n");
        //A matrix for holding the olympians.
        olympiansArray = new String[][]
                {
                        {"Jay Pritchett", "F", "66"},
                        {"Gloria Pritchett", "M", "42"},
                        {"Joe Pritchett","M","1"},
                        {"Manny Delgado", "F", "15"},
                        {"Stella","F","1"},
                        {"Javier Delgado","M","50"},
                        {"Mitchell Pritchett","M","38"},
                        {"Lily Tucker-Pritchet","F",""},
                        {"Cameron Tuker","M","42"},
                        {"Larry","M","1"},
                        {"Claire Dunphy","F","39"},
                        {"Haley Dunphy","F","19"},
                        {"Alex Dunphy","F","17"},
                        {"Luke Dunphy","M","15"},
                        {"Phil Dunphy","M","47"},
                        {"Grace Dunphy","F","75"},
                        {"Frank Dunphy", "M", "75"},
                        {"DeDe Pritchett","F","63"},
                        {"Merle Tuker","M","73"},
                        {"Barb Tuker","F","64"},
                        {"Dylan Homes","M","20"}
                };
        for (int i = 0; i < olympiansArray.length; i++) {
            System.out.println(olympiansArray[i][0] + ", " + olympiansArray[i][1] + ", " + olympiansArray[i][2] + "\n");
        }
        System.out.println("\n");
    }

    //A method to display the help screen.
    public static void helpMethod() {
        System.out.println("Help Menu:");//The help screen.
        System.out.println("If you want to view the events for day, \n enter the letter e or the word event.");
        System.out.println("If you want to view the list of olympians participating today,  \n enter the letter o or the word olympian.");
        System.out.println("And if you still don't know what to do, I'm sorry, \n but I can't help you anymore.");
        System.out.println("\n");
    }
}