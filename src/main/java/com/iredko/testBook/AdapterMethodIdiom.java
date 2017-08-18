package com.iredko.testBook;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;

/**
 * Created by IRedko on 18.08.2017.
 */
public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ResersibleArrayList<String> ral = new ResersibleArrayList<>(Arrays.asList("To be or not to be".split(" ")));

        for(String s: ral) {
            System.out.print(s + " ");
        }
        System.out.println();
        for(String s:ral.reversed()){
            System.out.print(s+" ");
        }
    }
}
