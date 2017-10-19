package com.iredko.testBook.treads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair pair = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());
    public synchronized Pair getPair() {
        //Создаем копию, чтобы сохранить оригинал
        return new Pair(pair.getX(), pair.getY());
    }

    //Предпологается, что операция занимает некоторое время
    protected void store(Pair pair) {
        storage.add(pair);
        try {
            TimeUnit.MILLISECONDS.sleep(50);

        } catch (InterruptedException ignore) {
        }
    }
    public abstract void increment();
}
