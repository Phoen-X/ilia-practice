package com.vygulyarniy.task2;

import java.util.HashMap;
import java.util.Map;

public class DigitsCounter {

    /**
     * Нужно реализовать счетчик цифер в тексте.
     * например, для текста "мы будем ехать 100км 18-м автобусом в 12:35" должно возвращать число 9.
     *
     * @param text текст, в котором мы считаем цифры
     * @return кол-во цифр в приведенном тексте
     */
    int countIntDigits = 0;


    char[] numArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int digitsCount(String text) {
        if (text == null || text.equals("")) {
            return 0;
        } else {
            char[] charArray = text.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                for (int j = 0; j < numArray.length; j++) {
                    if (charArray[i] == numArray[j]) {
                        countIntDigits++;
                    }
                }
            }
            //String countStringDigits = Integer.toString(countIntDigits);
            return countIntDigits;
        }
    }

    public String digitsCountAllNum(String text) {
        if (text == null || text.equals("")) {
            return "0";
        } else {
            char[] charArray = text.toCharArray();
            Map<Character,Integer> allDigitsNum = new HashMap<Character,Integer>();

            for(char ch: charArray) {
                Integer currentStat = allDigitsNum.get(ch);
                if (currentStat == null) {
                    currentStat = 0;
                }
                currentStat++;
                allDigitsNum.put(ch, currentStat);
            }
            return allDigitsNum.toString();
        }
    }

    public static void main(String[] args) {
        DigitsCounter d = new DigitsCounter();
        d.go();
    }

    public void go() {
        String s=digitsCountAllNum("shfj4574sda48415a1d5s1");
        System.out.println(s);
    }
}
