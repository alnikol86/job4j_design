package ru.job4j.iterator;

import org.junit.Test;
import org.hamcrest.core.Is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void whenRemoveByFilter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Predicate<Integer> filter = x -> x == 3;
        ListUtils.removeIf(input, filter);
        assertThat(Arrays.asList(1, 2, 4, 5), Is.is(input));
    }

    @Test
    public void whenReplaceByFilter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        Predicate<Integer> filter = x -> x == 3;
        ListUtils.replaceIf(input, filter,5);
        assertThat(Arrays.asList(1, 2, 5), Is.is(input));
    }

    @Test
    public void whenElementsPresentInAnotherListRemoveIt() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> elements = new ArrayList<>(Arrays.asList(2, 4));
        ListUtils.removeAll(input, elements);
        assertThat(Arrays.asList(1, 3), Is.is(input));
    }
}
