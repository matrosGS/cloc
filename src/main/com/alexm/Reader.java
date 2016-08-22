package com.alexm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Alexey M. on 15.08.2016.
 */
public class Reader implements IReader {

    @Override
    public List<String> readFile(String filename) {
        ArrayList<String> allLines = new ArrayList<>();
        Path path = Paths.get(filename);
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(allLines::add);
        } catch (IOException ex) {
            throw new RuntimeException("Reading file problem");
        }

        return allLines;
    }

    @Override
    public List<String> readFiles(String folderName) {
        ArrayList<String> allLines = new ArrayList<>();

        try {
            Files.walk(Paths.get(folderName)).forEach(
                filePath -> {
                    if (Files.isRegularFile(filePath)) {
                        allLines.addAll(readFile(filePath.toString()));
                    }
                });
        } catch (IOException e) {
            throw new RuntimeException("Error while reading files");
        }

        return allLines;
    }

}
