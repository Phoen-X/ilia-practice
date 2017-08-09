package com.iredko.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by ItsEasy on 09.08.2017.
 */
public class Learn {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("Hello");
            System.out.println("World");
        };

        AbstractQuery q = new AbstractQuery("select * from city where name = ?",
                new ParameterSetter() {
                    @Override
                    public void setParams(PreparedStatement stmt) {
                        stmt.setString(1, "Vasya");
                    }
                },
        new ResultSetParser<City>() {

            @Override
            public City parse(ResultSet rs) {
                return new City(rs.getInt("id"), rs.getString("name"));
            }
        })

        r.run();
    }
}
