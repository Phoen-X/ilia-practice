package com.iredko.testBook.treads;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class PriotizedTaskProducer implements Runnable {
    private Random random = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;

    public PriotizedTaskProducer(Queue<Runnable> queue, ExecutorService exec) {
        this.queue = queue;
        this.exec = exec;//Used for EndSentinel
    }

    @Override
    public void run() {
        //Неограниченая очередь без блокировки
        //Быстрое заполнение случайными приоритетами
        for(int i=0;i<20;i++) {
            queue.add(new PrioritizedTask(random.nextInt(10)));
            Thread.yield();
        }
        //Добавление высокоприорететных задач
        try{
            for(int i = 0;i<10;i++) {
                TimeUnit.MICROSECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }
            //Добавление заданий, начиная с наименьших приоритетов
            for(int i=0; i<10;i++) {
                queue.add(new PrioritizedTask(i));
            }
        } catch (InterruptedException e) {
            //Приемлимый вариант выхода
        }
        System.out.println("Завершение PrioritizedTaskProducer");
    }
}
