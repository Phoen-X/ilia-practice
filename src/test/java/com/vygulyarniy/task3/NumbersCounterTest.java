package com.vygulyarniy.task3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersCounterTest {

    @DataProvider(name = "testData")
    public static Object[][] testData() {
        return new Object[][]{
                {"мы выехали в 15:25 из дому, проехали 700 км и потратили 95.5 баксов. Это были прекрасные 2 дня", 5},
                {"Hello world", 0},
                {"mne 10 let", 1},
                {"гостей будет 10. 20 это много уже", 2},
                {"", 0},
                {null, 0}
        };
    }

    @Test(dataProvider = "testData")
    public void shouldCountNumbersInText(String text, int expectedNumbersCount) throws Exception {
        assertThat(new NumbersCounter().countNumbers(text)).isEqualTo(expectedNumbersCount);
    }
}