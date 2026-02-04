package src;

/**
 * Interfaz generica para uns stack.
 * Define las operaciones basicas que toda implementacion de Stack debe tener:
 * push, pop y peek.
 *
 * @author Sebastian Rodas
 * @author Cristopher Chavez
 * @version 1.0
 * @since 2/02/2026
 * @param <T> el tipo de elementos que almacena el Stack
 */
public interface Stack<T> {

    /**
     * Agrega un elemento al tope del Stack.
     *
     * @param item el elemento a agregar
     */
    public void push(T item);

    /**
     * Elimina y retorna el elemento del tope del Stack.
     *
     * @return el elemento removido del tope
     * @throws RuntimeException si el Stack esta vacio
     */
    public T pop();

    /**
     * Retorna el elemento del tope sin eliminarlo.
     *
     * @return el elemento en el tope del Stack
     * @throws RuntimeException si el Stack esta vacio
     */
    public T peek();
}
