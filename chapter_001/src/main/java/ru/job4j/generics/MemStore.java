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
        int index = getIndex(id);
        if (validIndexModel(index)) {
            mem.set(getIndex(id), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int index = getIndex(id);
        if (validIndexModel(index)) {
            mem.remove(getIndex(id));
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        T findModel = null;
        for (T model : mem) {
            if (model.getId().equals(id)) {
                findModel = model;
            }
        }
        return findModel;
    }

    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public boolean validIndexModel(int index) {
        if (index == -1) {
            return false;
        }
        return true;
    }
}
