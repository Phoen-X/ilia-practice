package com.iredko.testBook;

public class GenericArray<T> {
    private Object[] arrray;

    public GenericArray(int size) {
        arrray = new Object[size];
    }

    public void put(int index, T item) {
        arrray[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) arrray[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep() {
        return (T[]) arrray;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
        for (int i=0;i<10;i++) {
            gai.put(i, i);
        }
        for (int i=0;i<10;i++) {
            System.out.print(gai.get(i)+" ");
        }
        System.out.println();
        try {
            Integer[] ia = gai.rep();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
