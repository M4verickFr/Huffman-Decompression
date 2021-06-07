package test.java;

import main.java.HuffmanFile;
import org.junit.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.util.*;

public class HuffmanFileTest {
    @Test
    public void readFreq() {
        HuffmanFile file = new HuffmanFile("src/test/resources/exemple/exemple_freq.txt");
        Dictionary frequency = file.readFreq();
        Assert.assertEquals("1", frequency.get("b"));
        Assert.assertEquals("2", frequency.get("!"));
    }

    @Test
    public void readBin() {
        HuffmanFile file = new HuffmanFile("src/test/resources/exemple/exemple_comp.txt");
        Assert.assertEquals("0101111101001110111010000", file.readBin());
    }

    @Test
    public void writeResult() throws FileNotFoundException {
        String resultString = "";
        File resultFile = new File("src/test/resources/exemple/exemple_result.txt");
        Scanner myReader = new Scanner(resultFile);
        while (myReader.hasNextLine()) {
            resultString += myReader.nextLine();
        }
        Assert.assertEquals("bonjour!!", resultString);
    }

    @Test
    public void getPath() {
        String path = "src/test/resources/exemple/exemple_freq.txt";
        HuffmanFile file = new HuffmanFile(path);
        String pathTest = FileSystems.getDefault().getPath(path).normalize().toAbsolutePath().toString();
        Assert.assertEquals(pathTest, file.getPath());
    }

    @Test
    public void getName() {
        HuffmanFile file = new HuffmanFile("src/test/resources/exemple/exemple_freq.txt");
        Assert.assertEquals("exemple_freq.txt", file.getName());
    }
}