package com.iredko;

import java.util.InputMismatchException;

/**
 * Created by IRedko on 09.08.2017.
 */
public class Sequnce {
    private Object[] objects;
    private int next = 0;
    public Sequnce(int size){
        objects = new Object[size];
    }
    public void add(Object x){
        if(next<objects.length) {
            objects[next++] = x;
        }
    }

    public class SequenceSelector implements Selector{
        private int i=0;

        @Override
        public boolean end() {
            return i==objects.length;
        }

        @Override
        public Object current() {
            return objects[i];
        }

        @Override
        public void next() {
            if(i<objects.length){
                i++;
            }
        }
    }

    public Selector getSelector(){
        return new SequenceSelector();
    }

    public static void main(String[] args){
        Sequnce sequnce = new Sequnce(10);
        for(int i=0;i<10;i++){
            sequnce.add(Integer.toString(i));
        }
        Selector selector = sequnce.getSelector();
        while (!selector.end()){
            System.out.println(selector.current()+" ");
            selector.next();
        }
    }
}
