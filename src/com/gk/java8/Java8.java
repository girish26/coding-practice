package com.gk.java8;

import com.gk.multithreading.Employee;

import java.util.*;

public class Java8 {
    public static void main(String[] args) {
        Map<Student, Integer> map = new HashMap<>();
        map.put(new Student(5,"girish5"), 5);
        map.put(new Student(2, "nagesh2"), 2);
        map.put(new Student(1, "nagesh1"), 1);
        map.put(new Student(3, "nagesh3"), 3);
        map.put(new Student(4, "nagesh4"), 4);

        map.forEach((key, value)->{
            System.out.println("key: "+key.id +" "+key.name+" value: "+value);
        });
        Set<Map.Entry<Student, Integer>> entrySet= map.entrySet();
        Comparator<Map.Entry<Student, Integer>> comparator = new Comparator<Map.Entry<Student, Integer>>() {
            @Override
            public int compare(Map.Entry<Student, Integer> o1, Map.Entry<Student, Integer> o2) {
                return o1.getKey().id - o2.getKey().id;
            }
        };

        List<Map.Entry<Student, Integer>> list = new ArrayList<Map.Entry<Student, Integer>>(entrySet);
      //  Collections.sort(list, comparator);
        System.out.println(list);
    }
}
