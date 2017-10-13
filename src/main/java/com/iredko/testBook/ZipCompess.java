package com.iredko.testBook;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

public class ZipCompess {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:/test.zip");
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new Adler32());
        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream);
        zipOutputStream.setComment("Проверка Zip-сжатия Java ");
        //Однако парного метода для получения комментария
        //getComment() не существует
        for (String arg : args) {
            System.out.println("Запись файла " + arg);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(arg));
            zipOutputStream.putNextEntry(new ZipEntry(arg));
            int value;
            while ((value = bufferedReader.read()) != -1) {
                bufferedOutputStream.write(value);
            }
            bufferedReader.close();
            bufferedOutputStream.flush();
        }
        bufferedOutputStream.close();
        //Контрольная сумма становится действительной
        //только после закрытия фвйла с архивом!
        System.out.println("Checksum " + checkedOutputStream.getChecksum().getValue());
        //Теперь извлекаем файлы
        System.out.println("Чтение файла");
        FileInputStream fileInputStream = new FileInputStream("D:/test.zip");
        CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            System.out.println("Reading file: " + zipEntry);
            System.out.println("-----------------------------------------");
            int value;
            while ((value = bufferedInputStream.read()) != -1) {
                System.out.write(value);
            }
            System.out.println();
            System.out.println("-----------------------------------------");
        }
        if (args.length == 2) {
            System.out.println("Контрольная сумма " + checkedInputStream.getChecksum().getValue());
        }
        bufferedInputStream.close();
        //Альтернативный способ открытия и  чтения
        //файлов в формате zip
        ZipFile zipFile = new ZipFile("D:/test.zip");
        Enumeration enumeration = zipFile.entries();
        while (enumeration.hasMoreElements()) {
            ZipEntry zipEntry2 = (ZipEntry) enumeration.nextElement();
            System.out.println("File: " + zipEntry2);
        }
    }
}
