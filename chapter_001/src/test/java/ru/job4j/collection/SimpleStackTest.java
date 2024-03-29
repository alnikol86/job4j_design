package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class SimpleStackTest {
    @Test
    public void whenPushThenPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        assertThat(stack.poll(), is(1));
    }
    @Test
    public void whenPushPollThenPushPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.poll();
        stack.push(2);
        assertThat(stack.poll(), is(2));
    }
    @Test
    public void whenPushPushThenPollPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.poll();
        assertThat(stack.poll(), is(1));
    }
}
