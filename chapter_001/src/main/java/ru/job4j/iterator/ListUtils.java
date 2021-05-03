package ru.job4j.iterator;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListUtils {
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while(i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while(i.hasNext()) {
            if (i.nextIndex() == index) {
                i.next();
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter == list.get(i.nextIndex())) {
                i.remove();
                break;
            }
            i.next();
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter == list.get(i.nextIndex())) {
                list.add(i.nextIndex(), value);
            }
            i.next();
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> iFirst = list.listIterator();
        ListIterator<T> iSecond = elements.listIterator();
        while (iFirst.hasNext() || iSecond.hasNext()) {
            if (list.get(iFirst.nextIndex()) == elements.get(iSecond.nextIndex())) {
                iFirst.remove();
            }
            iFirst.next();
            iSecond.next();
        }
    }
}
