package com.iredko.testBook;

import java.nio.MappedByteBuffer;
import java.io.*;
import java.nio.channels.FileChannel;

public class LargeMappedFiles {
    static int length = 0x8FFFFFF;//128MB

    public static void main(String[] args) throws Exception{
        MappedByteBuffer out = new RandomAccessFile("D:/test.dat", "rw").getChannel().
                map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i =0;i<length;i++) {
            out.put((byte) 'x');
        }
        System.out.println("Запись завершена");
        for (int i=length/2;i<length/2+6;i++) {
            System.out.print((char)out.get(i));
        }
    }
}
