package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Helen on 11/1/14.
 */
public class OlympianManager {

    Olympian Olympian;
    List<Olympian>  list;
    String name;
    Sex gender;
    int year;

    public OlympianManager(String filePath) {
        String olympianLine;
        list = new ArrayList<Olympian>();
        try {
            //reads the text file
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            //reads file line by line
            while ((olympianLine = br.readLine()) != null) {

                //splits string into array
                String[] olympian = olympianLine.split(",");
                //assigns a name for each element of the array
                name = olympian[0];
                String sex = olympian[1];
                String age = olympian[2];
                //casts the string sex into enum sex
                if (sex.equals("MALE")) {
                    gender = Sex.MALE;
                } else {
                    gender = Sex.FEMALE;
                }
                //cats string age to int
                year = Integer.parseInt(age);
                //creates a new Olympian
                Olympian = new Olympian(name, gender, year);
                //adds the Olympian to array list
                list.add(Olympian);
            }
        }

        catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found");
        }

        catch (IOException ioe) {
            System.out.println("Problem reading from file");
        }
    }

    public List<Olympian> getOlympians()
    {
        return list;
    }
}

