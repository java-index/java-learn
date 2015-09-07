package io;
import java.io.*;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class MyArchiver {

    private File source;
    private ZipInputStream zis;

    public MyArchiver(File source){
        this.source = source;
    }

    public void addFileToZip(){
        try(
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(source));
                ZipOutputStream zos = new ZipOutputStream(bos);
        ){


        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getFileFromZip(){

    }
}
