package com.iredko.testBook;

public class Bt extends At {
    String b;
    Integer a;

    String go(String b) {
        this.b=b;
        return super.go();
    }

    @Override
    String go() {
        return super.go();
    }

    Integer go(Integer b,Integer c){
        this.a=b+c;
        return a;
    }
}