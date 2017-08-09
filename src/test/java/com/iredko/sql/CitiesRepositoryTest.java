package com.iredko.sql;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by ItsEasy on 09.08.2017.
 */
public class CitiesRepositoryTest {

    @Test
    public void shouldSelectAll() throws Exception {
        List<City> all = new CitiesRepository().findAll();

        System.out.println(all);

    }
}