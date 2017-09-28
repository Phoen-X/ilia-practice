package com.iredko.testBook;

import sun.text.normalizer.CharTrie;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class GenericAndCovariance {
    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<Apple>();
//        flist.add(new Apple());
//        flist.add(new Fruit());
//        flist.add(new Object());
        flist.add(null);
        Fruit f = flist.get(0);
        if (f!=null) {
            System.out.println(f.getClass().getSimpleName());
        }else {
            System.out.println("f=null");
        }
    }
}
