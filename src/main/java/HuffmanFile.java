package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * <b>HuffmanFile est la classe représentant un fichier Huffman.</b>
 * <p>
 * Un fichier Huffman est caractérisé par un fichier.
 * </p>
 *
 * @author M4verickFr
 */
public class HuffmanFile {
    /**
     * Le fichier correspond au fichier Huffman.
     *
     * @see HuffmanFile#getName()
     * @see HuffmanFile#getPath()
     */
    private File file;

    /**
     * Constructeur HuffmanFile
     * <p>
     *     Le fichier "file" correspond au fichier du "path"
     * </p>
     *
     * @param path
     *              Chemin d'accès au fichier.
     *
     * @see HuffmanFile#file
     */
    public HuffmanFile(String path) {
        this.file = new File(path);
    }

    /**
     * Retourne le chemin absolue du fichier.
     *
     * @return le chemin du fichier.
     */
    public String getPath() {
        return file.getAbsolutePath();
    }

    /**
     * Retourne le nom du fichier.
     *
     * @return le nom du fichier
     */
    public String getName() {
        return this.file.getName();
    }

    /**
     * Lecture d'un fichier frequence.
     * <p>
     * Retourne la liste des frequences presente dans le fichier.
     * </p>
     *
     * @return un dictionnary avec les frequences.
     */
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

    /**
     * Lecture d'un fichier binaire.
     * <p>
     * Retourne la chaine binaire encoder dans le fichier.
     * </p>
     *
     * @return la chaine binaire.
     */
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

    /**
     * Ecriture du fichier result.
     * <p>
     * Créer et écrit dans le fichier Huffman la chaine "result".
     * </p>
     *
     * @param result
     *              Chaine a écrire dans le fichier result.
     */
    public void writeResult(String result) {
        try {
            FileWriter fileWriter = new FileWriter(this.file);
            fileWriter.write(result);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("main.HuffmanFile caught an IOException");
        }
    }

    /**
     * Genere le chemin du fichier résultat.
     * <p>
     * Créer le chemin du fichier r"sultat a l'aide du chemin du fichier passé en paramètre.
     * </p>
     *
     * @param file
     *              Fichier situé dans le dossier où écrit le résultat.
     *
     * @return le chemin du fichier résultat.
     */
    public static String getOutputFilePath(HuffmanFile file) {
        Path path = Paths.get(file.getPath());
        String outputFilePath = path.getParent() + "/";
        outputFilePath += file.getName().split("_")[0];
        outputFilePath += "_result.txt";
        return outputFilePath;
    }

}