package com.iredko.testBook;

import java.util.ArrayList;
import java.util.List;

public class InstantiateGenericType<T> {
    class Beba{};

    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> успех");
        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        } catch (Exception e) {
            System.out.println("ClassAsFactory<Integer> неудача");
        }
    }
}
