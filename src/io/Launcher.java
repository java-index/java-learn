package io;

import java.io.File;

/**
 * Created by eco on 07.09.15.
 */
public class Launcher {

    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.process(args);
    }
}

