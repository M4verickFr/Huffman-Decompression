package main.java;

import java.io.File;
import java.util.Dictionary;

public class HuffmanFile {
    private File file;

    public HuffmanFile(String path) {
        throw new UnsupportedOperationException();
    }

    public String getPath() {
        return file.getAbsolutePath();
    }

    public String getName() {
        return this.file.getName();
    }

    public Dictionary readFreq() {
        throw new UnsupportedOperationException();
    }

    public String readBin() {
        throw new UnsupportedOperationException();
    }

    public void writeResult(String result) {
        throw new UnsupportedOperationException();
    }


}