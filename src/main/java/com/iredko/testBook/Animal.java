package com.iredko.testBook;

import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private MyHouse preferredHouse;
    Animal(String name, MyHouse house) {
        this.name = name;
        this.preferredHouse = house;
    }

    public String toString() {
        return name+"["+super.toString()+"]. "+preferredHouse + "\n";
    }

}
