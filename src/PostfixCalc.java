package src;

public class PostfixCalc implements Calc {

    @Override
    public int operate(String input) {
        String[] tokens = input.split(" ");
        Stack<Integer> stack = new ArrayStack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                int result = 0;
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
                        result = val2 / val1;
                        break;
                    case "^":
                        result = (int) Math.pow(val2, val1);
                        break;
                    default:
                        throw new IllegalArgumentException("Operador no conocido: " + token);
                }
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private boolean isNumber(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        
        // Verificar si es un número (puede empezar con -)
        if (token.charAt(0) == '-' && token.length() > 1) {
            return token.substring(1).matches("\\d+");
        }
        
        return token.matches("\\d+");
    }
}