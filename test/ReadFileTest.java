package test;

import src.ReadFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;

/**
 * Suite de pruebas unitarias para la clase ReadFile.
 * Verifica el correcto funcionamiento de la lectura de archivos,
 * incluyendo archivos validos, lineas vacias y archivos inexistentes.
 *
 * @author Sebastian Rodas
 * @author Cristopher Chavez
 * @version 1.0
 * @since 03/02/2026
 */
public class ReadFileTest {

    static final String TEST_FILE = "test_temp.txt";

    /**
     * Metodo principal que ejecuta todas las pruebas de ReadFile.
     *
     * @param args argumentos de linea de comandos (no utilizados)
     * @throws Exception si alguna prueba falla
     */
    public static void main(String[] args) throws Exception {
        testReadValidFile();
        testReadEmptyLines();
        testFileNotFound();
        cleanup();
    }

    /**
     * Prueba la lectura de un archivo valido con multiples lineas.
     *
     * @throws Exception si ocurre un error de I/O
     */
    static void testReadValidFile() throws Exception {
        createFile("3 4 +\n5 6 *\n2 3 ^");
        List<String> lines = ReadFile.readExpressions(TEST_FILE);
        assert lines.size() == 3 : "should have 3 lines";
        assert lines.get(0).equals("3 4 +") : "first line wrong";
        System.out.println("testReadValidFile pasó");
    }

    /**
     * Prueba que las lineas vacias y con espacios son ignoradas.
     *
     * @throws Exception si ocurre un error de I/O
     */
    static void testReadEmptyLines() throws Exception {
        createFile("3 4 +\n\n5 6 *\n   \n2 3 ^");
        List<String> lines = ReadFile.readExpressions(TEST_FILE);
        assert lines.size() == 3 : "should skip empty lines";
        System.out.println("testReadEmptyLines pasó");
    }

    /**
     * Prueba que se lanza FileNotFoundException para archivos inexistentes.
     */
    static void testFileNotFound() {
        try {
            ReadFile.readExpressions("no_existe.txt");
            assert false : "should throw";
        } catch (FileNotFoundException e) {
            System.out.println("testFileNotFound pasó");
        }
    }

    /**
     * Crea un archivo temporal con el contenido especificado.
     *
     * @param content el contenido a escribir en el archivo
     * @throws Exception si ocurre un error de escritura
     */
    static void createFile(String content) throws Exception {
        FileWriter writer = new FileWriter(TEST_FILE);
        writer.write(content);
        writer.close();
    }

    /**
     * Elimina el archivo temporal de pruebas.
     */
    static void cleanup() {
        new File(TEST_FILE).delete();
    }
}
