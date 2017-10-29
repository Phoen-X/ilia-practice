package com.iredko.testBook.treads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by ItsEasy on 29.10.2017.
 */
public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        exec.execute(new PriotizedTaskProducer(queue, exec));
        exec.execute(new PrioritizedTaskConsumer(queue));
    }
}
