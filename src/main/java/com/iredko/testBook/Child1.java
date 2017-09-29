package com.iredko.testBook;

public class Child1 extends Super1{

    int a = 1;
    void h(){
        if (a<2){
            System.out.println("xjfkld");
        }
    }
    public static void main(String[] args) {
        Child1 child1 = new Child1();
        System.out.println(child1.go());
    }
}
