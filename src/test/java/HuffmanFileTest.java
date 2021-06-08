package test.java;

import main.java.HuffmanFile;
import org.junit.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.util.*;

/**
 * <b>HuffmanFileTest est la classe les tests-unitaire de la classe HuffmanFile</b>
 * <p>
 * Cette classe est caractérisée par les tests suivants :
 * <ul>
 * <li>Lecture du fichier frequence</li>
 * <li>Lecture du fichier binaire</li>
 * <li>Ecriture du fichier result</li>
 * <li>Récupérer le chemin du fichier</li>
 * <li>Récupérer le nom du fichier</li>
 * </ul>
 * </p>
 *
 * @see HuffmanFile
 *
 * @author M4verickFr
 */
public class HuffmanFileTest {

    /**
     * Verifie que le fichier fréquence est lu correctement.
     */
    @Test
    public void readFreq() {
        HuffmanFile file = new HuffmanFile("src/test/resources/exemple/exemple_freq.txt");
        Dictionary frequency = file.readFreq();
        Assert.assertEquals("1", frequency.get("b"));
        Assert.assertEquals("2", frequency.get("o"));
    }

    /**
     * Verifie que le fichier binaire est lu correctement.
     */
    @Test
    public void readBin() {
        HuffmanFile file = new HuffmanFile("src/test/resources/exemple/exemple_comp.txt");
        Assert.assertEquals("010111000111100101", file.readBin());
    }

    /**
     * Verifie que le fichier résultat est écrit correctement.
     *
     * @throws FileNotFoundException
     */
    @Test
    public void writeResult() throws FileNotFoundException {
        HuffmanFile file = new HuffmanFile("src/test/resources/exemple/exemple_result.txt");
        file.writeResult("bonjour");

        String resultString = "";
        File resultFile = new File("src/test/resources/exemple/exemple_result.txt");
        Scanner myReader = new Scanner(resultFile);
        while (myReader.hasNextLine()) {
            resultString += myReader.nextLine();
        }
        Assert.assertEquals("bonjour", resultString);
    }

    /**
     * Verifie que le chemin du fichier retourné est correct.
     */
    @Test
    public void getPath() {
        String path = "src/test/resources/exemple/exemple_freq.txt";
        HuffmanFile file = new HuffmanFile(path);
        String pathTest = FileSystems.getDefault().getPath(path).normalize().toAbsolutePath().toString();
        Assert.assertEquals(pathTest, file.getPath());
    }

    /**
     * Verifie que le nom du fichier retourné est correct.
     */
    @Test
    public void getName() {
        HuffmanFile file = new HuffmanFile("src/test/resources/exemple/exemple_freq.txt");
        Assert.assertEquals("exemple_freq.txt", file.getName());
    }
}