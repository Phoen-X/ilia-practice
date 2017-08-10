package com.iredko.testBook;

/**
 * Created by IRedko on 10.08.2017.
 */
public class Calle2 extends MyIncrement{
    private int i=0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    private class Clousure implements Incrementable{
        @Override
        public void increment() {
            Calle2.this.increment();
        }
    }

    Incrementable getCallbackReference(){
        return new Clousure();
    }
}
