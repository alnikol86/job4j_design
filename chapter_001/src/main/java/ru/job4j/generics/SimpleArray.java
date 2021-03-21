package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] models;
    private int size;

    public SimpleArray(int modelsSize) {
        this.models = (T[]) new Object[modelsSize];
    }

    public void add(T model) {
        models[size++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        models[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(models, index, models, index, size - index);
        size--;
    }

    public T get(int index) {
        T model = null;
        Objects.checkIndex(index, size);
        model = models[index];
        return model;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<T>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return models[point++];
            }
        };
    }
}