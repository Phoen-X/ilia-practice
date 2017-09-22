package com.iredko.testBook;

import java.util.ArrayList;

/**
 * Created by IRedko on 22.09.2017.
 */
public class Shelf extends ArrayList<Product> {
    public Shelf(int nProducts){
        Generators.fill(this,Product.generator,nProducts);
    }
}
