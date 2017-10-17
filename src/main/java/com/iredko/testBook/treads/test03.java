package com.iredko.testBook.treads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;

public class test03 {
    public static int count = 5;

    public static void main(String[] args) {

        List arrayRun = new ArrayList();
        while(--count>0) {
            Runnable r1 = new Runnable() {
                @Override
                public void run() {
                    System.out.println(count);
                    System.out.println("hello");
                }
            };
            System.out.println(r1.getClass());
        }

    }
}
