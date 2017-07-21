package com.vygulyarniy;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibbonachiNumbersTest {

    private FibbonachiNumbers fibbonaci;

    @DataProvider(name = "testData")
    public static Object[][] testData() {
        return new Object[][]{
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8},
                {7, 13},
                {8, 21},
                {9, 34},
                {10, 55}
        };
    }

    @BeforeMethod
    public void setUp() throws Exception {
        fibbonaci = new FibbonachiNumbers();
    }

    @Test
    public void countsFibbonaciNumbers(int index, int fibbonaci) throws Exception {
        assertThat(this.fibbonaci.giveNumber(index)).isEqualTo(fibbonaci);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void fibbonaciCannotBeCalculatedForZero() throws Exception {
        fibbonaci.giveNumber(0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void fibbonaciCannotBeCalculatedForNegativeNumber() throws Exception {
        fibbonaci.giveNumber(-1);
    }
}