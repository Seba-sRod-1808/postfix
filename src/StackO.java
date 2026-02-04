package src;

/**
 * Implementacion de la interfaz Stack utilizando un array nativo como estructura interna.
 * El array crece dinamicamente cuando se llena, duplicando su capacidad.
 * Operaciones de notacion O(1) para push, pop y peek (amortizado para push).
 *
 * @author Sebastian Rodas
 * @author Cristopher Chavez
 * @version 1.0
 * @since 2/02/2026
 * @param <T> el tipo de elementos que almacena el Stack
 */
public class StackO<T> implements Stack<T> {

    private Object[] items;
    private int size;
    private static final int CAPACIDAD_INICIAL = 10;

    /**
     * Constructor que inicializa un Stack vacio con capacidad inicial de 10.
     */
    public StackO() {
        items = new Object[CAPACIDAD_INICIAL];
        size = 0;
    }

    /**
     * Agrega un elemento al tope del Stack.
     * Si el array esta lleno, duplica su capacidad.
     *
     * @param element el elemento a agregar
     */
    @Override
    public void push(T element) {
        if (size == items.length) {
            resize();
        }
        items[size] = element;
        size++;
    }

    /**
     * Elimina y retorna el elemento del tope del Stack.
     *
     * @return el elemento removido del tope
     * @throws RuntimeException si el Stack esta vacio
     */
    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new RuntimeException("El stack está vacío");
        }
        size--;
        T element = (T) items[size];
        items[size] = null;
        return element;
    }

    /**
     * Retorna el elemento del tope sin eliminarlo.
     *
     * @return el elemento en el tope del Stack
     * @throws RuntimeException si el Stack esta vacio
     */
    @Override
    public T peek() {
        if (size == 0) {
            throw new RuntimeException("El stack está vacío");
        }
        return (T) items[size - 1];
    }

    /**
     * Duplica la capacidad del array interno.
     */
    private void resize() {
        Object[] nuevoArray = new Object[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            nuevoArray[i] = items[i];
        }
        items = nuevoArray;
    }
}
