package com.iredko.testBook;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by IRedko on 20.09.2017.
 */
public class Generators {
    public static <T>Collection<T> fill(Collection<T> coll,Generator<T> gen,int n){
        for(int i=0;i<n;i++){
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffe> coffes = fill(new ArrayList<>(),new CoffeGenerator(),4);
        for(Coffe c: coffes){
            System.out.println(c);
        }
        Collection<Integer> fnumbers = fill(new ArrayList<>(),new Fibonacci(),12);
        for(int i: fnumbers){
            System.out.println(i+". ");
        }
    }
}
