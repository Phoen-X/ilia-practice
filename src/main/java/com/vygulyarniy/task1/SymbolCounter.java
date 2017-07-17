package com.vygulyarniy.task1;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SymbolCounter {

    int maxCount = 0;
    char charWithMaxCount;


    /**
     * Нужно найти самую популярную букву в тексте и вернуть статистику ее использования.
     * Пример: для текста "Мы шли, шли, шли, пирожок нашли." нужно вернуть букву "и", и кол-вом использований 5
     *
     * @param text текст для подсчетов
     * @return информация о самой часто-упоминаемой букве/цифре
     */
    public SymbolStatistics findMostPopularSymbol(String text) {

        char[] charArray = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            int numOfCount = 0;
            for (int j = 0; j < text.length(); j++) {
                if (charArray[i] == charArray[j]) {
                    numOfCount++;
                    if (numOfCount > maxCount) {
                        maxCount = numOfCount;
                        charWithMaxCount = charArray[i];
                    }
                }
            }

        }

        SymbolStatistics result = new SymbolStatistics(charWithMaxCount, maxCount);
        return result;
    }
}
