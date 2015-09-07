package io;
import java.io.*;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class MyArchiver {

    private File source;
    private ZipInputStream zis;

    public static void main(String[] args) throws IOException  {

        FileOutputStream fos = new FileOutputStream("test.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        for(int i = 0; i < Integer.MAX_VALUE/2; i++){
            bos.write(i);
        }

        bos.close();
    }

}
