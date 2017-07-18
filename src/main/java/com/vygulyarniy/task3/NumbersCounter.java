package com.vygulyarniy.task3;

import java.util.regex.*;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class NumbersCounter {
    /**
     * Нужно реализовать подсчет чисел в тексте. На вход подается число, на выход количество чисел.
     * При этом дробные числа тоже должны распознаваться, например 17.25 это одно число.
     * Пример: в тексте "мы выехали в 15:25 из дому, проехали 700 км и потратили 95.5 баксов. Это были прекрасные 2 дня" 5 чисел.
     * (время здесь не является числом, поэтому там 2 числа - часы и минуты отдельно)
     *
     * @param text текст для подсчета
     * @return кол-во чисел
     */
    public int countNumbers(String text) {


        Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher = pat.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        return 1;
    }

    public static void main(String[] args) {
        NumbersCounter nc = new NumbersCounter();
        nc.countNumbers("Text246s 54895 45 45 41 151");
    }
}
