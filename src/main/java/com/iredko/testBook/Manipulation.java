package com.iredko.testBook;

class Manipulator<T extends HasF> {
    private T obj;

    public Manipulator(T x) {
        obj = x;
    }
    public void manipulate() {
        obj.f();
    }
}

public class Manipulation{
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}
