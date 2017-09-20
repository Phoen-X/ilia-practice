package com.iredko.testBook;

import sun.security.jca.GetInstance;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by IRedko on 18.09.2017.
 */
public class CoffeGenerator implements Generator<Coffe>, Iterable<Coffe> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
    private static Random random = new Random();

    public CoffeGenerator() {
    }

    private int size = 0;

    public CoffeGenerator(int sz) {
        size = sz;
    }

    @Override
    public Coffe next() {
        try {
            return (Coffe) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    class CoffeIterator implements Iterator<Coffe> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffe next() {
            count--;
            return CoffeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffe> iterator() {
        return new CoffeIterator();
    }

    public static void main(String[] args) {
        CoffeGenerator gen = new CoffeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        for (Coffe c : new CoffeGenerator(5)) {
            System.out.println(c);
        }
    }
}
