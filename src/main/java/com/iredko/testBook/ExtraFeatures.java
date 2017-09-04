package com.iredko.testBook;

/**
 * Created by IRedko on 04.09.2017.
 */
public class ExtraFeatures {

    public  static void f() throws MyException2{
        System.out.println("MyException2 в f()");
        throw new MyException2();
    }

    public static void g() throws MyException2{
        System.out.println("MyException2 в g()");
        throw new MyException2("Возбужденно в g()");
    }

    public static void h() throws MyException2{
        System.out.println("MyException2 в h()");
        throw new MyException2("Возбуждено в h()",47);
    }

    public static void main(String[] args) {
        try{
            f();
        }catch (MyException2 e){
            e.printStackTrace(System.out);
        }

        try {
            g();
        }catch (MyException2 e){
            e.printStackTrace(System.out);
        }

        try{
            h();
        }catch (MyException2 e){
            e.printStackTrace(System.out);
            System.out.println("e.val() = " + e.val());
        }
    }
}
