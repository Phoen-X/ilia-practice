package com.iredko;

/**
 * Created by IRedko on 09.08.2017.
 */
interface Selector {
    boolean end();
    Object current();
    void next();
}
