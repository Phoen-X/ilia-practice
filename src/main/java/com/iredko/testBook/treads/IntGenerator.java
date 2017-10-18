package com.iredko.testBook.treads;

public abstract class IntGenerator {
    private volatile boolean cancelled = false;

    public abstract int next();
    //Для отмены
    public void cancel(){
        cancelled = true;}
    public boolean isCancelled() {
        return cancelled;
    }
}
