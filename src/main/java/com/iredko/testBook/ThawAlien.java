package com.iredko.testBook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class ThawAlien {
    public static void main(String[] args) throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("..","X.file")));
        Object mystery = inputStream.readObject();
        System.out.println(mystery.getClass());
    }
}
