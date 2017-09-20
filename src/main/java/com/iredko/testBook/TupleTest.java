package com.iredko.testBook;

/**
 * Created by IRedko on 18.09.2017.
 */
public class TupleTest {

    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("hi", 47);
    }

    static TreeTuple<Amphibian, String, Integer> g() {
        return new TreeTuple<>(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k(){
        return new FiveTuple<>(new Vehicle(),new Amphibian(), "hi",47,11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String,Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
