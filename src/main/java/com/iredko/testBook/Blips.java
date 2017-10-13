package com.iredko.testBook;

import java.io.*;

public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Создание обьектов:");
        Blip1 blip1 = new Blip1();
        Blip2 blip2 = new Blip2();
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:/Blips.out"));
        System.out.println("Сохранение обьектов:");
        outputStream.writeObject(blip1);
        outputStream.writeObject(blip2);
        outputStream.close();
        //Восстановление сохраненных обьектов
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:/Blips.out"));
        System.out.println("Востановление blip1:");
        blip1 = (Blip1) inputStream.readObject();
        //Blip2 no public
//        System.out.println("Востановление blip2:");
//        blip2 = (Blip2) inputStream.readObject();

    }
}
