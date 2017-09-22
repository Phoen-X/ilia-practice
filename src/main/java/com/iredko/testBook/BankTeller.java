package com.iredko.testBook;

import java.util.*;

/**
 * Created by IRedko on 22.09.2017.
 */
public class BankTeller {
    public static void serve(Teller t, Customer c){
        System.out.println(t+" обслуживает "+ c);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Customer> line = new LinkedList<Customer>();
        System.out.println(line);
        Generators.fill(line,Customer.generator(),15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator,4);
        for (Customer c: line){
            serve(tellers.get(random.nextInt(tellers.size())),c);
        }

    }
}
