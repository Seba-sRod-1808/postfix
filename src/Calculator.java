package src;

/**
 * Calculadora que evalua expresiones matematicas en notacion postfix.
 * Soporta operaciones de suma, resta, multiplicacion, division y potencia.
 * Utiliza un Stack para procesar los operandos y operadores.
 *
 * @author Sebastian Rodas
 * @author Cristopher Chavez
 * @version 1.0
 * @since 2/02/2026
 */
public class Calculator implements Calc {

    /**
     * Evalua una expresion en notacion postfija.
     * Los tokens deben estar separados por espacios.
     * Operadores soportados: +, -, *, /, ^
     *
     * @param input la expresion postfix a evaluar
     * @return el resultado de la evaluacion
     * @throws IllegalArgumentException si la expresion esta vacia, mal formada o tiene operador desconocido
     * @throws ArithmeticException si se intenta dividir por cero
     */
    @Override
    public double operate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("La expresión no puede estar vacía");
        }

        String[] tokens = input.trim().split(" ");
        Stack<Double> stack = new StackA<>();

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double val1;
                double val2;
                try {
                    val1 = stack.pop();
                    val2 = stack.pop();
                } catch (RuntimeException e) {
                    throw new IllegalArgumentException("Expresión mal formada");
                }

                double result = 0;
                switch (token) {
                    case "+":
                        result = val2 + val1;
                        break;
                    case "-":
                        result = val2 - val1;
                        break;
                    case "*":
                        result = val2 * val1;
                        break;
                    case "/":
                        if (val1 == 0) {
                            throw new ArithmeticException("División por cero");
                        }
                        result = val2 / val1;
                        break;
                    case "^":
                        result = Math.pow(val2, val1);
                        break;
                    default:
                        throw new IllegalArgumentException("Operador no conocido: " + token);
                }
                stack.push(result);
            }
        }

        try {
            return stack.pop();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Expresión inválida");
        }
    }

    /**
     * Verifica si un token representa un numero valido.
     * Acepta numeros enteros, decimales, positivos y negativos.
     *
     * @param token el token a verificar
     * @return true si el token es un numero valido, false en caso contrario
     */
    private boolean isNumber(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }

        int start = 0;
        boolean hasDecimal = false;

        if (token.charAt(0) == '-') {
            if (token.length() == 1) {
                return false;
            }
            start = 1;
        }

        for (int i = start; i < token.length(); i++) {
            char c = token.charAt(i);
            if (c == '.') {
                if (hasDecimal) {
                    return false;
                }
                hasDecimal = true;
            } else if (c < '0' || c > '9') {
                return false;
            }
        }

        return true;
    }
}
