package main.java;

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

    public String getResult() {
        return result;
    }

    public static void main(String[] args) {
        HuffmanDecode huffmanDecode = new HuffmanDecode(args[0], args[1]);
        System.out.println(huffmanDecode.getResult());
    }
}
