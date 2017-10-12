package com.iredko.testBook;

import java.nio.ByteBuffer;

public class GetData {
    public static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        //При выделении буфер заполняется полями
        int i = 0;
        while (i++ < bb.limit()) {
            if (bb.get() != 0) {
                System.out.println("nonzero");
            }
        }
        System.out.println("i = " + i);
        bb.rewind();
        //Сохраняем и считываем символьный массив
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0) {
            System.out.print(c + " ");
        }
        System.out.println();
        bb.rewind();
        //Сохраняем и считываем число типа short
        bb.asShortBuffer().put((short)471142);
        System.out.println(bb.getShort());
        bb.rewind();
        //Сохраняем и считываем число типа int
        bb.asIntBuffer().put(99471142);
        System.out.println(bb.getInt());
        //Сохраняем и считываем число типа long
        bb.asLongBuffer().put(99471142);
        System.out.println(bb.getLong());
        //Сохраняем и считываем число типа float
        bb.asFloatBuffer().put(99471142);
        System.out.println(bb.getFloat());
        //Сохраняем и считываем число типа double
        bb.asDoubleBuffer().put(99471142);
        System.out.println(bb.getDouble());
    }
}
