package com.iredko.testBook;

/**
 * Created by IRedko on 11.09.2017.
 */
public class ClassCast {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h=(House)b;
    }
}
