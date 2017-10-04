package com.iredko.testBook;

import java.io.*;
import java.net.ServerSocket;

public class BasicFileOutput {
    static String file = "D:\\BasicFileOutput out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(
                BufferedInputFile.read("D:/GameLauncher.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + " (-_-) " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));

    }
}
