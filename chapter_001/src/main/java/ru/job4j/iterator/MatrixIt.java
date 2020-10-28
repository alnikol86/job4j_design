package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
//        if (row > data.length - 1) {
//            return false;
//        }
//        if (column >= data[row].length && row == data.length - 1) {
//            return false;
//        }
//        if (data[row].length <= 0) {
//            row++;
//            while (data[row].length <= 0) {
//                row++;
//                if (row > data.length - 1) {
//                    return false;
//                }
//            }
//        }
//        if (column >= data[row].length) {
//            row++;
//            column = 0;
//            while (data[row].length == 0) {
//                row++;
//            }
//        }
//        return true;

        while (row < data.length && data[row].length == column) {
            row++;
            column = 0;
        }
        return  row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}