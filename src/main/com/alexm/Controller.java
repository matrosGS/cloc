package com.alexm;

import java.io.*;
import java.util.List;

/**
 * @author Alexey M. on 15.08.2016.
 */
public class Controller implements IController {

    private BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    public List<String> readInput() throws IOException {
        System.out.println("Enter the path to file or folder to count LOC:");
        String path = scanner.readLine().trim();
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                return readFiles(path);
            } else if (file.isFile()) {
                return readFile(path);
            }
        } else {
            throw new RuntimeException("There is no such file or folder");
        }

        return null;
    }

    @Override
    public int count() throws IOException {
        List<String> allLines = readInput();
        Counter counter = new Counter();
        return counter.count(allLines);
    }

    private List<String> readFile(String filename) {
        Reader reader = new Reader();
        return reader.readFile(filename);
    }

    private List<String> readFiles(String folderName) {
        Reader reader = new Reader();
        return reader.readFiles(folderName);
    }
}
