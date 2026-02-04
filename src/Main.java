package src;

import java.util.List;

/**
 * Clase principal que ejecuta la calculadora de expresiones postfijas.
 * Lee expresiones desde un archivo de texto y muestra los resultados
 * de cada evaluacion en la consola.
 *
 * @author Sebastian Rodas
 * @author Cristopher Chavez
 * @version 1.0
 * @since 2/02/2026
 */
public class Main {

    /**
     * Punto de entrada de la aplicacion.
     * Lee expresiones del archivo especificado
     * y evalua cada una mostrando el resultado.
     *
     * @param args argumentos de linea de comandos, args[0] es la ruta del archivo opcional
     */
    public static void main(String[] args) {
        String filePath = "datos.txt";
        Calc calculator = new Calculator();

        try {
            List<String> expressions = ReadFile.readExpressions(filePath);

            for (String expression : expressions) {
                try {
                    double result = calculator.operate(expression);
                    System.out.println(expression + " = " + result);
                } catch (Exception e) {
                    System.out.println(expression + "Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
