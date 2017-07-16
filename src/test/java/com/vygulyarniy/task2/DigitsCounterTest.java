package com.vygulyarniy.task2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DigitsCounterTest {
    @DataProvider(name = "exampleData")
    public static Object[][] exampleData() {
        return new Object[][]{
                {"мы будем ехать 100км 18-м автобусом в 12:35", 9},
                {"сегодня родилось 9 девочек и 15 мальчиков", 3},
                {"", 0},
                {"privet pacani", 0},
                {"privet 15 pacanov", 2},
                {null, 0}
        };
    }

    @Test(dataProvider = "exampleData")
    public void countsDigitsInText(String text, int expectedResult) throws Exception {
        assertThat(new DigitsCounter().digitsCount(text)).isEqualTo(expectedResult);
    }
}