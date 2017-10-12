package com.iredko.testBook;

import java.nio.*;

public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
        bb.rewind();
        System.out.print("Буфер Byte: ");
        while (bb.hasRemaining()) {
            System.out.print(bb.position() + " -> "+ bb.get()+ ". ");
        }
        System.out.println();

        CharBuffer cb = ((ByteBuffer) bb.rewind()).asCharBuffer();
        System.out.print("Буфер Char: ");
        while (cb.hasRemaining()) {
            System.out.print(cb.position() + " -> "+ cb.get()+ ". ");
        }
        System.out.println();

        FloatBuffer fb = ((ByteBuffer) bb.rewind()).asFloatBuffer();
        System.out.print("Буфер Float: ");
        while (fb.hasRemaining()) {
            System.out.print(fb.position() + " -> "+ fb.get()+ ". ");
        }
        System.out.println();

        IntBuffer ib = ((ByteBuffer) bb.rewind()).asIntBuffer();
        System.out.print("Буфер Int: ");
        while (ib.hasRemaining()) {
            System.out.print(ib.position() + " -> "+ ib.get()+ ". ");
        }
        System.out.println();

        LongBuffer lb = ((ByteBuffer) bb.rewind()).asLongBuffer();
        System.out.print("Буфер Long: ");
        while (lb.hasRemaining()) {
            System.out.print(lb.position() + " -> "+ lb.get()+ ". ");
        }
        System.out.println();

        ShortBuffer sb = ((ByteBuffer) bb.rewind()).asShortBuffer();
        System.out.print("Буфер Short: ");
        while (sb.hasRemaining()) {
            System.out.print(sb.position() + " -> "+ sb.get()+ ". ");
        }
        System.out.println();

        DoubleBuffer db = ((ByteBuffer) bb.rewind()).asDoubleBuffer();
        System.out.print("Буфер Double: ");
        while (db.hasRemaining()) {
            System.out.print(db.position() + " -> "+ db.get()+ ". ");
        }
        System.out.println();




    }
}
