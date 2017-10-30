package com.iredko.testBook.treads;

import com.iredko.testBook.BasicGenerator;

import java.util.List;
import java.util.concurrent.*;

public class ExchangerDemo {
    static int size = 10;
    static int delay = 5;//SECONDS

    public static void main(String[] args) throws InterruptedException {
        if (args.length > 0) {
            size = new Integer(args[0]);
        }
        if (args.length > 1) {
            delay = new Integer(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<>();
        List<Fat> producerList = new CopyOnWriteArrayList<>();
        List<Fat> consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer<Fat>(xc, BasicGenerator.create(Fat.class), producerList));
        exec.execute(new ExchangerConsumer<Fat>(xc, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}
