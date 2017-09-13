package com.iredko.testBook;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by IRedko on 13.09.2017.
 */
public class MethodSelector implements InvocationHandler {
    private Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("interesting")){
            System.out.println("Посредник обнаружил интересный метод");
        }
        return method.invoke(proxied, args);
    }
}
