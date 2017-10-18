package com.iredko.testBook.treads;

import com.iredko.testBook.CountingGenerator;

public class SimpleThread extends Thread {
    private int countDouble = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        //Сохранение имени потока
        super(Integer.toString(++threadCount));
        start();
    }

    @Override
    public String toString() {
        return "#" + getName() + "(" + countDouble + "). ";
    }

    @Override
    public void run() {
        while (true) {
            System.out.print(this);
            if (--countDouble == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for(int i =0; i<5;i++) {
            new SimpleThread();
        }
    }
}
