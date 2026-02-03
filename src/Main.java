package src;

import java.util.List;

/**
 * Programa principal para probar la calculadora postfija.
 */
public class Main {

    public static void main(String[] args) {
        String filePath = args.length > 0 ? args[0] : "datos.txt";
        Calc calculator = new PostfixCalc();

        try {
            List<String> expressions = ReadFile.readExpressions(filePath);

            for (String expression : expressions) {
                try {
                    double result = calculator.operate(expression);
                    System.out.println(expression + " = " + result);
                } catch (Exception e) {
                    System.out.println(expression + " -> Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
