package com.iredko.testBook.treads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {
    private Random random = new Random(47);
    private static int countter = 0;
    private final int id = countter++;
    private final int priority;
    protected static List<PrioritizedTask> sequance = new ArrayList<>();

    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequance.add(this);
    }

    @Override
    public int compareTo(PrioritizedTask o) {
        return priority < o.priority ? 1 : (priority > o.priority ? -1 : 0);
    }

    @Override
    public void run() {
        try{
            TimeUnit.MILLISECONDS.sleep(random.nextInt(250));
        } catch (InterruptedException e) {
            //Приемлимый вариант выхода
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("[%1$-3d]",priority) + " Task " + id;
    }

    public String summary(){
        return "(" + id + ":" + priority + ")";
    }

    public static class EndSentiel extends PrioritizedTask {
        private ExecutorService exec;

        public EndSentiel(ExecutorService exec) {
            super(-1);//Минимальный приоритет в этой программе
            this.exec = exec;
        }

        @Override
        public void run() {
            int count = 0;
            for (PrioritizedTask pt : sequance) {
                System.out.print(pt.summary());
                if (++count % 5 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println(this + "Calling.shutdownNow");
            exec.shutdownNow();
        }
    }
}
