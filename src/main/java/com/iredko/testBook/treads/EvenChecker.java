package com.iredko.testBook.treads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int ident) {
        this.generator = generator;
        this.id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCancelled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " не четно!");
                generator.cancel();//Отмена всех EvenChecked
            }
        }
    }

    //Тестирование произвольного типа IntGenerator
    public static void test(IntGenerator intGenerator, int count) {
        System.out.println("Нажмите Control-C, чтобы завершить программу");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0; i<count; i++) {
            executorService.execute(new EvenChecker(intGenerator, i));
        }
        executorService.shutdown();
    }

    //Значение по умолчанию для count
    public static void test(IntGenerator intGenerator) {
        test(intGenerator,10);
    }
}
