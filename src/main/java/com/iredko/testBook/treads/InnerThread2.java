package com.iredko.testBook.treads;

public class InnerThread2 {
    private int countDouble = 5;
    private Thread thread;

    public InnerThread2(String name) {
        thread = new Thread(name) {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDouble == 0) {
                            return;
                        }
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("sleep().interrupted");
                }

            }

            @Override
            public String toString() {
                return getName() + ": " + countDouble;
            }
        };
        thread.start();
    }
}
