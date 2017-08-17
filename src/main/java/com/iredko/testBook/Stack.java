package com.iredko.testBook;

import java.util.LinkedList;

/**
 * Created by IRedko on 17.08.2017.
 */
public class Stack<T> {

    private LinkedList<T> storage = new LinkedList<T>();

    public void push(T v){
        storage.addFirst(v);
    }

    public T peek() {
        return storage.getFirst();
    }

    public T pop(){
        return storage.removeFirst();
    }

    public boolean empty(){
        return storage.isEmpty();
    }

    public String toString(){
        return storage.toString();
    }
}
