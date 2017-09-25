package com.iredko.testBook;

import java.util.ArrayList;
import java.util.List;

public class ClassAsFactory<T> {
    T x;
    public ClassAsFactory(Class<T> kind){

        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
