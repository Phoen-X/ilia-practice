package com.iredko.testBook;

import java.util.ArrayList;

/**
 * Created by IRedko on 22.09.2017.
 */
public class Aisle extends ArrayList<Shelf> {
    public Aisle(int nShelves, int nProducts){
        for(int i=0;i<nShelves;i++){
            add(new Shelf(nProducts));
        }
    }
}
