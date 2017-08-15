package com.iredko.testBook;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by IRedko on 11.08.2017.
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection =  new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInt = {6,7,8,9,10};
        collection.addAll(Arrays.asList(moreInt));
        Collections.addAll(collection,11,12,13,14,15);
        Collections.addAll(collection,moreInt);
        List<Integer> list = Arrays.asList(16,17,18,19,20);
        list.set(1,99);
        //list.add(21,1);
        System.out.println(list);
    }
}
