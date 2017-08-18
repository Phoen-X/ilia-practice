package com.iredko.testBook;

import java.util.Map;

/**
 * Created by IRedko on 17.08.2017.
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        for(Map.Entry entry: System.getenv().entrySet() ){
            System.out.println(entry.getKey()+": " + entry.getValue());
        }
    }
}
