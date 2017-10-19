package com.iredko.testBook.treads;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static synchronized int nextSerialNumber() {
        return serialNumber++;//Операция не является потоко-безопасной
    }
}