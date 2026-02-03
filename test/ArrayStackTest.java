package test;

import src.ArrayStack;
import src.Stack;

public class ArrayStackTest {

    public static void main(String[] args) {
        testPush();
        testPop();
        testPeek();
        testIsEmpty();
        testPopEmptyStack();
        testPeekEmptyStack();
    }

    static void testPush() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(5);
        stack.push(10);
        assert stack.peek() == 10 : "testPush failed";
        System.out.println("[PASS] testPush");
    }

    static void testPop() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(5);
        stack.push(10);
        assert stack.pop() == 10 : "testPop failed";
        assert stack.peek() == 5 : "testPop failed";
        System.out.println("[PASS] testPop");
    }

    static void testPeek() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(5);
        assert stack.peek() == 5 : "testPeek failed";
        assert stack.peek() == 5 : "testPeek should not remove";
        System.out.println("[PASS] testPeek");
    }

    static void testIsEmpty() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        assert stack.isEmpty() : "should be empty";
        stack.push(5);
        assert !stack.isEmpty() : "should not be empty";
        stack.pop();
        assert stack.isEmpty() : "should be empty after pop";
        System.out.println("[PASS] testIsEmpty");
    }

    static void testPopEmptyStack() {
        Stack<Integer> stack = new ArrayStack<>();
        try {
            stack.pop();
            assert false : "should throw";
        } catch (RuntimeException e) {
            System.out.println("[PASS] testPopEmptyStack");
        }
    }

    static void testPeekEmptyStack() {
        Stack<Integer> stack = new ArrayStack<>();
        try {
            stack.peek();
            assert false : "should throw";
        } catch (RuntimeException e) {
            System.out.println("[PASS] testPeekEmptyStack");
        }
    }
}
