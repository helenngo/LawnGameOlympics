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

    public OlympianManager() {
        String olympianLine;
        list = new ArrayList<Olympian>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("//Users//Helen//GitHub//Test//Olympian.lgoo"));

            while ((olympianLine = br.readLine()) != null) {

                String[] olympian = olympianLine.split(",");
                name = olympian[0];
                String sex = olympian[1];
                String age = olympian[2];
                if (sex.equals("MALE")) {
                    gender = Sex.MALE;
                } else {
                    gender = Sex.FEMALE;
                }
                year = Integer.parseInt(age);

                Olympian = new Olympian(name, gender, year);

                list.add(Olympian);
            }

        }

        catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found");
        } catch (IOException ioe) {
            System.out.println("Problem reading from file");
        }
    }
}

