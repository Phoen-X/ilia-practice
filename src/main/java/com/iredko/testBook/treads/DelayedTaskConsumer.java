package com.iredko.testBook.treads;

import java.util.concurrent.DelayQueue;

public class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                q.take().run();//Выполнение задачи в текущем потоке
            }
        } catch (InterruptedException e) {
            //Приемлимый вариант выхода
        }
        System.out.println("Завершается DelayTaskConsumer");
    }
}
