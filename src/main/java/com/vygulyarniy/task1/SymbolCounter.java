package com.vygulyarniy.task1;

import com.sun.org.apache.xpath.internal.SourceTree;
import sun.net.SocksProxy;
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
        if (text == null || text.equals("")) {
            return null;
        } else {
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

}

//    public SymbolStatistics findMostPopularSymbol(String text) {
//        if (text == null || text.equals("")) {
//            return null;
//        } else {
//            char[] arr = text.toCharArray();
//
//            Map<Character, Integer> stats = new HashMap<Character, Integer>();
//
//            for (char ch : arr) {
//                Integer currentStat = stats.get(ch);
//                if (currentStat == null) {
//                    currentStat = 0;
//                }
//                currentStat++;
//                stats.put(ch, currentStat);
//            }
//
//            SymbolStatistics maxStat = null;
//            for (Character character : stats.keySet()) {
//                int occurences = stats.get(character);
//                if(maxStat == null || occurences > maxStat.getCount()) {
//                    maxStat = new SymbolStatistics(character, occurences);
//                }
//            }
//            return maxStat;
//        }
//
//
//    }
