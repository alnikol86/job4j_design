package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenIterator(int[] data) {
        this.data = data;
    }
    public boolean checkPoint() {
        if (point > data.length - 1) {
            return false;
        }
        return true;
    }
    @Override
    public boolean hasNext() {
        if (!checkPoint()) {
            return false;
        }
        while (data[point] % 2 != 0) {
            point++;
            if (!checkPoint()) {
                return false;
            }
//            if (point >= data.length - 1) {
//                return false;
//            }
        }
        return true;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
