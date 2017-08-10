package com.iredko.testBook;

/**
 * Created by IRedko on 10.08.2017.
 */
public class Calle1 implements Incrementable {
    private int i=0;

    public void increment() {
        i++;
        System.out.println(i);
    }
}
