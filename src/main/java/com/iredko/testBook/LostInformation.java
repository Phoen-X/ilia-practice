package com.iredko.testBook;

import java.util.*;

class Frob {}
class Froncle{}
class Quark<Q>{}
class Particle<POSITION,MOMENTUM>{}

public class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<>();
        Map<Frob, Froncle> map = new HashMap<>();
        Quark<Froncle> quark = new Quark<>();
        Particle<Long,Double> p = new Particle<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
    }
}
