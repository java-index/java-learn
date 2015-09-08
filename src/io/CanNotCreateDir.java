package io;

import java.io.FileNotFoundException;

/**
 * Created by eco on 08.09.15.
 */
public class CanNotCreateDir extends FileNotFoundException {
    public CanNotCreateDir(String message){
        super(message);
    }

    public CanNotCreateDir(){}
}
