package com.iredko.testBook;

/**
 * Created by IRedko on 18.09.2017.
 */
public class Coffe {
    private static long counter = 0;
    private final long id = counter++;
    public String toString(){
        return getClass().getSimpleName()+ " "+id;
    }
}
