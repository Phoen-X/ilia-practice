package com.iredko.testBook.treads;

public class Pair {//Non thread-safe
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equal: "+Pair.this);
        }
    }

    //Произвольный вариант -обе переменные должны быть равны:
    public void checkState() {
        if (x != y) {
            throw new PairValuesNotEqualException();
        }
    }

}
