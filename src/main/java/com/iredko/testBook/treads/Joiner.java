package com.iredko.testBook.treads;

public class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try{
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Прерван");
        }
        System.out.println(getName()+" join завершен");
    }
}
