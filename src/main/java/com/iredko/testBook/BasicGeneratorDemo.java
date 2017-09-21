package com.iredko.testBook;

/**
 * Created by IRedko on 20.09.2017.
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for(int i=0;i<5;i++){
            System.out.println(gen.next());
        }
    }
}
