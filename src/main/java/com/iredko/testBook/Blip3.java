package com.iredko.testBook;

import java.io.*;

public class Blip3 implements Externalizable {
    private int value;
    private String string;

    public Blip3(){
        System.out.println("Конструктор Blip3");
    }

    public Blip3(String string, int value) {
        System.out.println("Blip3(String string, int value)");
        this.string=string;
        this.value = value;
        //value and string инициализируются только вне конструктора по умолчанию
    }

    @Override
    public String toString() {
        return string + value;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        //Необходимо действовать так
        out.writeObject(string);
        out.writeInt(value);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        //Необходимо действовать так
        this.string = (String) in.readObject();
        this.value = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Создание объектов: ");
        Blip3 blip3 = new Blip3("Строка", 47);
        System.out.println(blip3);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:/Blip3.out"));
        System.out.println("Сохранение объекта: ");
        outputStream.writeObject(blip3);
        outputStream.close();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:/Blip3.out"));
        System.out.println("Восстановление blip3: ");
        blip3 = (Blip3)inputStream.readObject();
        System.out.println(blip3);
    }
}
