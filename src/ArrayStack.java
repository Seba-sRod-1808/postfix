package src;

import java.util.ArrayList;

/**
 * Implementación de Stack usando ArrayList.
 */
public class ArrayStack<T> implements Stack<T> {

    private ArrayList<T> items;

    public ArrayStack() {
        items = new ArrayList<>();
    }

    @Override
    public void push(T element) {
        items.add(element);
    }

    @Override
    public T pop() {
        if (items.isEmpty()) {
            throw new RuntimeException("El stack está vacío");
        }
        return items.remove(items.size() - 1);
    }

    @Override
    public T peek() {
        if (items.isEmpty()) {
            throw new RuntimeException("El stack está vacío");
        }
        return items.get(items.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
