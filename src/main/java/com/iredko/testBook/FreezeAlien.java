package com.iredko.testBook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class FreezeAlien {
    public static void main(String[] args) throws Exception {
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("D:/X.file"));
        Alien quellek = new Alien();
        objectOutput.writeObject(quellek);
    }
}
