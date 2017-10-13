package com.iredko.testBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyWorld {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyHouse house = new MyHouse();
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("Bisco the dog", house));
        animals.add(new Animal("Ralph the hamster", house));
        animals.add(new Animal("Molly the cat", house));
        System.out.println("animals: " + animals);
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteOutStream);
        outputStream.writeObject(animals);
        outputStream.writeObject(animals);
        ByteArrayOutputStream byteOutStream2 = new ByteArrayOutputStream();
        ObjectOutputStream outputStream2 = new ObjectOutputStream(byteOutStream2);
        outputStream2.writeObject(animals);
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(byteOutStream.toByteArray()));
        ObjectInputStream inputStream2 = new ObjectInputStream(new ByteArrayInputStream(byteOutStream2.toByteArray()));
        List animals1 = (List) inputStream.readObject();
        List animals2 = (List) inputStream.readObject();
        List animals3 = (List) inputStream2.readObject();
        System.out.println("Animals1: " + animals1);
        System.out.println("Animals2: " + animals2);
        System.out.println("Animals3: " + animals3);
    }
}
