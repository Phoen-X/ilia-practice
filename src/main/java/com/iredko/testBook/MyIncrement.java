package com.iredko.testBook;

/**
 * Created by IRedko on 10.08.2017.
 */
public class MyIncrement {
    public void increment(){
        System.out.println("Другая операция");
    }
    public static void f(MyIncrement mi){
        mi.increment();
    }
}
