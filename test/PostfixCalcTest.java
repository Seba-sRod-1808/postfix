package test;

import src.Calc;
import src.PostfixCalc;

/**
 * Suite de pruebas unitarias para la clase PostfixCalc.
 * Verifica el correcto funcionamiento de la evaluacion de expresiones postfijas,
 * incluyendo operaciones basicas, expresiones complejas, decimales, negativos
 * y manejo de errores.
 *
 * @author Sebastian Rodas
 * @author Cristopher Chavez
 * @version 1.0
 * @since 03/02/2026
 */
public class PostfixCalcTest {

    static Calc calc = new PostfixCalc();

    /**
     * Metodo principal que ejecuta todas las pruebas de PostfixCalc.
     *
     * @param args argumentos de linea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        testBasicOperations();
        testComplexExpression();
        testDecimals();
        testNegativeNumbers();
        testDivisionByZero();
        testEmptyExpression();
        testInvalidOperator();
        testMalformedExpression();
    }

    /**
     * Prueba las operaciones aritmeticas basicas: suma, resta, multiplicacion, division y potencia.
     */
    static void testBasicOperations() {
        assert calc.operate("3 4 +") == 7 : "sum failed";
        assert calc.operate("10 3 -") == 7 : "subtraction failed";
        assert calc.operate("4 5 *") == 20 : "multiplication failed";
        assert calc.operate("20 4 /") == 5 : "division failed";
        assert calc.operate("2 3 ^") == 8 : "power failed";
        System.out.println("testBasicOperations pasó");
    }

    /**
     * Prueba una expresion postfija con multiples operadores.
     */
    static void testComplexExpression() {
        assert calc.operate("5 1 2 + 4 * + 3 -") == 14 : "complex failed";
        System.out.println("testComplexExpression pasó");
    }

    /**
     * Prueba el manejo de numeros decimales.
     */
    static void testDecimals() {
        assert calc.operate("3.5 2 +") == 5.5 : "decimals failed";
        System.out.println("testDecimals pasó");
    }

    /**
     * Prueba el manejo de numeros negativos.
     */
    static void testNegativeNumbers() {
        assert calc.operate("-5 3 +") == -2 : "negative failed";
        System.out.println("testNegativeNumbers pasó");
    }

    /**
     * Prueba que la division por cero lanza ArithmeticException.
     */
    static void testDivisionByZero() {
        try {
            calc.operate("10 0 /");
            assert false : "should throw";
        } catch (ArithmeticException e) {
            System.out.println("testDivisionByZero pasó");
        }
    }

    /**
     * Prueba que una expresion vacia lanza IllegalArgumentException.
     */
    static void testEmptyExpression() {
        try {
            calc.operate("");
            assert false : "should throw";
        } catch (IllegalArgumentException e) {
            System.out.println("testEmptyExpression pasó");
        }
    }

    /**
     * Prueba que un operador invalido lanza IllegalArgumentException.
     */
    static void testInvalidOperator() {
        try {
            calc.operate("3 4 %");
            assert false : "should throw";
        } catch (IllegalArgumentException e) {
            System.out.println("testInvalidOperator pasó");
        }
    }

    /**
     * Prueba que una expresion mal formada lanza IllegalArgumentException.
     */
    static void testMalformedExpression() {
        try {
            calc.operate("3 +");
            assert false : "should throw";
        } catch (IllegalArgumentException e) {
            System.out.println("testMalformedExpression pasó");
        }
    }
}
