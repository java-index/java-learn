package io;

import com.google.common.base.Charsets;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by rabota on 02.09.15.
 */
public class MyPrintStream {

//    private static byte [] bytes = {1, -1, 3, 110, 56, 23, 0};
//    private static ByteArrayInputStream bs =  new ByteArrayInputStream(bytes);
//
//    public static void printStreamToConsole(ByteArrayInputStream bs){
//        int i = 0;
//        while ((i = bs.read()) != -1){
//            System.out.print((char)i);
//        }
//        System.out.println();
//    }

//    static FileOutputStream fos = null;
//    static FileInputStream fis = null;
//    static FileInputStream fis_1 = null;
//    static BufferedInputStream bis;
//    static BufferedOutputStream bos;




    public static void main(String[] args) throws FileNotFoundException {

//        File fileLog = new File("log.txt");
//
//        FileOutputStream fos = new FileOutputStream(fileLog, true);

        System.setOut(new PrintStream("log.txt"));
        System.out.println("123");

        changeEncoding(new File("charset.txt"), "UTF-8", "cp1251");

//        File file_out = new File("text_copy.txt");

//        long start = 0;
//        long end = 0;
//
//        try {
//            fos = new FileOutputStream(file_out, true);
//            fis = new FileInputStream(file_in);
//            fis_1 = new FileInputStream(file_in);
//            bis = new BufferedInputStream(fis_1, 4096);
//            bos = new BufferedOutputStream(fos, 4096);
//
//
//            int i;
//
//            System.out.println("Start no buffered: " + (start = System.currentTimeMillis()));
//
//            while((i = fin.read()) != -1){
//               fout.write(i);
//            }
//
//            System.out.println("End: " + (System.currentTimeMillis() - start));
//
//            System.out.println("Start buffered: " + (start = System.currentTimeMillis()));
//            i = 0;
//            while((i = bis.read()) != -1){
//               bos.write(i);
//            }
//            bis.close();
//            System.out.println("End: " + (System.currentTimeMillis() - start));
//
//            for (int j = 0; j < Integer.MAX_VALUE; j++){
//                fout.write(j);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        } finally {
//            try {
//                fis.close();
//                fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        ByteArrayInputStream bytestream = new ByteArrayInputStream(b);
//        printStreamToConsole(bytestream);
    }

    public static void changeEncoding(File file, String currentEncoding, String neededEncoding){

        File temp = new File("temp.txt");

        try (
                BufferedInputStream bufInputStream = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream bufOutStream = new BufferedOutputStream(new FileOutputStream(temp));

                InputStreamReader readerStream = new InputStreamReader(bufInputStream, currentEncoding);
                OutputStreamWriter writerStream = new OutputStreamWriter(bufOutStream, neededEncoding);

            )
        {
            int i = 0;
            while((i = readerStream.read()) != -1){
                writerStream.write((char)i);
            }

            file.delete();
            temp.renameTo(file);

        } catch (IOException e){
                e.printStackTrace();
            }
    }
}
