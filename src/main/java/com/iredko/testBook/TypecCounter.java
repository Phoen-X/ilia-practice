package com.iredko.testBook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IRedko on 11.09.2017.
 */
public class TypecCounter extends HashMap<Class<?>,Integer> {
    private Class<?> baseType;
    public TypecCounter(Class<?> baseType){
        this.baseType = baseType;
    }
    public void count(Object obj){
        Class<?> type = obj.getClass();
        if(!baseType.isAssignableFrom(type)){
            throw new RuntimeException(obj+"incorect type: "+type+" , shoud be type or subtype of "+ baseType);
        }
        countClass(type);
    }

    private void countClass(Class<?> type){
        Integer quantity = get(type);
        put(type,quantity==null ? 1:quantity+1);
        Class<?> superClass = type.getSuperclass();
        if(superClass!=null&&baseType.isAssignableFrom(superClass)){
            countClass(superClass);
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder("{");
        for(Map.Entry<Class<?>,Integer> pair:entrySet()){
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(" .");
        }
        result.delete(result.length()-2,result.length());
        result.append("}");
        return result.toString();
    }
}
