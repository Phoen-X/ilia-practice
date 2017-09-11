package com.iredko.testBook;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by IRedko on 08.09.2017.
 */
public class WrapCheckedException {
    void throwRuntimeException(int type){
        try{
            switch (type){
                case 0: throw new FileNotFoundException();
                case 1: throw new IOException();
                case 2: throw new RuntimeException("Где Я?");
                default:return;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
