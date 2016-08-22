package com.alexm;

import java.io.IOException;

/**
 * @author Alexey M. on 15.08.2016.
 */
public class Program {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        System.out.println(controller.count() + " LOC");
    }
}
