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
        int result = 0;
        if (index <= 0) {
            return Integer.parseInt(null);
        }
        if (index < 3) {
            return 1;
        }
        for (int i = 2; i < index; i++) {
            result = giveNumber(index - 1) + giveNumber(index - 2);
        }
        return result;
    }
}



//    public int giveNumber(int index) {
//        if (index <= 0) {
//            return Integer.parseInt(null);
//        }
//        if (index < 3) {
//            return 1;
//        } else {
//            int[] fibo = new int[index];
//            fibo[0]=1;
//            fibo[1]=1;
//            for (int i = 2; i < index; i++) {
//                fibo[i]=fibo[i-1]+fibo[i-2];
//            }
//            return fibo[index - 1];
//        }
//    }
//}
