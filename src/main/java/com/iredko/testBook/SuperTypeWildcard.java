package com.iredko.testBook;

import java.util.List;

public class SuperTypeWildcard {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        apples.add(new JonathanRed());
//        apples.add(new Fruit());
    }

    static void writeToList(List<Apple> apples){
        apples.add(new Apple());
        apples.add(new Jonathan());
        apples.add(new JonathanRed());
//        apples.add(new Fruit());
    }
}
