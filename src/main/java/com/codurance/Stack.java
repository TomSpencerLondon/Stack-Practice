package com.codurance;
import static java.lang.System.arraycopy;

public class Stack {

    private int size = 0;
    private int[] elements = new int[0];

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void push(int element) {
        if (size >= elements.length) {
            increaseSize();
        }

        elements[size++] = element;
    }

    private void increaseSize() {
        int[] newElements = new int[size + 1];
        arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public int pop() {
        if (isEmpty()) {
            throw new Underflow();
        }

        return elements[--size];
    }
}