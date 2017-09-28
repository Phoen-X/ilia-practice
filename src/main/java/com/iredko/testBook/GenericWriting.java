package com.iredko.testBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericWriting {
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruits = new ArrayList<Fruit>();

    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruits, new Apple());
//      writeExact(apples, new Fruit());
    }

    static <T> void writeWithWildCard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildCard(apples,new Apple());
        writeWithWildCard(fruits, new Apple());
    }

    public static void main(String[] args) {
        f1();
        f2();
    }
}
class s{

    public static void addToList(List<? super Integer> list) {
        list.add(13);
    }

    void go(){
        List<Number> ints = Arrays.asList(1, 2, 3);
        addToList(ints);
    }

}
