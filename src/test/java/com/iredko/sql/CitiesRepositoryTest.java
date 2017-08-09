package com.iredko.sql;

import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by ItsEasy on 09.08.2017.
 */
public class CitiesRepositoryTest {

    @Test
    public void shouldSelectAll() throws Exception {
        List<City> all = new CitiesRepository().findAll();

        System.out.println(all);

    }

    @Test
    public void shouldSearchByName() throws Exception {
        City city = new CitiesRepository().findByName("Haag0");

        System.out.println(city);

    }
}