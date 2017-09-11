package com.iredko.sql;

import org.omg.SendingContext.RunTime;

import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

/**
 * Created by IRedko on 11.09.2017.
 */
public class DbUtils {
    /**
     * метод чтобы размаппить результаты SQL запроса в обьект (вне зависимости от того что это за обьект)
     *
     * @param rs          результаты запроса
     * @param targetClass класс на который мы маппим 1 запись из базы
     */
    public static <T> List <T> mapDbResult(ResultSet rs, Class<T> targetClass) throws SQLException{
        List<T> result = new ArrayList<T>();
        while(rs.next()){
            T record = mapRecord(rs, targetClass);
            result.add(record);
        }
        return result;
    }

    private static <T> T mapRecord(ResultSet rs, Class<T> targetClass) throws SQLException{
        try {
            T instance = targetClass.newInstance();
            // создаем новый обьект заданного типа, пытаясь вызвать конструктор без параметров.
            // Если у класса T такого конструктора не будет или он будет приватным - получим исключение
            Field[] classFields = targetClass.getFields();
            // получаем список полей нашего обьекта куда будем маппить результаты запроса
            for (Field field: classFields){
                String fieldName = field.getName();
                // название поля (для класса City мы тут получим id либо name
                Class fieldType = field.getType();
                // тип поля. Получим здесь String.class для поля name например
                Object recordFieldVslue = getValue(rs,fieldName,fieldType);
                // получаем значение колонки правильным образом (в зависимости от типа поля)
            }
            return instance;
        }catch (InstantiationException|IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Маппит 1 колонку из базы в обьект типа type
     *
     * @param rs         обьект содержащий результаты SQL запроса (текущей строки)
     * @param columnName имя колонки которое нас интересует
     * @param type       тип к которому мы будем приводить колонку
     * @return значение колонки из бд
     * @throws SQLException
     */
    private static Object getValue(ResultSet rs, String columnName, Class type) throws SQLException{
        // пока что мы умеем конвертировать только в стрингу и число :)
        if (type==Integer.class){
            return rs.getInt(columnName);
        }else if(type==String.class){
            return rs.getShort(columnName);
        }else {
            throw new IllegalArgumentException("Я еще не умею работать с типом"+ type.getName());
        }
    }
}
