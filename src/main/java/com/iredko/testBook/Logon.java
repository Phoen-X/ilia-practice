package com.iredko.testBook;

import java.io.*;
import java.util.Date;

public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "информация о сеансе\n пользователь: " + username +
                "\n дата: " + date + "\n пароль: " + password;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Logon logon = new Logon("Пользователь", "Пароль");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:/Logon.out"));
        outputStream.writeObject(logon);
        outputStream.close();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:/Logon.out"));
        System.out.println("Восстановление объекта Время: " + new Date());
        logon = (Logon) inputStream.readObject();
        System.out.println("Сеанс = " + logon);
    }
}
