package com.iredko.testBook;

import com.iredko.bestRotation.Character;
import sun.applet.AppletListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args) {
//        Apple[] am = {new Apple()};
//        System.out.println(am);
//        List<Apple> flist = new ArrayList<Apple>(am);
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0);
        flist.contains(new Apple());
        flist.indexOf(new Apple());

        char c = 52;
        int i = Integer.valueOf(String.valueOf(c));
        System.out.println(i);
    }
}
