package com.iredko.testBook;

/**
 * Created by IRedko on 04.09.2017.
 */
public class LoggingExceptions {
    public static void main(String[] args) {
        try{
            throw new LoggingException();
        }catch (LoggingException e){
            System.err.println("Перехвачено " + e );
        }
        System.err.println("-----------------------------");
        try{
            throw new LoggingException();
        }catch (LoggingException e){
            System.err.println("Перехвачено " + e);
        }
    }
}
