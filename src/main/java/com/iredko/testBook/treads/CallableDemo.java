package com.iredko.testBook.treads;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for(int i=0;i<10;i++) {
            results.add(service.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : results) {
            try{
                //Вызов get() блокируется до завершения
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                service.shutdown();
            }
        }
    }
}
