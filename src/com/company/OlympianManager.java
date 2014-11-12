package com.company;

/**
 * Created by Helen on 10/8/14.
 */
public class OlympianManager {

    Olympian[] Olympians = new Olympian[16];

    public int counter = 0;

    public OlympianManager() {
        System.out.println("The olympians are:\n");
        //A matrix for holding the olympians.
        addOlympians("Jay Pritchett", Sex.FEMALE, 66);
        addOlympians("Gloria Pritchett", Sex.MALE, 42);
        addOlympians("Joe Pritchett", Sex.MALE , 1);
        addOlympians("Manny Delgado", Sex.FEMALE, 15);
        addOlympians("Stella",Sex.FEMALE, 1);
        addOlympians("Javier Delgado", Sex.MALE, 50);
        addOlympians("Mitchell Pritchett", Sex.MALE, 38);
        addOlympians("Lily Tucker-Pritchet", Sex.FEMALE, 3);
        addOlympians("Cameron Tuker", Sex.MALE, 42);
        addOlympians("Larry", Sex.MALE, 1);
        addOlympians("Claire Dunphy", Sex.FEMALE, 39);
        addOlympians("Haley Dunphy", Sex.FEMALE, 19);
        addOlympians("Alex Dunphy", Sex.FEMALE, 17);
        addOlympians("Luke Dunphy", Sex.MALE, 15);
        addOlympians("Phil Dunphy", Sex.MALE, 47);
        addOlympians("Grace Dunphy", Sex.FEMALE, 75);
        addOlympians("Frank Dunphy", Sex.MALE ,75);
        addOlympians("DeDe Pritchett",Sex.FEMALE, 63);
        addOlympians("Merle Tuker", Sex.MALE, 73);
        addOlympians("Barb Tuker", Sex.MALE, 64);
        addOlympians("Dylan Homes",Sex.MALE, 20);

    }
    System.out.println("\n");

    public void addOlympians(String name, Sex sex, int age) {
        Olympian olympianObject = new Olympian();
        olympianObject.setName(name);
        olympianObject.setSex(sex);
        olympianObject.setAge(age);
        Olympians[counter] = olympianObject;
        counter = counter + 1;
    }

    public Olympian[] getOlympians(){
        return Olympians;
    }
}
