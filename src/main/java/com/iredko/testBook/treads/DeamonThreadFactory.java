package com.iredko.testBook.treads;

import java.util.concurrent.ThreadFactory;

public class DeamonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
