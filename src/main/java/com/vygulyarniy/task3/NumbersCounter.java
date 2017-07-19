package com.vygulyarniy.task3;

import java.util.ArrayList;
import java.util.regex.*;

import jdk.nashorn.internal.runtime.regexp.joni.Matcher;
import org.assertj.core.util.Compatibility;
import java.util.regex.*;

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
        int countNumbers=0;

        Pattern pat = Pattern.compile("[-]?[0-9]+(\\.[0-9]+)?");
        Matcher matcher = pat.matcher(text);
        while (matcher.find()) {
            Compatibility.System.out.println(matcher.group());
            countNumbers++;
        }
        return countNumbers;
    }
}
