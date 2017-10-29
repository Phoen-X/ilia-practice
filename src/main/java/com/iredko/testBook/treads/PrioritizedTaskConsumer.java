package com.iredko.testBook.treads;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by ItsEasy on 29.10.2017.
 */
public class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> queue;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()) {
                //Использование текущего потока для запуска задачи:
                queue.take().run();
            }
        } catch (InterruptedException e) {
            //Приемлимый вариант выхода
        }
        System.out.println("Завершение PrioritizedTaskConsumer");
    }
}
