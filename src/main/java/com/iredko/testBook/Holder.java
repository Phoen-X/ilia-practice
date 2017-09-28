package com.iredko.testBook;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Holder<T> {
    private T value;
    public Holder(){}
    public Holder(T value) {
        this.value = value;
    }

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object o){
        return value.equals(o);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<Apple>(new Apple());
        Apple d = apple.get();
        apple.set(d);
        Holder<? extends Fruit> fruit = apple;
        Fruit p = fruit.get();
        d = (Apple) fruit.get();
        try {
            Orange c = (Orange) fruit.get();
        } catch (Exception e) {
            System.out.println(e);
        }
//      fruit.set(new Fruit());
//      fruit.set(new Apple());
        System.out.println(fruit.equals(d));
    }



}
