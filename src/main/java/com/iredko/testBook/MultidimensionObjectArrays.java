package com.iredko.testBook;

import java.util.Arrays;

public class MultidimensionObjectArrays {
    public static void main(String[] args) {
        BerylliumSphere[][] spheres = {
                {new BerylliumSphere(),new BerylliumSphere()},
                {new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()},
                {new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere(),
                        new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()
                }
        };
        System.out.println(Arrays.deepToString(spheres));
    }
}
