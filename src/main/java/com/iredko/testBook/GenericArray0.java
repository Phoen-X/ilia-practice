package com.iredko.testBook;

import java.util.ArrayList;

public class GenericArray0<T> {
    private T[] arrray;

    @SuppressWarnings("unchecked")
    public GenericArray0(int sz) {
        arrray = (T[]) new Object[sz];
    }

    public void put(int index, T item) {
        arrray[index] = item;
    }

    public T get(int index) {
        return arrray[index];
    }
    public T[] rep() {
        return arrray;
    }

    public static void main(String[] args) {
        GenericArray0<Integer> gai = new GenericArray0<>(10);
        //Integer[] ia = gai.rep();
        Object[] oa = gai.rep();
        //System.out.println(ia);
        System.out.println(oa);

    }
}
