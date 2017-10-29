package com.iredko.testBook.treads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
         import java.util.concurrent.TimeUnit;

/**
 * Created by ItsEasy on 29.10.2017.
 */
public class PriorityBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
//        Random random = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        exec.execute(new PriotizedTaskProducer(queue, exec));
        Thread.sleep(300);
        exec.execute(new PrioritizedTaskConsumer(queue));
    }
}
