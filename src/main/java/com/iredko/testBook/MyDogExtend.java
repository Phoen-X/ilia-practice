package com.iredko.testBook;

public class MyDogExtend extends MyDog{
    public static int SZIE = 80;
    public static int i = 88;

    public static void main(String[] args) {
        System.out.println(SZIE);
        System.out.println(i);
        new MyDogExtend().go();
    }

    void go() {
        System.out.println(super.SZIE);
        System.out.println(super.i);
    }
}
