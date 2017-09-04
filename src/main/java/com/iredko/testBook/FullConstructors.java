package com.iredko.testBook;

/**
 * Created by IRedko on 18.08.2017.
 */
public class FullConstructors {

    static class MyException extends Exception{
        public MyException(){}
        public MyException(String msg){super(msg);}
    }

    public static void f()throws MyException{
        System.out.println("Возбуждаем MyException из f()");
        throw new MyException();
    }

    public static void g() throws MyException{
        System.out.println("Возбуждаем MyException из g()");
        throw new MyException("Создано в g()");
    }

    public static void main(String[] args) {
        try{
            f();
        }catch (MyException e){
            e.printStackTrace(System.err);
        }
        try{
            g();
        }catch (MyException e){
            e.printStackTrace(System.err);
        }
    }
}
