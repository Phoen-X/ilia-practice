package com.iredko.testBook;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockingMappedFiles {
    static final int LENGTH = 0x8FFFFFF;
    static FileChannel fileChannel;

    public static void main(String[] args) throws IOException {
        fileChannel = new RandomAccessFile("D:/test.dat", "rw").getChannel();
        MappedByteBuffer out = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            out.put((byte) 'x');
        }
        new LockAndModify(out, 0, 0 + LENGTH / 3);
        new LockAndModify(out, LENGTH / 2, LENGTH / 2 + LENGTH / 4);
    }

    public static class LockAndModify extends Thread {
        private ByteBuffer byteBuffer;
        private int start, end;

        public LockAndModify(ByteBuffer argByteBuffer, int start, int end) {
            this.byteBuffer = argByteBuffer;
            this.start = start;
            this.end = end;
            byteBuffer.limit(end);
            byteBuffer = argByteBuffer.slice();
            start();
        }

        public void run() {
            try {
                //Монопольная блокировка без перекрытия
                FileLock fileLock = fileChannel.lock(start, end, false);
                System.out.println("Заблокировано: " + start + " to " + end);
                //Модификация
                while (byteBuffer.position() < byteBuffer.limit() - 1) {
                    byteBuffer.put((byte) (byteBuffer.get() + 1));
                    fileLock.release();
                }
                System.out.println("Освобожденно " + start + " to " + end);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
