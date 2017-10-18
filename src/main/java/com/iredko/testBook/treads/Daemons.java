package com.iredko.testBook.treads;

import java.util.concurrent.TimeUnit;

public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread daemon = new Thread(new Daemon());
        daemon.setDaemon(true);
        daemon.start();
        System.out.println("daemon.isDaemon() = " + daemon.isDaemon() + ", ");
        //Даем потокам-демонам завершить процесс запуска:
        TimeUnit.SECONDS.sleep(1);
    }
}
