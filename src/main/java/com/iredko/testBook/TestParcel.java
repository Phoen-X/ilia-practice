package com.iredko.testBook;

/**
 * Created by IRedko on 10.08.2017.
 */
public class TestParcel {
    public static void main(String[] args) {
        Parce14 p = new Parce14();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
    }
}
