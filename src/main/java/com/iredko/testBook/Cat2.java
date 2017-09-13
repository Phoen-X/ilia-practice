package com.iredko.testBook;

import javax.sound.midi.Soundbank;

/**
 * Created by IRedko on 12.09.2017.
 */
public class Cat2 {
    String name;
    String x;
    Cat2 (String name){
        this.name=name;
    }
    Cat2(){}

    public static void main(String[] args) {
        Cat2 cat = new Cat2("Tree");
        System.out.println("Name: "+ cat.name);
        System.out.println("X: "+ cat.x);
        Class<Cat2> c2 = Cat2.class;
    }
}
