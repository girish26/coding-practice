package com.gk.inheritance;

public class MainTest {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.getName();
        System.out.println("main class name: "+animal.name);
    }
}
