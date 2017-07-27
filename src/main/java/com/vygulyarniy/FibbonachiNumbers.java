package com.vygulyarniy;

import com.sun.org.apache.xpath.internal.SourceTree;

public class FibbonachiNumbers {
    /**
     * Метод должен возвращать N-тый елемент чисел Фиббоначи.
     * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
     *
     * @param index порядковый номер числа, начиная с 1
     * @return
     */
    public int giveNumber(int index) {
        if (index <= 0) {
            return Integer.parseInt(null);
        }
        if (index < 3) {
            return 1;
        } else {
            int a = 1;
            int b = 1;
            int c;
            int[] fibo = new int[index];
            fibo[0] = a;
            fibo[1] = b;

            for (int i = 2; i < index; i++) {
                c = a + b;
                a = b;
                b = c;
                fibo[i] = b;
            }

            return fibo[index - 1];
        }
    }

    public static void main(String[] args) {
        FibbonachiNumbers f = new FibbonachiNumbers();
        System.out.println(f.giveNumber(10));
    }
}
