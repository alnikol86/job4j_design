package ru.job4j.it;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class MatrixItTest {
    @Test
    public void when4El() {
        int[][] in = {
                {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next(), is(1));
    }
}
