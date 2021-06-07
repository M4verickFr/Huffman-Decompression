package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class HuffmanFile {
    private File file;

    public HuffmanFile(String path) {
        this.file = new File(path);
    }

    public String getPath() {
        return file.getAbsolutePath();
    }

    public String getName() {
        return this.file.getName();
    }

    public Dictionary readFreq() {
        try {
            Dictionary frequency = new Hashtable();
            Scanner myReader = new Scanner(this.file);
            int nbRows = Integer.parseInt(myReader.nextLine());
            for (int i = 0; i < nbRows; i++) {
                String str = myReader.nextLine();
                String c = str.substring(0,1);
                String number = str.substring(2);
                frequency.put(c, number);
            }
            myReader.close();
            return frequency;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("main.HuffmanFile caught an FileNotFoundException");
        }
    }

    public String readBin() {
        try {
            String binString = "";
            Scanner myReader = new Scanner(this.file);
            while (myReader.hasNextLine()) {
                binString += myReader.nextLine();
            }
            return binString;

        } catch (FileNotFoundException e) {
            System.out.println("b");
            throw new RuntimeException("main.HuffmanFile caught an FileNotFoundException");
        }
    }

    public void writeResult(String result) {
        throw new UnsupportedOperationException();
    }


}