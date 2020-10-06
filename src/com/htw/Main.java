package com.htw;

import java.io.*;

/**
 * by Edwin W on Okt 2020
 * @author Thomas Schwotzer: Lecture Streams at HTW
 */
public class Main {

    public static void main(String[] args) {

        OutputStream os = null;
        String filename = "";

        try {
            filename = "testFile.txt";
            os = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file output - fatal");
            System.exit(0); // brutal exception handling
        }

        String someText = "Hallo";
        byte[] textAsByte = someText.getBytes(); //deliver byte code of the String
        try {
            os.write(textAsByte);
        } catch (IOException ex) {
            System.err.println("couldn’t write data output (fatal)");
            System.exit(0);
        }

        InputStream is = null;
        try {
            is = new FileInputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file input - fatal");
            System.exit(0);
        }

        byte[] readBuffer = new byte[4];
        try {
            is.read(readBuffer);
        } catch (IOException ex) {
            System.err.println("couldn’t read data input (fatal)");
            System.exit(0);
        }

        String readString = new String(readBuffer);
        System.out.println("read something: " + readString);

    }
}
