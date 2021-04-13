package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int countIn = 0;
    private int countOut = 0;
// должен возвращать первое значение и удалять его из коллекции
    public T poll() {
        if (countIn != 0) {
            countOut = countIn;
            for (int i = 0; i < countIn; i++) {
                out.push(in.poll());
            }
            countIn = 0;
        }
        T rsl = out.poll();
        countOut--;
        return rsl;
    }

// помещает значение в конец
    public void push(T value) {
        if (countOut != 0) {
            countIn = countOut;
            for (int i = 0; i < countOut; i++) {
                in.push(out.poll());
            }
            countOut = 0;
        }
        in.push(value);
        countIn++;
    }
}
