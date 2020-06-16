package com.gk.inheritance;

public class Cat extends Animal{

    String name;
    public void getName(){
        name = "girish";
        System.out.println("name: "+this.name);
    }

    Cat(){
      //  super("nagesh");
        System.out.println("in cat constructor");
    }
}
