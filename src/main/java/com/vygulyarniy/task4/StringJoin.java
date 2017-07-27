package com.vygulyarniy.task4;

import java.util.List;

public class StringJoin {

    /**
     * Нужно собрать список в строку, где елементы разделены заданным разделителем.
     * Например список из елементов "1" "2" "3" и разделителем "-" должен вернуться как строка 1-2-3
     * @param items список
     * @param delimiter разделитель между елементами
     * @return
     */
    public String join(List<String>items, char delimiter) {

        if (items == null) {
            return null;
        }
//        Iterator<String> iter = items.iterator();
        String joinedString = new String();

        for (String item: items){
            if(!(item =="")&&!(item==null)){
                joinedString = joinedString + item + delimiter;
            }
        }
        return joinedString;
    }


}
