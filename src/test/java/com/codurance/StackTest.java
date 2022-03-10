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
        stack = BoundedStack.Make(2);
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

    @Test
    void whenPushedPastLimit_StackOverflows() {
        stack.push(1);
        stack.push(1);
        assertThatThrownBy(() -> stack.push(1))
                .isInstanceOf(Overflow.class);
    }

    @Test
    void stackWithNegativeSizeShouldThrowIllegalCapacity() {
        assertThatThrownBy(() -> BoundedStack.Make(-1))
                .isInstanceOf(IllegalCapacity.class);
    }

    @Test
    void whenCreatingStackWithZeroCapacity_AnyPushShouldOverflow() {
        Stack stack = BoundedStack.Make(0);
        assertThatThrownBy(() -> stack.push(1))
                .isInstanceOf(Overflow.class);
    }

    @Test
    void whenOneIsPushed_OneIsOnTop() {
        stack.push(1);

        assertThat(stack.top())
                .isEqualTo(1);
    }


    @Test
    void whenStackIsEmpty_TopThrowsEmpty() {
        Stack stack = BoundedStack.Make(2);
        assertThatThrownBy(() -> stack.top())
                .isInstanceOf(Empty.class);
    }

    @Test
    void whenZeroCapacity_TopThrowsEmpty() {
        Stack stack = BoundedStack.Make(0);
        assertThatThrownBy(() -> stack.top())
                .isInstanceOf(Empty.class);
    }

    @Test
    void givenStackWithOneTwoPushed_FindOne() {
        stack.push(1);
        stack.push(2);
        assertThat(stack.find(1))
                .isEqualTo(1);
        assertThat(stack.find(2))
                .isZero();
    }

    @Test
    void givenStackWithNo2_find2ShouldReturnNull() {
        assertNull(stack.find(2));
    }
}
