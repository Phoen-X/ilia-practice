package com.iredko.testBook.treads;

public class PairManager1 extends PairManager {
    @Override
    public void increment() {
        pair.incrementX();
        pair.incrementY();
        store(getPair());
    }
}
