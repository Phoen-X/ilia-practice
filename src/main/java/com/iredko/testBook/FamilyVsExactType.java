package com.iredko.testBook;

/**
 * Created by IRedko on 11.09.2017.
 */
public class FamilyVsExactType {
    static void test(Object x){
        System.out.println("Тестируем х типа "+ x.getClass());
        System.out.println("x instanceof Base "+(x instanceof Base));
        System.out.println("x instanceof Derived "+ (x instanceof Derived));
        System.out.println("Base.isInstance(x) "+ Base.class.isInstance(x));
        System.out.println("Derived.isInstance(x) "+ Derived.class.isInstance(x));
        System.out.println("x.getClass()== Base.class "+ (x.getClass()==Base.class));
        System.out.println("x.getClass()==Derived.class) " +(x.getClass()==Derived.class));
        System.out.println("x.getClass().equals(Base.class) " +x.getClass().equals(Base.class));
        System.out.println("x.getClass().equals(Derived.class) "+ x.getClass().equals(Derived.class));
    }

    public static void main(String[] args) {
        test(new Base());
        test(new Derived());
    }
}
