package com.iredko.testBook.treads;

public class Daemons {
    public static void main(String[] args) {
        Thread daemon = new Thread(new Daemon());
        daemon.setDaemon(true);
        daemon.start();

    }
}
