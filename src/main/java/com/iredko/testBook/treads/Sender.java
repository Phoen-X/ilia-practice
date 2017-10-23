package com.iredko.testBook.treads;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by ItsEasy on 21.10.2017.
 */
public class Sender implements Runnable {
    private Random random = new Random(47);
    private PipedWriter out = new PipedWriter();
    public PipedWriter getPipedWriter() {
        return out;
    }

    @Override
    public void run() {
        try{
            while (true) {
                for(char c='A';c<='z';c++) {
                    out.write(c);
                    TimeUnit.MICROSECONDS.sleep(random.nextInt(500));
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e+" Sender write exception");;
        } catch (IOException e) {
            System.out.println(e+" Sender sleep.interrupted()");;
        }
    }
}
