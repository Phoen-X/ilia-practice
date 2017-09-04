package com.iredko.testBook;

/**
 * Created by IRedko on 04.09.2017.
 */
public class MyException2 extends Exception {
    private int x;

    public MyException2(){}

    public MyException2(String msg){
        super(msg);
    }

    public MyException2(String msg, int x){
        super(msg);
        this.x=x;
    }

    public  int val() {return x;}

    public String getMessage(){
        return "Подробное сообщение: " + x + " " + super.getMessage();
    }
}
