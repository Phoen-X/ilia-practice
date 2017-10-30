package com.iredko.testBook.treads;

import java.util.SortedSet;

public class Fat {
    private volatile double d;//Предотвращает оптимизацию
    private static int counter = 0;
    private final int id=counter++;

    public Fat() {
        //затратная прерываемая операция
        for (int i= 0;i<10000;i++) {
            d += (Math.PI + Math.E) / (double) i;
        }
    }
    public void operation() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Fat id: " + id;
    }


}
