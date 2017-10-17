package com.iredko.testBook.treads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        //В аргументе конструктора передается количество потоков
        ExecutorService service = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();
    }
}
