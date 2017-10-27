package com.iredko.testBook.treads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HorseRace {
    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<Horse>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public HorseRace(int nHourses, final int pause) {
        barrier = new CyclicBarrier(nHourses, new Runnable() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                for (int i=0;i<FINISH_LINE;i++) {
                    sb.append("=");//Забор беговой дорожке
                }
                System.out.println(sb);
                for (Horse horse : horses) {
                    System.out.println(horse.tracks());
                }
                for (Horse horse : horses) {
                    if (horse.getStriders() > FINISH_LINE) {
                        System.out.println(horse + "won!");
                        exec.shutdownNow();
                        return;
                    }
                }
                try{
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    System.out.println("barrier-action.sleep.interrupted");
                }
            }
        });
        for (int i=0;i<nHourses;i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHourses=7;
        int pause = 200;
        if (args.length > 0) {//Необезательный аргумент
            int n = new Integer(args[0]);
            nHourses = n > 0 ? n : nHourses;
        }
        if (args.length > 1) {//Необезательный аргумент
            int p = new Integer(args[1]);
            pause = p > -1 ? p : pause;
        }
        new HorseRace(nHourses, pause);
    }
}
