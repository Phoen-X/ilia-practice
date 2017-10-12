package com.iredko.testBook;

import com.sun.corba.se.impl.oa.poa.BadServerIdHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception{
        FileChannel fc = new FileOutputStream("D:/data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text  ".getBytes()));
        fc.close();
        //Добавление в конец файла
        fc = new RandomAccessFile("D:/data.txt", "rw").getChannel();
        fc.position(fc.size());//Переход в конец
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        //Чтение файла
        fc = new FileInputStream("D:/data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()) {
            System.out.print((char)buff.get());
        }
    }
}
