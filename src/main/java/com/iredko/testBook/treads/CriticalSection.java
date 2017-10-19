package com.iredko.testBook.treads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {
    //Сравнение двух подходов
    static void testApproaches(PairManager pairManager1, PairManager pairManager2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator pairManipulator1 = new PairManipulator(pairManager1);
        PairManipulator pairManipulator2 = new PairManipulator(pairManager2);
        PairChecker pairChecker1 = new PairChecker(pairManager1);
        PairChecker pairChecker2 = new PairChecker(pairManager2);
        exec.execute(pairManipulator1);
        exec.execute(pairManipulator2);
        exec.execute(pairChecker1);
        exec.execute(pairChecker2);
        try{
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Sleep.interrupted");
        }
        System.out.println("pairManipulator1: " + pairManipulator1 + "\n pairManipulator2: " + pairManipulator2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager pairManager1 = new PairManager1();
        PairManager pairManager2 = new PairManager2();
        testApproaches(pairManager1,pairManager2);
    }
}
