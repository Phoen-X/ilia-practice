package com.iredko.testBook;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPPcompress {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Использование: \nGZIPcompress file\n" +
                    "\tИспользует метод GZIP для сжатия " + "файла в архив test.gz");
            System.exit(1);
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedOutputStream outputStream = new BufferedOutputStream(new GZIPOutputStream(
                new FileOutputStream("D:/test.gz")));
        System.out.println("Запись файла");
        int value;
        while ((value = bufferedReader.read()) != -1) {
            outputStream.write(value);
        }
        bufferedReader.close();
        outputStream.close();
        System.out.println("Чтение файла");
        BufferedReader secondBufferReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("D:/test.gz"))));
        String string;
        while ((string = secondBufferReader.readLine()) != null) {
            System.out.println(string);
        }
    }
}
