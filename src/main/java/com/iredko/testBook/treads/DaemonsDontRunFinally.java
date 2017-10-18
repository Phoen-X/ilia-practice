package com.iredko.testBook.treads;

import java.util.concurrent.TimeUnit;

public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread thread = new Thread(new ADemon());
//        thread.setDaemon(true);
        thread.start();
    }
}
