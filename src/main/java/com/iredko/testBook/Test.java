package com.iredko.testBook;

import java.util.*;

public class Test {
    public void go(int value) {
        Random random = new Random(47);
        Set<Integer> randomList = new HashSet<>();
        int[][] matrix = new int[value][value];
        for (int k = 0; k < value; k++) {
            for (int j = 0; j < value; j++) {
                do {
                    Integer ourValue = random.nextInt(value * value + 1);
                    if (!randomList.contains(ourValue) && ourValue != 0) {
                        matrix[j][k] = ourValue;
                        randomList.add(ourValue);
                    }
                } while (matrix[j][k] == 0);
            }
        }
        if (value % 2 == 0) {
            System.out.print(matrix[value / 2 - 1][value / 2 - 1] + " " + matrix[value / 2][value / 2 - 1] + " " + matrix[value / 2][value / 2]);
            System.out.println(" sum: " + (matrix[value / 2 - 1][value / 2 - 1] + matrix[value / 2][value / 2 - 1] + matrix[value / 2][value / 2]));
            System.out.println();
        }
        if (value % 2 != 0) {
            System.out.print(matrix[value / 2][value / 2] + " " + matrix[value / 2][value / 2 - 1] + " " + matrix[value / 2 + 1][value / 2]);
            System.out.println(" sum: " + (matrix[value / 2][value / 2] + matrix[value / 2][value / 2 - 1] + matrix[value / 2 + 1][value / 2]));
            System.out.println();
        }

        for (int k = 0; k < value; k++) {
            System.out.println(Arrays.toString(matrix[k]));
        }
    }


    public void circle(int value) {
        int currentValue = 0;
        int nextCircleCnt = 0;
        int[][] matrix = new int[value][value];
        do {
            for (int i = 0; i < value - 2 * nextCircleCnt; i++) {
                matrix[0 + nextCircleCnt][i + nextCircleCnt] = currentValue + 1;
                currentValue = currentValue + 1;
            }
            for (int i = 0; i < value - 1 - 2 * nextCircleCnt; i++) {
                matrix[i + 1 + nextCircleCnt][value - 1 - nextCircleCnt] = currentValue + 1;
                currentValue = currentValue + 1;
            }
            for (int i = 0; i < value - 1 - 2 * nextCircleCnt; i++) {
                matrix[value - 1 - nextCircleCnt][value - 2 - nextCircleCnt - i] = currentValue + 1;
                currentValue = currentValue + 1;
            }
            for (int i = 0; i < value - 2 - 2 * nextCircleCnt; i++) {
                matrix[value - 2 - nextCircleCnt - i][0 + nextCircleCnt] = currentValue + 1;
                currentValue = currentValue + 1;
            }
            nextCircleCnt = nextCircleCnt + 1;
        }while (currentValue!=(value*value));
        for (int k = 0; k < value; k++) {
            System.out.println(Arrays.toString(matrix[k]));
        }
    }


    public static void main(String[] args) {
        Test t = new Test();
        t.go(6);
    }

}
