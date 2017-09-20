package com.iredko.testBook;

/**
 * Created by IRedko on 18.09.2017.
 */
public class TreeTuple<A,B,C> extends TwoTuple<A,B> {
    public final C third;
    public TreeTuple(A a, B b, C c){
        super(a,b);
        third = c;
    }
    public String toString(){
        return "(" + first +", "+ second+ ", "+ third+")";
    }
}
