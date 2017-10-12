package com.iredko.testBook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.SyncFailedException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    public static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("D:/data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc = new FileInputStream("D:/data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
        //Декодирование с использованием кодировки по умолчанию
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Декодировано в "+ encoding + ": "+ Charset.forName(encoding).decode(buff));
        //Кодирование в печатной форме
        fc = new FileOutputStream("D:/data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();
        //Повторная попытка чтения
        fc = new FileInputStream("D:/data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
        //Использование CharBuffer для записи
        fc = new FileOutputStream("D:/data2.txt").getChannel();
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();
        //Чтение и вывод
        fc = new FileInputStream("D:/data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
}
