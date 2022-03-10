package com.codurance;

public class ZeroCapacityStack implements Stack {
    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public void push(int element) {
        throw new Overflow();
    }

    @Override
    public int pop() {
        throw new Underflow();
    }

    @Override
    public int top() {
        throw new Empty();
    }

    @Override
    public Integer find(int element) {
        return null;
    }
}
