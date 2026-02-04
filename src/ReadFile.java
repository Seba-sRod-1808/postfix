package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase utilitaria para la lectura de expresiones matematicas desde archivos de texto.
 * Proporciona metodos estaticos para cargar expresiones linea por linea,
 * ignorando lineas vacias o que contengan solo espacios en blanco.
 *
 * @author Sebastian Rodas
 * @author Cristopher Chavez
 * @version 1.0
 * @since 2/02/2026
 */
public class ReadFile {

    /**
     * Lee todas las lineas no vacias de un archivo de texto.
     * Las lineas son recortadas antes de ser agregadas a la lista.
     *
     * @param filePath la ruta del archivo a leer
     * @return lista de cadenas con las lineas no vacias del archivo
     * @throws FileNotFoundException si el archivo no existe o no se puede leer
     */
    public static List<String> readExpressions(String filePath) throws FileNotFoundException {
        List<String> expressions = new ArrayList<>();
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    expressions.add(line);
                }
            }
        }

        return expressions;
    }
}
