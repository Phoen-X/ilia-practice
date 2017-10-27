package com.iredko.testBook.treads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class DelayedTask implements Delayed,Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long triger;
    protected static List<DelayedTask> sequence = new ArrayList<>();

    public DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        triger = System.nanoTime() + NANOSECONDS.convert(delta, MICROSECONDS);
        sequence.add(this);
    }

    public long getDelay(TimeUnit unit) {
        return unit.convert(
                triger - System.nanoTime(), NANOSECONDS
        );
    }

    @Override
    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask) arg;
        if(triger<that.triger) return -1;
        if(triger>that.triger) return 1;
        return 0;
    }

    @Override
    public void run() {
        System.out.print(this+" ");
    }

    @Override
    public String toString() {
        return String.format("[%1$-4d]",delta)+" Task "+id;
    }

    public String summary() {
        return "(" + id + ":" + delta + ")";
    }

    public static class EndSentinel extends DelayedTask {
        private ExecutorService exec;

        public EndSentinel(int delay, ExecutorService e) {
            super(delay);
            exec = e;
        }

        public void run() {
            for (DelayedTask pt : sequence) {
                System.out.print(pt.summary() + " ");
            }
            System.out.println();
            System.out.println(this + " вызывает shutdownNow");
            exec.shutdownNow();
        }

    }

}
