package com.iredko.testBook.treads;

import java.util.concurrent.TimeUnit;

/**
 * Created by ItsEasy on 21.10.2017.
 */
public class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()) {
                System.out.print("Wax On! ");
                TimeUnit.MICROSECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}
