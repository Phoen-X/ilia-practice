package com.iredko.testBook;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CompType implements Comparable<CompType>{
    int i;
    int j;
    private static int count = 1;

    public CompType(int n1, int n2) {
        j=n2;
        i=n1;
    }

    public String toString(){
        String result = "[i = " + i + ", j = " + j + "]";
        if (count++ % 3 == 0) {
            result += "\n";
        }
        return result;
    }

    public int compareTo(CompType rv) {
        return (i<rv.i ? -1 : (i==rv.i ? 0 : 1));
    }

    private static Random random = new Random(47);
    public static Generator<CompType> generator(){
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(random.nextInt(100), random.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] a = {new CompType(1,1), new CompType(2,55), new CompType(10,65), new CompType(3,6)};
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

    }
}
