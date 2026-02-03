package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Utilidad para leer expresiones desde archivos de texto.
 */
public class ReadFile {

    /** Lee líneas no vacías de un archivo. */
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
