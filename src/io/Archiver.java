package io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by eco on 07.09.15.
 */
public class Archiver {

    public Archiver() {
    }

    public void process(String[] args) {

        if (args.length < 2 || "help".equals(args[0])) {
            printHelpMessage();
            System.exit(0);
        }
        String typeOperation = args[0];
        String fileParth = args[1];

        File file = new File(fileParth);

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

            File unZipDir = createDir(file);
            processUnzip(unZipDir, zis);

        } catch (CanNotCreateDir e) {
            printMessage("Can not create directory for unzipped files");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            printMessage(file + " not found or corrupted");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processUnzip(File dir, ZipInputStream zis) throws IOException {
        ZipEntry ze = null;
        byte[] buffer = new byte[4096];
        int count = 0;
        while ((ze = zis.getNextEntry()) != null) {
            try (FileOutputStream fos = new FileOutputStream(dir + File.separator + ze.getName())) {
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

    private void zip(File file) {
        if (file.isDirectory()) {
            addDirToArchive(file);
        } else {
            addFileToArchive(file);
        }
    }

    private void addDirToArchive(File file){
        String newZipFile = file.getPath() + File.separator + file.getName() + ".zip";
        String [] listFiles = file.list();
        int c = 0;
        byte buffer[] = new byte[1024];

        try(
            FileOutputStream fos = new FileOutputStream(newZipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
        ){
            for(String s : listFiles) {
                try(FileInputStream fis = new FileInputStream(file.getPath() + File.separator + s)){
                    System.out.println(s);
                    zos.putNextEntry(new ZipEntry(s));
                    while ((c = fis.read(buffer)) != -1) {
                        zos.write(buffer, 0, c);
                    }
                }
            }

            } catch (IOException e){
                e.printStackTrace();
        }
    }

    private void  addFileToArchive(File file){
        String newZipFile =  file.getParent() + File.separator + getNameWithOutExtension(file) + ".zip";
        System.out.println(newZipFile);

        int c = 0;
        byte buffer[] = new byte[1024];

        try(
                FileOutputStream fos = new FileOutputStream(newZipFile);
                ZipOutputStream zos = new ZipOutputStream(fos);
        ){
                try(FileInputStream fis = new FileInputStream(file)){
                    zos.putNextEntry(new ZipEntry(file.getName()));
                    while ((c = fis.read(buffer)) != -1) {
                        zos.write(buffer, 0, c);
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private File createDir(File file) throws IOException {
        String dirName = getNameWithOutExtension(file);
        File dir = new File(file.getParent() + File.separator + dirName);
        if (!dir.exists() && !dir.mkdir()) {
            throw new CanNotCreateDir();
        } else {
            return dir;
        }
    }

    private void printHelpMessage() {
        System.out.println("Usage: zip.jar [zip/unzip] [dir name/file]");
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private String getNameWithOutExtension(File file){
        return file.getName().substring(0, file.getName().lastIndexOf('.'));
    }

}
