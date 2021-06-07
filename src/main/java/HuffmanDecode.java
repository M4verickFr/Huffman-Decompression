package main.java;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;

public class HuffmanDecode {

    String result = "";

    public HuffmanDecode(String frequencyFilePath, String binaryFilePath) {
        HuffmanFile freqFile = new HuffmanFile(frequencyFilePath);
        Dictionary frequency = freqFile.readFreq();

        HuffmanTree tree = new HuffmanTree(frequency);

        HuffmanFile binaryFile = new HuffmanFile(binaryFilePath);
        String binaryString = binaryFile.readBin();

        this.result = tree.decode(binaryString);

        String outputFilePath = HuffmanFile.getOutputFilePath(freqFile);
        HuffmanFile outputFile = new HuffmanFile(outputFilePath);
        outputFile.writeResult(this.result);

    }

    public static void main(String[] args) {
        new HuffmanDecode(args[0], args[1]);
    }
}
