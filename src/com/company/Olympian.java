package com.company;

/**
 * Created by Helen on 10/8/14.
 */
public class Olympian {

    private String name;
    private Sex sex;
    private int age;

    public Olympian (String name, Sex sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setSex(Sex sex){
        this.sex = sex;
    }

    public Sex getSex(){
        return this.sex;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }
}
