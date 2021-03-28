package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private T[] containers;
    private int capasity = 1;
    private int size;
    private int modCount;

    public SimpleArray() {
        this.containers = (T[]) new Object[capasity];
    }

    public SimpleArray(int manualCapasity) {
        this.containers = (T[]) new Object[manualCapasity];
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return containers[index];
    }

    public void add(T model) {
        modCount++;
        grow();
        containers[size++] = model;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!(hasNext())) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return containers[point++];
            }
        };
    }
    private void grow() {
        if (containers.length <= size) {
            capasity = capasity * 2;
            containers = Arrays.copyOf(containers, capasity);
        }
    }
}