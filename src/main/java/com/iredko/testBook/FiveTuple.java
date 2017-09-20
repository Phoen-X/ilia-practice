package com.iredko.testBook;

/**
 * Created by IRedko on 18.09.2017.
 */
public class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D> {
    public final E fifth;
    public FiveTuple(A a,B b,C c,D d,E e){
        super(a,b,c,d);
        fifth=e;
    }

    @Override
    public String toString() {
        return "(" + first +", "+ second+ ", "+ third+", "+ fourth+", "+ fifth+")";
    }
}
