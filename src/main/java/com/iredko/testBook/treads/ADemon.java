package com.iredko.testBook.treads;

import java.util.concurrent.TimeUnit;

public class ADemon implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Запускаем ADemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("Выход через InterruptedException");;
        } finally {
            System.out.println("Должно выполнятся всегда?");
        }
    }
}
