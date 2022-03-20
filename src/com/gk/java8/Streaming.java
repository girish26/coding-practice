package com.gk.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Streaming {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        Optional<Integer> sum = list.parallelStream().reduce(Integer::max);
        System.out.println(sum.get());

    }
}
