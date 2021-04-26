package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public boolean addHead(Node<T> node) {
        boolean check = false;
        if (head == null) {
            head = node;
            check = true;
        }
        return check;
    }

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (addHead(node)) {
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value, null);
        if (addHead(node)) {
            return;
        }
        node.next = head;
        head = node;
    }

    public T deleteFirst() {
        Node<T> temp = null;

        if (head == null) {
            throw new NoSuchElementException();
        }
            temp = head;
            head = head.next;
            return temp.value;
    }

    public boolean revert() {
        boolean result = true;

        if (head == null || head.next == null) {
            result = false;
        }

        Node<T> currentEl = head;
        Node<T> previousEl = null;
        Node<T> nextEl = null;

        while (currentEl != null) {
            nextEl = currentEl.next;
            currentEl.next = previousEl;
            previousEl = currentEl;
            currentEl = nextEl;
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
