package main.java;

import java.util.Dictionary;

public class HuffmanDecode {

    public HuffmanDecode(String frequencyFilePath, String binaryFilePath) {
        HuffmanFile freqFile = new HuffmanFile(frequencyFilePath);
        Dictionary frequency = freqFile.readFreq();

        HuffmanTree tree = new HuffmanTree(frequency);
    }

    public static void main(String[] args) {
        new HuffmanDecode(args[0], args[1]);
    }
}
