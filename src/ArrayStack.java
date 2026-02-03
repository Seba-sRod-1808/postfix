package src;
import java.util.ArrayList;

public class ArrayStack<T> implements Stack<T> {
    private ArrayList<T> elements;

    public ArrayStack() {
        elements = new ArrayList<>();
    }

    @Override
    public void push(T element) {
        elements.add(element);
    }

    @Override
    public T pop() {
        if(elements.isEmpty()) {
            throw new RuntimeException("El stack está vacío");
        }
        return elements.remove(elements.size() - 1);
    }

    @Override
    public T peek() {
        if (elements.isEmpty()) {
            throw new RuntimeException("El stack está vacío");
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}

