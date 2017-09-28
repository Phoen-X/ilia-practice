package com.iredko.testBook;

import java.util.Arrays;
import java.util.Random;

public class IceCream {
    private static Random random = new Random(47);
    static final String[] FLAVOURS = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };

    public static String[] flavorSet(int n) {
        if (n > FLAVOURS.length) {
            throw new IllegalArgumentException("Set too big");
        }
        String[] result = new String[n];
        boolean[] picked = new boolean[FLAVOURS.length];
        for(int i=0;i<n;i++) {
            int t;
            do {
                t = random.nextInt(FLAVOURS.length);
            } while (picked[t]);
            result[i] = FLAVOURS[t];
            picked[t]= true;
        }
        return result;
    }

    public static void main(String[] args) {
        for(int i = 0; i<7;i++) {
            System.out.println(Arrays.toString(flavorSet(3)));
        }
    }
}
