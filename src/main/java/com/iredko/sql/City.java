package com.iredko.sql;

/**
 * Created by ItsEasy on 09.08.2017.
 */
public class City {
    private final long id;
    private final String name;

    public City(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
