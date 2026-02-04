package src;

/**
 * Interfaz que define el contrato para calculadoras de expresiones matematicas.
 * Las implementaciones deben ser capaces de evaluar expresiones y retornar
 * el resultado como un valor de tipo double.
 *
 * @author Sebastian Rodas
 * @author Cristopher Chavez
 * @version 1.0
 * @since 2/02/2026
 */
public interface Calc {

    /**
     * Evalua una expresion matematica y retorna el resultado.
     *
     * @param input la expresion a evaluar como cadena de texto
     * @return el resultado de la evaluacion
     * @throws IllegalArgumentException si la expresion es invalida o mal formada
     * @throws ArithmeticException si ocurre un error aritmetico como division por cero
     */
    public double operate(String input);
}
