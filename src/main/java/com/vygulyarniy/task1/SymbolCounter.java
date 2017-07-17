package com.vygulyarniy.task1;

import jdk.nashorn.internal.ir.Symbol;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class SymbolCounter {
    /**
     * Нужно найти самую популярную букву в тексте и вернуть статистику ее использования.
     * Пример: для текста "Мы шли, шли, шли, пирожок нашли." нужно вернуть букву "и", и кол-вом использований 5
     *
     * @param text текст для подсчетов
     * @return информация о самой часто-упоминаемой букве/цифре
     */
    public SymbolStatistics findMostPopularSymbol(String text) {
        int maxCount=0;
        char charWithMaxCount=' ';
        char[] charArray = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < text.length(); j++) {
                int n = 0;
                if (charArray[i] == charArray[j]) {
                    n++;
                    if(n>maxCount){
                        maxCount=n;
                        charWithMaxCount=charArray[i];
                    }
                }
            }

        }

        SymbolStatistics result = new SymbolStatistics(charWithMaxCount, maxCount);
        return result;
    }
}
