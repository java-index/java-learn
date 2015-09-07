package io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by eco on 07.09.15.
 */
public class Parser {

    public Parser() {
    }

    public void process(String[] args) {

        if (args.length < 2 || "help".equals(args[0])) {
            printHelpMessage();
            System.exit(0);
        }

        String typeOperation = args[0];
        String fileName = args[1];
        File file = new File(fileName);

        switch (typeOperation) {
            case "zip":
                zip(file);
                break;
            case "unzip":
                unzip(file);
                break;
            default:
                printHelpMessage();
                System.exit(0);
        }
    }

    private void unzip(File file) {
        System.out.println("unzipping -" + file.getName());
        //String dir = file.getName().s
        ZipEntry ze = null;

        try (
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bif = new BufferedInputStream(fis);
                ZipInputStream zis = new ZipInputStream(bif);
        ){
            if (!file.exists() || !file.getName().endsWith(".zip") || file.isDirectory() || !file.canRead()) {
                throw new FileNotFoundException();
            }

            byte [] buffer = new byte[4096];

            long start = System.currentTimeMillis();
            System.out.println(start);

            while((ze = zis.getNextEntry()) != null){
                System.out.println(ze.getName());
                FileOutputStream fos = new FileOutputStream(ze.getName());
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                int c = 0;
                while ((c = zis.read(buffer))!= -1) {
                    bos.write(buffer, 0, c);
                }
                zis.closeEntry();
                bos.close();
            }

            System.out.println(System.currentTimeMillis() - start);

        } catch (FileNotFoundException fe){
            printErrorMessage(file.getName());
        } catch (IOException ioe) {
            printErrorMessage("Error");
        } finally {

        }
    }

    private void zip(File file) {
        System.out.println("zipping - " + file.getName());
    }

    private void printHelpMessage() {
        System.out.println("Usage: zip.jar [zip/unzip] [file/dir name]");
    }

    private void printErrorMessage(String namefile) {
        System.out.println(namefile + " is not found or corrupted");
    }

}
