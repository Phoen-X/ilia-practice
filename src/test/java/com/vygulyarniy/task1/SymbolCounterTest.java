package com.vygulyarniy.task1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SymbolCounterTest {
    @DataProvider(name = "testData")
    public static Object[][] testData() {
        return new Object[][] {
                {"Мы шли-шли-шли, пирожок нашли", new SymbolStatistics('и', 5)},
                {"Hello, world!", new SymbolStatistics('l', 3)},
                {"my salary is $123123123222.00", new SymbolStatistics('2', 6)},
                {"", null},
                {null, null}
        };
    }

    @Test(dataProvider = "testData")
    public void shouldFindMostPopularSymbolInText(String text, SymbolStatistics expectedStatistics) throws Exception {
        assertThat(new SymbolCounter().findMostPopularSymbol(text)).isEqualTo(expectedStatistics);
    }


}