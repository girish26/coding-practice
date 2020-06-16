package com.gk.inheritance;

public class Animal {
    String name;
    Animal(String name){
        this.name = name;
    }
    Animal(){
        System.out.println("In animal constructor");
    }

    public void getName(){
        System.out.println("In parent getName");
    }
}
