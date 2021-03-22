package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        mem.set(getIndex(id), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        mem.remove(getIndex(id));
        return true;
    }

    @Override
    public T findById(String id) {
        T findModel = null;
        for (T model : mem) {
            if (model.getId() == id) {
                findModel = model;
            }
        }
        return findModel;
    }

    public int getIndex(String id) {
        int index = Integer.parseInt(null);
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId() == id) {
                index = i;
            }
        }
        return index;
    }
}
