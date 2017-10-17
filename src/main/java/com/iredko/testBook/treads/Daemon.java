package com.iredko.testBook.treads;

import com.iredko.testBook.TreeTuple;

public class Daemon implements Runnable {
    private Thread[] threadsArray = new Thread[10];

    @Override
    public void run() {
        for(int i=0;i<threadsArray.length;i++) {
            threadsArray[i] = new Thread(new DaemonSpawn());
            threadsArray[i].start();
            System.out.print("DaemonSpawn "+ i + " started, ");
        }
        for(int i=0; i<threadsArray.length;i++) {
            System.out.print("t[" + i + "].isDaemon() = " + threadsArray[i].isDaemon() + ", ");
        }
        while (true) {
            Thread.yield();
        }
    }
}
