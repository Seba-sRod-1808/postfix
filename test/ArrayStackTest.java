package test;

import src.Stack;
import src.StackO;

/**
 * Suite de pruebas unitarias para la clase ArrayStack.
 * Verifica el correcto funcionamiento de las operaciones push, pop y peek,
 * incluyendo casos de excepcion cuando el Stack esta vacio.
 *
 * @author Sebastian Rodas
 * @author Cristopher Chavez
 * @version 1.0
 * @since 03/02/2026
 */
public class ArrayStackTest {

    /**
     * Metodo principal que ejecuta todas las pruebas de ArrayStack.
     *
     * @param args argumentos de linea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        testPush();
        testPop();
        testPeek();
        testPopEmptyStack();
        testPeekEmptyStack();
    }

    /**
     * Prueba que push agrega elementos correctamente al tope del Stack.
     */
    static void testPush() {
        Stack<Integer> stack = new StackO<>();
        stack.push(5);
        stack.push(10);
        assert stack.peek() == 10 : "testPush failed";
        System.out.println("testPush pasó");
    }

    /**
     * Prueba que pop remueve y retorna el elemento del tope correctamente.
     */
    static void testPop() {
        Stack<Integer> stack = new StackO<>();
        stack.push(5);
        stack.push(10);
        assert stack.pop() == 10 : "testPop failed";
        assert stack.peek() == 5 : "testPop failed";
        System.out.println("testPop pasó");
    }

    /**
     * Prueba que peek retorna el elemento del tope sin removerlo.
     */
    static void testPeek() {
        Stack<Integer> stack = new StackO<>();
        stack.push(5);
        assert stack.peek() == 5 : "testPeek failed";
        assert stack.peek() == 5 : "testPeek should not remove";
        System.out.println("testPeek pasó");
    }

    /**
     * Prueba que pop lanza excepcion cuando el Stack esta vacio.
     */
    static void testPopEmptyStack() {
        Stack<Integer> stack = new StackO<>();
        try {
            stack.pop();
            assert false : "should throw";
        } catch (RuntimeException e) {
            System.out.println("testPopEmptyStack pasó");
        }
    }

    /**
     * Prueba que peek lanza excepcion cuando el Stack esta vacio.
     */
    static void testPeekEmptyStack() {
        Stack<Integer> stack = new StackO<>();
        try {
            stack.peek();
            assert false : "should throw";
        } catch (RuntimeException e) {
            System.out.println("testPeekEmptyStack pasó");
        }
    }
}
