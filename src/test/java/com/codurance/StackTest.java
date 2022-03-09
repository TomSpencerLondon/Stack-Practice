package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StackTest {
    @Test
    void newlyCreatedStackShouldBeEmpty() {
        Stack stack = new Stack();
        assertThat(stack.isEmpty())
                .isTrue();
        assertThat(stack.getSize())
                .isEqualTo(0);
    }
}
