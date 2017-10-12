package com.iredko.testBook;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {
    public static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        //Сохранение масива int
        ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016});
        //Чтение и запись по абсолютным позициям
        System.out.println(ib.get(3));
        ib.put(3, 1881);
        //Назначение нового предела перед смещением буфера
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }
    }
}
