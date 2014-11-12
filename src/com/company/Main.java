package com.company;

public class Main {

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
                getOlympians();
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
        EventManager EventManager = new EventManager();
        for (int i = 0; i < EventManager.eventsArray.length; i++) {
            System.out.println(EventManager.eventsArray[i].getName());
            System.out.println(EventManager.eventsArray[i].getPlayTo());
            System.out.println(EventManager.eventsArray[i].getIsPlaytoExact());
            System.out.println(EventManager.eventsArray[i].getPlayDistance());
        }
        System.out.println("\n");
    }

    //A method to display the day's olympians.
    public static void getOlympians() {
        System.out.println("The olympians are:\n");
        OlympianManager OlympianManager = new OlympianManager();
        for (int i = 0; i < OlympianManager.Olympians.length; i++) {
            System.out.println(OlympianManager.Olympians[i].getName());
            System.out.println(OlympianManager.Olympians[i].getSex());
            System.out.println(OlympianManager.Olympians[i].getAge());
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