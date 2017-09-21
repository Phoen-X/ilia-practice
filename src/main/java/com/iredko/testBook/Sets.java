package com.iredko.testBook;
import java.util.*;
/**
 * Created by IRedko on 21.09.2017.
 */
public class Sets {
    public static <T> Set <T> union(Set<T> a, Set<T> b){
        Set<T>  result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }

    public static <T> Set<T> interselection(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }

    public static <T>Set<T> difference(Set<T> superset,Set<T> subset){
        Set<T> result = new HashSet<T>(superset);
        result.removeAll(subset);
        return result;
    }

    public static <T> Set <T> complement(Set<T> a, Set<T> b){
        return difference(union(a,b),interselection(a,b));
    }
}
