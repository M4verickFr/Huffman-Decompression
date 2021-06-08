package main.java;

import java.util.Dictionary;

/**
 * <b>HuffmanDecode est la classe principale du programme.</b>
 * <p>
 * Cette classe est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un HuffmanTree correspondant à l'arbre de Huffman.</li>
 * <li>Une chaine de caractères result correspondant au décodage de la chaine binaire.</li>
 * </ul>
 * </p>
 *
 * @author M4verickFr
 */
public class HuffmanDecode {
    /**
     * L'arbre Huffman permettant de decoder la chaine binaire.
     *
     * @see HuffmanDecode#getTree()
     */
    HuffmanTree tree;

    /**
     * Le texte decoder a l'aide de l'arbre de Huffman.
     *
     * @see HuffmanDecode#getResult()
     */
    String result = "";

    /**
     * Constructeur HuffmanDecode.
     * <p>
     * A la construction d'un objet HuffmanDecode, la chaine "result" correspond à la chaine binaire decoder.
     * </p>
     *
     * @param frequencyFilePath
     *                      Chemin du fichier contenant les fréquences.
     * @param binaryFilePath
     *                      Chemin du fichier contenant la chaine binaire.
     *
     */
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

    /**
     * Retourne l'arbre de Huffman permettant de decoder la chaine binaire.
     *
     * @return l'arbre binaire.
     */
    public HuffmanTree getTree() { return tree; }

    /**
     * Retourne la chaine binaire decoder a l'aide de l'arbre de Huffman.
     *
     * @return la chaine binaire.
     */
    public String getResult() {
        return result;
    }

    /**
     * Créer l'objet HuffmanDecode.
     * Affichage le résultat, et l'arbre de Huffman généré.
     */
    public static void main(String[] args) {
        HuffmanDecode huffmanDecode = new HuffmanDecode(args[0], args[1]);
        System.out.println(huffmanDecode.getResult());
        System.out.println(huffmanDecode.getTree());
    }
}
