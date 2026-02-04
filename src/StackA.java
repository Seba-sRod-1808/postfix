package src;

import java.util.ArrayList;

/**
 * Implementacion de la interfaz Stack utilizando ArrayList como estructura interna.
 * Operaciones de notacion O(1) para push, pop y peek.
 *
 * @author Sebastian Rodas
 * @author Cristopher Chavez
 * @version 1.0
 * @since 2/02/2026
 * @param <T> el tipo de elementos que almacena el Stack
 */
public class StackA<T> implements Stack<T> {

    private ArrayList<T> items;

    /**
     * Constructor que inicializa un Stack vacio.
     */
    public StackA() {
        items = new ArrayList<>();
    }

    /**
     * Agrega un elemento al tope del Stack.
     *
     * @param element el elemento a agregar
     */
    @Override
    public void push(T element) {
        items.add(element);
    }

    /**
     * Elimina y retorna el elemento del tope del Stack.
     *
     * @return el elemento removido del tope
     * @throws RuntimeException si el Stack esta vacio
     */
    @Override
    public T pop() {
        if (items.isEmpty()) {
            throw new RuntimeException("El stack está vacío");
        }
        return items.remove(items.size() - 1);
    }

    /**
     * Retorna el elemento del tope sin eliminarlo.
     *
     * @return el elemento en el tope del Stack
     * @throws RuntimeException si el Stack esta vacio
     */
    @Override
    public T peek() {
        if (items.isEmpty()) {
            throw new RuntimeException("El stack está vacío");
        }
        return items.get(items.size() - 1);
    }
}
