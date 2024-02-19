package homework2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsDemo {
    public static void main(String[] args) {
        try {
            readFile1();
        } catch (Throwable t) {

            System.out.println("WOW");
            System.out.println(t.toString());
            t.printStackTrace();
        }
        System.out.println("Test");
    }

    public static void readFile1() throws IOException {
        readFile2();
    }

    public static void readFile2() throws FileNotFoundException {
        readFile3();
    }

    public static void readFile3() throws FileNotFoundException {
        readFile4();
        try {
            readFile5();
        } catch (java.io.FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFile4() throws FileNotFoundException {
        readFile5();
    }

    public static void readFile5() throws FileNotFoundException {
        File f = new File("abc.txt");
        FileReader fileReader = new FileReader(f);
        f.setReadable(true);
    }
}

