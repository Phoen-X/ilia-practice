package com.iredko.testBook;

/**
 * Created by IRedko on 18.08.2017.
 */
public class InheritingException {

    class SimpleException extends Exception{}

    public void f() throws SimpleException{
        System.out.println("Возбуждаем SimpleException из f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingException sed = new InheritingException();
        try{
            sed.f();
        }catch (SimpleException e){
            System.out.println("Перехвачено");
        }
    }
}
