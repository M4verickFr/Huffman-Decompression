package main.java;

import java.util.Dictionary;

public class HuffmanDecode {

    HuffmanTree tree;
    String result = "";

    public HuffmanDecode(String frequencyFilePath, String binaryFilePath) {
        // task3_read_frequencies
        HuffmanFile freqFile = new HuffmanFile(frequencyFilePath);
        Dictionary frequency = freqFile.readFreq();

        // task4_generate_huffman_tree
        this.tree = new HuffmanTree(frequency);

        // task5_read_binaries
        HuffmanFile binaryFile = new HuffmanFile(binaryFilePath);
        String binaryString = binaryFile.readBin();

        // task6_decode_binaries
        this.result = this.tree.decode(binaryString);

        // task7_write_result
        String outputFilePath = HuffmanFile.getOutputFilePath(freqFile);
        HuffmanFile outputFile = new HuffmanFile(outputFilePath);
        outputFile.writeResult(this.result);
    }

    public HuffmanTree getTree() { return tree; }

    public String getResult() {
        return result;
    }

    public static void main(String[] args) {
        HuffmanDecode huffmanDecode = new HuffmanDecode(args[0], args[1]);
        System.out.println(huffmanDecode.getResult());
        System.out.println(huffmanDecode.getTree());
    }
}
