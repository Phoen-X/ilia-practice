package com.iredko.testBook;

/**
 * Created by IRedko on 22.09.2017.
 */
public class Customer {
    private static long counter=1;
    private final long id = counter++;
    private Customer(){}

    @Override
    public String toString() {
        return "Customer "+id ;
    }
    public static Generator<Customer> generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }

}
