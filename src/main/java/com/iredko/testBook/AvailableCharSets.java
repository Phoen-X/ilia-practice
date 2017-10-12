package com.iredko.testBook;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.SortedMap;

public class AvailableCharSets {
    public static void main(String[] args) {
        int count = 0;

        SortedMap<String, Charset> charSets= Charset.availableCharsets();
        Iterator<String> it = charSets.keySet().iterator();
        //System.out.println(charSets.keySet());
        while (it.hasNext()) {
            String csName = it.next();
            System.out.print(count+":["+csName);
            count++;
            Iterator aliases = charSets.get(csName).aliases().iterator();
            if (aliases.hasNext()) {
                System.out.print(": ");
            }
            while (aliases.hasNext()) {
                System.out.print(aliases.next());
                if (aliases.hasNext()) {
                    System.out.print(". ");
                }
            }
            System.out.println("]");
        }
    }
}
