package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArray;

import java.util.HashSet;
import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    SimpleArray<T> simpleArray = new SimpleArray<>();

    @Override
    public boolean add(T value) {
        boolean result = false;
        if (!simpleArray.iterator().hasNext()) {
            simpleArray.add(value);
            result = true;
            return result;
        }
        for (T el : simpleArray) {
            if (el.equals(value)) {
                result = false;
                return result;
            }
        }
        result = true;
        simpleArray.add(value);

        return result;
    }

    @Override
    public boolean contains(T value) {
        boolean result = false;
        for (T el : simpleArray) {
            if (el.equals(value))
                result = true;
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}
