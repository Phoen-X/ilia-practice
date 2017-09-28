package com.iredko.testBook;

import java.util.ArrayList;
import java.util.List;

public class NonCovariantGenerics {
    public static void main(String[] args) {
        List<Fruit> flist = new ArrayList<Fruit>();
        flist.add(new Apple());
        flist.add(new Jonathan());
        List<Apple> appleList = new ArrayList<Apple>();
//        appleList.add((Apple) new Fruit());

    }

}
