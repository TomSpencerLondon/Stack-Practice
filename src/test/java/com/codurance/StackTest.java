package com.codurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


public class StackTest {
    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @Test
    void newlyCreatedStackShouldBeEmpty() {
        assertThat(stack.isEmpty())
                .isTrue();
    }

    @Test
    void afterOnePush_StackIsNotEmpty() {
        stack.push(0);
        assertFalse(stack.isEmpty());
    }

    @Test
    void poppingEmptyStack_throwsUnderflow() {
        assertThatThrownBy(stack::pop)
                .isInstanceOf(Underflow.class);
    }

    @Test
    void afterOnePushAndOnePop_isEmpty() {
        stack.push(0);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void afterTwoPushes_sizeIsTwo() {
        stack.push(0);
        stack.pop();
        assertTrue(stack.isEmpty());
    }


    @Test
    void afterPushingX_stackPopsX() {
        stack.push(23);
        assertEquals(23, stack.pop());
        stack.push(42);
        assertEquals(42, stack.pop());
    }

    @Test
    void afterPushingXAndY_stackPopsYAndX() {
        stack.push(23);
        stack.push(42);
        assertEquals(42, stack.pop());
        assertEquals(23, stack.pop());
    }
}
