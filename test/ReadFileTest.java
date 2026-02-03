package test;

import src.ReadFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;

public class ReadFileTest {

    static final String TEST_FILE = "test_temp.txt";

    public static void main(String[] args) throws Exception {
        testReadValidFile();
        testReadEmptyLines();
        testFileNotFound();
        cleanup();
    }

    static void testReadValidFile() throws Exception {
        createFile("3 4 +\n5 6 *\n2 3 ^");
        List<String> lines = ReadFile.readExpressions(TEST_FILE);
        assert lines.size() == 3 : "should have 3 lines";
        assert lines.get(0).equals("3 4 +") : "first line wrong";
        System.out.println("testReadValidFile pasó");
    }

    static void testReadEmptyLines() throws Exception {
        createFile("3 4 +\n\n5 6 *\n   \n2 3 ^");
        List<String> lines = ReadFile.readExpressions(TEST_FILE);
        assert lines.size() == 3 : "should skip empty lines";
        System.out.println("testReadEmptyLines pasó");
    }

    static void testFileNotFound() {
        try {
            ReadFile.readExpressions("no_existe.txt");
            assert false : "should throw";
        } catch (FileNotFoundException e) {
            System.out.println("testFileNotFound pasó");
        }
    }

    static void createFile(String content) throws Exception {
        FileWriter writer = new FileWriter(TEST_FILE);
        writer.write(content);
        writer.close();
    }

    static void cleanup() {
        new File(TEST_FILE).delete();
    }
}
