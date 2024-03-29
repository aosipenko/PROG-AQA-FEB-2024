package org.prog.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


//TODO: Catch parent exceptions (EXception / Throwable)
//TODO: Catch specific exception
//TODO: Convert FileNotFoundException into Throwable in readFile3
//TODO: Process Throwable in readFile1
public class ExceptionsDemo {

    public static void main(String[] args) {
        try {
            readFile1();
        } catch (Throwable t) {
            // It's generally not recommended to catch Throwable.
            // Catch specific exceptions instead to avoid catching errors and unexpected conditions.
            System.out.println("Something went wrong: " + t.getMessage());
            t.printStackTrace();
        }
        System.out.println("test");
    }

    public static void readFile1() {
        readFile2();
    }

    public static void readFile2() {
        readFile3();
    }

    public static void readFile3() {
        readFile4();
    }

    public static void readFile4() {
        try {
            readFile5();
        } catch (FileNotFoundException e) {
            // Handle the FileNotFoundException here, e.g., by logging a message or showing an error message.
            System.err.println("File 'abc.txt' not found.");
            // Rethrow the exception if you want it to be handled at a higher level.
            // throw new RuntimeException("File 'abc.txt' not found", e);
        }
    }

    public static void readFile5() throws FileNotFoundException {
        File f = new File("abc.txt");
        // You should always check if the file exists before opening a FileReader.
        if (!f.exists()) {
            throw new FileNotFoundException("File 'abc.txt' does not exist.");
        }
        FileReader fileReader = new FileReader(f);
        f.setReadable(true);
    }
}

