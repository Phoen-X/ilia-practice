package com.iredko.testBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;




public class ComparatorTest{
    public static void main(String[] args) {

        CompType[] a = {new CompType(1,1), new CompType(2,55), new CompType(10,5), new CompType(3,6)};
        System.out.println("До " + Arrays.toString(a));
        Arrays.sort(a, new CompTypeComparator());
        System.out.println("После " + Arrays.toString(a));
    }
}

class CompTypeComparator implements Comparator<CompType> {
    public int compare(CompType o1, CompType o2){
        return (o1.j<o2.j ? -1 : (o1.j==o2.j ? 0:1));
    }
}
