package com.iredko.testBook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by IRedko on 18.08.2017.
 */
public class ResersibleArrayList<T> extends ArrayList<T>{
    public ResersibleArrayList(Collection<T> c){
        super(c);
    }
    public Iterable<T> reversed(){
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;

                    public boolean hasNext() {
                        return current > -1;
                    }
                    public T next() {
                        return get(current--);
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };

            }
        };
    }
}
