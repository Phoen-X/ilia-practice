package com.iredko.testBook;

/**
 * Created by IRedko on 20.09.2017.
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    public String toString(){
        return "CounterObject " + id;
    }

}
