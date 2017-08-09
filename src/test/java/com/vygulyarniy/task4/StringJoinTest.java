package com.vygulyarniy.task4;

import org.testng.annotations.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

public class StringJoinTest {

    @Test
    public void shouldJoinElementsUsingGivenDelimiter() throws Exception {
        String joined = new StringJoin().join(asList("raz", "dva", "tri"), ',');

        assertThat(joined).isEqualTo("raz,dva,tri");
    }

    @Test
    public void emptyItemsShouldNotBeIncluded() throws Exception {
        String joined = new StringJoin().join(asList("raz", "", "tri"), '-');

        assertThat(joined).isEqualTo("raz-tri");
    }

    @Test
    public void joinOnEmptyListShouldGiveEmptyString() throws Exception {
        String joined = new StringJoin().join(emptyList(), ' ');
        assertThat(joined).isEqualTo("");
    }

    @Test
    public void joinOnNullListShouldGiveEmptyString() throws Exception {
        String joined = new StringJoin().join(null, ',');
        assertThat(joined).isEqualTo("");
    }
}