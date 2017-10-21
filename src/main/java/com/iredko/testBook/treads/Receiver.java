package com.iredko.testBook.treads;

import java.io.IOException;
import java.io.PipedReader;

/**
 * Created by ItsEasy on 21.10.2017.
 */
public class Receiver implements Runnable {
    private PipedReader in;

    public Receiver(Sender sender) throws IOException {
        this.in = new PipedReader(sender.getPipedWriter());
    }

    @Override
    public void run() {
        try{
            while (true) {
                //Блокируется до появления следующего символа
                System.out.print("Read: " + (char)in.read()+". ");
            }
        } catch (IOException e) {
            System.out.println(e + "Receiver read Exception");
        }
    }
}
