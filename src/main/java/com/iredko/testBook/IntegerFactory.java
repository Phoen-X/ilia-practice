package com.iredko.testBook;

public class IntegerFactory implements FactoryI<Integer> {
    public Integer create(){
        return new Integer(0);
    }
}
