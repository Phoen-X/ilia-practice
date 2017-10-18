package com.iredko.testBook.treads;

public class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    public void run() {
        try{
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " прерван " + "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName()+ " активизтровался");
    }
}
