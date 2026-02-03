package src;

/**
 * Calculadora que evalúa expresiones en notación postfija.
 */
public class PostfixCalc implements Calc {

    @Override
    public double operate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("La expresión no puede estar vacía");
        }

        String[] tokens = splitBySpaces(input.trim());
        Stack<Double> stack = new ArrayStack<>();

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

    /** Separa el string por espacios manualmente. */
    private String[] splitBySpaces(String input) {
        int count = 1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;
        int start = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                result[index] = input.substring(start, i);
                index++;
                start = i + 1;
            }
        }
        result[index] = input.substring(start);

        return result;
    }

    /** Verifica si el token es un número (entero o decimal, positivo o negativo). */
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
