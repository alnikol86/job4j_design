package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable {
    private T[] models;

    SimpleArray(int modelsSize) {
        this.models = new T[modelsSize];
    }

    public void add(T model) {
        for (int i = 0; i < models.length - 1; i++) {
            if (models[i] == null) {
                models[i] = model;
            }
        }
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