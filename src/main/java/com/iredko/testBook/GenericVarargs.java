package com.iredko.testBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IRedko on 18.09.2017.
 */
public class GenericVarargs {
    public static <T>List<T> makeList(T... args){
        List<T> result = new ArrayList<T>();
        for(T item: args){
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A","B","C");
        System.out.println(ls);
        ls = makeList("AHADKJLHJAL:DL:D".split(""));
        System.out.println(ls);
    }
}
