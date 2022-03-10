package com.codurance;

import static java.lang.System.arraycopy;

public class BoundedStack implements Stack {

    private int capacity;
    private int size = 0;
    private int[] elements;

    public static Stack Make(int capacity) {
        if (capacity < 0) {
            throw new IllegalCapacity();
        }

        if (capacity == 0) {
            return new ZeroCapacityStack();
        }
        return new BoundedStack(capacity);
    }

    private BoundedStack(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
    }

    private void increaseSize() {
        int[] newElements = new int[size + 1];
        arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(int element) {
        if (size == capacity) {
            throw new Overflow();
        }

        if (size >= elements.length) {
            increaseSize();
        }

        elements[size++] = element;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new Underflow();
        }

        return elements[--size];
    }

    @Override
    public int top() {
        if (isEmpty()) {
            throw new Empty();
        }
        return elements[size-1];
    }

    @Override
    public Integer find(int element) {
        for (int i = size - 1; i>= 0; i--) {
            if (elements[i] == element) {
                return (size - 1) - i;
            }
        }

        return null;
    }
}
