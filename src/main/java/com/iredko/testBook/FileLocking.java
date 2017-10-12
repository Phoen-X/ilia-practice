package com.iredko.testBook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:/file.txt");
        FileLock fileLock = fileOutputStream.getChannel().tryLock();
        if (fileLock != null) {
            System.out.println("Файл заблокирован");
            TimeUnit.MILLISECONDS.sleep(100);
            fileLock.release();
            System.out.println("Блокировка снята");
        }
        fileOutputStream.close();

    }
}
