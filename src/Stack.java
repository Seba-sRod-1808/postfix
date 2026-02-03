package src;

/**
 * Interfaz genérica para una estructura Stack
 */
public interface Stack<T> {
    /** Agrega un elemento al tope. */
    public void push(T item);

    /** Elimina y retorna el elemento del tope. */
    public T pop();

    /** Retorna el elemento del tope sin eliminarlo. */
    public T peek();

    /** Verifica si el stack está vacío. */
    public boolean isEmpty();
}
