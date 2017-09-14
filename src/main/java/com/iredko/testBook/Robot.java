package com.iredko.testBook;

import java.util.List;

/**
 * Created by IRedko on 14.09.2017.
 */
public interface Robot {
    String name();
    String model();
    List<Operation> operations();
    class Test{
        public static void test(Robot r){
            if(r instanceof MyNull){
                System.out.println("[Null Robot]");
            }
            System.out.println("Название: " +r.name());
            System.out.println("Модель: "+ r.model());
            for(Operation operation: r.operations()){
                System.out.println(operation.description());
                operation.command();
            }
        }
    }

}
