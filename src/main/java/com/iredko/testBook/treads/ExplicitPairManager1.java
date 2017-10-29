package com.iredko.testBook.treads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitPairManager1 extends PairManager{
    private Lock lock = new ReentrantLock();
    public void increment() {
        lock.lock();
        try{
            pair.incrementX();
            pair.incrementY();
            store(getPair());
        }finally {
            lock.unlock();
        }
    }
}
