package com.iredko.testBook;

import com.vygulyarniy.CheckingChangeFile;

import java.util.ArrayList;

/**
 * Created by IRedko on 22.09.2017.
 */
public class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> chechouts = new ArrayList<>();
//    private Office office = new Office();
    public Store(int nAisle, int nShelves, int nProduct){
        for(int i=0;i<nAisle;i++ ){
            add(new Aisle(nShelves,nProduct));
        }
    }

    @Override
    public String toString() {
        StringBuilder result= new StringBuilder();
        for(Aisle a:this){
            for (Shelf s: a){
                for (Product p :s){
                    result.append(p);
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(14,5,10));
    }
}
