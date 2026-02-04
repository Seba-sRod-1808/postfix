package test;

/**
 * Clase que ejecuta todas las suites de pruebas del proyecto.
 * Invoca secuencialmente las pruebas de ArrayStack, PostfixCalc y ReadFile.
 *
 * @author Sebastian Rodas
 * @author Cristopher Chavez
 * @version 1.0
 * @since 03/02/2026
 */
public class AllTests {

    /**
     * Metodo principal que ejecuta todas las pruebas unitarias.
     *
     * @param args argumentos de linea de comandos (no utilizados)
     * @throws Exception si alguna prueba falla
     */
    public static void main(String[] args) throws Exception {
        System.out.println("ArrayStackTest");
        ArrayStackTest.main(args);

        System.out.println("\nPostfixCalcTest");
        PostfixCalcTest.main(args);

        System.out.println("\nReadFileTest");
        ReadFileTest.main(args);
    }
}
