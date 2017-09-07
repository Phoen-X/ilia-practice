package com.iredko.testBook;

/**
 * Created by IRedko on 06.09.2017.
 */
public class Rethrowing {
    public static void f()throws Exception{
        System.out.println("Созданно исключение в f()");
        throw new Exception("возбуждено в f()");
    }

    public static void g() throws Exception{
        try{
            f();
        }catch (Exception e){
            System.out.println("В методе g(). e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }

    public static void h()throws Exception{
        try{
            f();
        }catch (Exception e){
            System.out.println("В методе h(). e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception)e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
            g();
        }catch (Exception e){
            System.out.println("Main.printStackTrace");
            e.printStackTrace(System.out);
        }
        try{
            h();
        }catch (Exception e){
            System.out.println("Main.printStackTrace");
            e.printStackTrace(System.out);
        }

    }
}
