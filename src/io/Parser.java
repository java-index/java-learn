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
        File file = new File(args[1]);

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
        try (
                FileInputStream fis = new FileInputStream(file);
                ZipInputStream zis = new ZipInputStream(fis);
        ) {
            String dirName = createDir(file);
            processUnzip(file, dirName, zis);
        } catch (CanNotCreateDir eDir) {
            printMessage("Can not create directory for unzipped files");
        } catch (FileNotFoundException fe) {
            printMessage(file.getName() + " not found or corrupted");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void processUnzip(File file, String dirName, ZipInputStream zis) throws IOException {
        ZipEntry ze = null;
        byte[] buffer = new byte[4096];
        int count = 0;
        while ((ze = zis.getNextEntry()) != null) {
            try (FileOutputStream fos = new FileOutputStream(dirName + File.separator + ze.getName())) {
                int c = 0;
                while ((c = zis.read(buffer)) != -1) {
                    fos.write(buffer, 0, c);
                }
                printMessage(ze.getName() + " unzipped");
            } catch (IOException e) {
                throw new FileNotFoundException();
            } finally {
                zis.closeEntry();
            }
        }
    }

    private String createDir(File file) throws IOException {
        String dirName = file.getName().substring(0, file.getName().indexOf('.'));
        File dir = new File(dirName);
        if (!dir.exists() && !dir.mkdir()) {
            throw new CanNotCreateDir();
        } else {
            return dirName;
        }
    }

    private void zip(File file) {
        System.out.println("zipping - " + file.getName());
        if (file.isDirectory()) {
            addDirToArchive(file);
        } else {
            System.out.println("add files");
            addFileToArchive(file);
        }
    }

    private void addDirToArchive(File file){
        String [] listFiles = file.list();
        for(String s : listFiles){
            System.out.println(s);
            System.out.println(file.getAbsolutePath());
        }
    }

    private void  addFileToArchive(File file){
    }

    private void printHelpMessage() {
        System.out.println("Usage: zip.jar [zip/unzip] [dir name/file]");
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
