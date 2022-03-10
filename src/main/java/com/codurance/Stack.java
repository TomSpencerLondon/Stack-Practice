package com.codurance;

import static java.lang.System.arraycopy;

public interface Stack {
    boolean isEmpty();
    void push(int element);
    int pop();
    int top();
    Integer find(int element);
}
