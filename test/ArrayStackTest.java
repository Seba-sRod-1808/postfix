package test;

import src.ArrayStack;
import src.Stack;

public class ArrayStackTest {

    public static void main(String[] args) {
        testPush();
        testPop();
        testPeek();
        testPopEmptyStack();
        testPeekEmptyStack();
    }

    static void testPush() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(5);
        stack.push(10);
        assert stack.peek() == 10 : "testPush failed";
        System.out.println("testPush pasó");
    }

    static void testPop() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(5);
        stack.push(10);
        assert stack.pop() == 10 : "testPop failed";
        assert stack.peek() == 5 : "testPop failed";
        System.out.println("testPop pasó");
    }

    static void testPeek() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(5);
        assert stack.peek() == 5 : "testPeek failed";
        assert stack.peek() == 5 : "testPeek should not remove";
        System.out.println("testPeek pasó");
    }

    static void testPopEmptyStack() {
        Stack<Integer> stack = new ArrayStack<>();
        try {
            stack.pop();
            assert false : "should throw";
        } catch (RuntimeException e) {
            System.out.println("testPopEmptyStack pasó");
        }
    }

    static void testPeekEmptyStack() {
        Stack<Integer> stack = new ArrayStack<>();
        try {
            stack.peek();
            assert false : "should throw";
        } catch (RuntimeException e) {
            System.out.println("testPeekEmptyStack pasó");
        }
    }
}
