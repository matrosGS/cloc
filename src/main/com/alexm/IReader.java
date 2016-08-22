package com.alexm;

import java.util.List;

/**
 * @author Alexey M. on 15.08.2016.
 */
public interface IReader {

    List<String> readFile(String filename);

    List<String> readFiles(String folderName);
}
