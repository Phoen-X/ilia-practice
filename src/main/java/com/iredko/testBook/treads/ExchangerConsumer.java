package com.iredko.testBook.treads;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerConsumer<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;

    ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder) {
        exchanger = ex;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                for (T x : holder) {
                    value = x;//Выборка значения
                    holder.remove(x);//Нормально для CopyOnWriteArrayList
                }
            }
        } catch (InterruptedException e) {
            //Приемлемый способ завершения
        }
        System.out.println("Итоговое значение: "+value);
    }
}
