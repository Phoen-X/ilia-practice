package com.vygulyarniy.task2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DigitsCounter {

    /**
     * Нужно реализовать счетчик цифер в тексте.
     * например, для текста "мы будем ехать 100км 18-м автобусом в 12:35" должно возвращать число 9.
     *
     * @param text текст, в котором мы считаем цифры
     * @return кол-во цифр в приведенном тексте
     */
    int countIntDigits=0;


    char[] numArray = {'0','1','2','3','4','5','6','7','8','9'};
    public String digitsCount(String text) {
        char[] charArray = text.toCharArray();
        if (text==null || text.equals("")){
            return "0";
        }else
        for (int i=0; i<text.length();i++){
            for (int j=0; j<numArray.length;j++){
                if(charArray[i]==numArray[j]){
                    countIntDigits++;
                }
            }
        }
        String countStringDigits = Integer.toString(countIntDigits);
        return countStringDigits;
    }

    public String digitsCountAllNum(){throw new NotImplementedException();}
}
