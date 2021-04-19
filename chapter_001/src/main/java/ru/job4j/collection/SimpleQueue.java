package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int countIn = 0;
    private int countOut = 0;

    public T poll() {
        if (countOut == 0) {
            for (int i = 0; i < countIn; i++) {
                out.push(in.poll());
            }
            countOut = countIn;
            countIn = 0;
        }
        countOut--;
        return out.poll();
    }

    public void push(T value) {
        in.push(value);
        countIn++;
    }
}
