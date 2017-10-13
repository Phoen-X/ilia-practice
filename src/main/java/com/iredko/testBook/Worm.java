package com.iredko.testBook;

import java.io.*;
import java.util.Random;

public class Worm implements Serializable {
    private static Random random = new Random(47);
    private Data[] dataArray = {
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10))
    };
    private Worm next;
    private char aChar;

    //значение counts == количество сегментов
    public Worm(int count, char aChar) {
        System.out.println("Конструктор Worm: " + count);
        this.aChar = aChar;
        if (--count > 0) {
            next = new Worm(count, (char) (aChar + 1));
        }
    }

    public Worm() {
        System.out.println("Конструктор по умолчанию");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(aChar);
        result.append("(");
        for (Data dat : dataArray) {
            result.append(dat);
        }
        result.append(")");
        if (next != null) {
            result.append(next);
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Worm worm = new Worm(6, 'a');
        System.out.println("Worm = " + worm);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/worm.out"));
        objectOutputStream.writeObject("Worm storage\n");
        objectOutputStream.writeObject(worm);
        objectOutputStream.close();//Cleaning output buffer
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:/worm.out"));
        String string = (String) objectInputStream.readObject();
        Worm inputWorm = (Worm) objectInputStream.readObject();
        System.out.println(string + "inputWorm " + inputWorm);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream toByteArrayStream = new ObjectOutputStream(byteArrayOutputStream);
        toByteArrayStream.writeObject("Память обьекта Worm\n");
        toByteArrayStream.writeObject(worm);
        toByteArrayStream.flush();
        ObjectInputStream fromByteArrayStream = new ObjectInputStream(
                new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        string = (String) fromByteArrayStream.readObject();
        Worm inputFromByteArray = (Worm) fromByteArrayStream.readObject();
        System.out.println(string + "inputFromByteArray = "+ inputFromByteArray);

    }
}
