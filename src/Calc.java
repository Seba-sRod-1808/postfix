package src;

/**
 * Interfaz para calculadora de postfix.
 */
public interface Calc {
    /**
     * Evalúa una expresión en postfix.
     */
    public double operate(String input);
}
