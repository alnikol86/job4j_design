package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable <T> {
    private T[] models;
    private int size;

    SimpleArray(int modelsSize) {
        this.models = (T[]) new Object[modelsSize];
    }

    public void add(T model) {
        models[size++] = model;
    }

    public void set(int index, T model) {
        if (Objects.checkIndex(index, models.length - 1) > -1) {
            models[index] = model;
        }
    }

    public void remove(int index) {
        if (Objects.checkIndex(index, models.length - 1) > -1) {
            System.arraycopy(models, index, models, index,
                    models.length - index - 1);
        }
    }

    public T get(int index) {
        T model = null;
        if (Objects.checkIndex(index, models.length - 1) > -1) {
            model = models[index];
        }
        return model;
    }

    @Override
    public Iterator iterator() {
        Iterator elem = null;
        for (T el : models) {
            el.toString();
        }
        return elem;
    }
}