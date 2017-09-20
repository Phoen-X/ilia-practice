package com.iredko.testBook;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by IRedko on 18.09.2017.
 */
public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();
    private Random random = new Random(47);

    public void add(T item) {
        storage.add(item);
    }
    public T select(){
        return storage.get(random.nextInt(storage.size()));
    }

    public int size(){
        return storage.size();
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        for(String s:("The quick brown fox jumped over "+ "the lazy brown dog").split(" ")){
            rs.add(s);
        }
        for(int i=0;i<rs.size();i++){
            System.out.print(rs.select()+ " ");
        }


    }


}
