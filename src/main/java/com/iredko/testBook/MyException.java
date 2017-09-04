package com.iredko.testBook;

/**
 * Created by IRedko on 04.09.2017.
 */
public class MyException extends Exception {
    public MyException(){};
    public MyException(String msg){
        super(msg);
    }
}
