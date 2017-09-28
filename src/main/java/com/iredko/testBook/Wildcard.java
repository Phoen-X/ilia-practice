package com.iredko.testBook;

import java.util.LongSummaryStatistics;

public class Wildcard {
    static void rawArgs(Holder holder, Object arg) {
        holder.set(arg);
        holder.set(new Wildcard());
//        T t = holder.get();
        Object obj = holder.get();
    }


    static void unboundedArg(Holder<?> holder, Object arg) {
//        holder.set(arg);
//        holder.set(new Wildcard());
//        T t = holder.get();
//        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubType(Holder<? extends T> holder, T arg) {
//        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> void wildSuperType(Holder<? super T> holder, T arg) {
        holder.set(arg);
//        T t = holder.get();
        Object object = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        raw = new Holder();
        Holder<Long> qualifies = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualifies, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualifies, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        Object r1 = exact1(raw);
//        Long r2 = exact1(qualifies);
        Object r3 = exact1(unbounded);
//        Long r4 = exact1(bounded);

        Long r5 = exact2(raw, lng);
        Long r6 = exact2(qualifies, lng);
//        Long r7 = exact2(unbounded, lng);
//        Long r8 = exact2(bounded, lng);


        Long r9 = wildSubType(raw, lng);
        Long r10 = wildSubType(qualifies, lng);
        Object r11 = wildSubType(unbounded, lng);
        Long r12 = wildSubType(bounded, lng);

        wildSuperType(raw, lng);
        wildSuperType(qualifies,lng);
//        wildSuperType(unbounded,lng);
//        wildSuperType(bounded,lng);

    }

}
