package test.java;

import main.java.HuffmanTree;
import org.junit.Test;
import org.junit.*;

import java.util.Dictionary;
import java.util.Hashtable;

public class HuffmanTreeTest {

    static HuffmanTree tree;

    @BeforeClass
    public static void setUp() {
        Dictionary frequency = new Hashtable();
        frequency.put("a", "1");
        frequency.put("b", "2");
        frequency.put("c", "3");
        tree = new HuffmanTree(frequency);
    }

    @Test
    public void getCurrent() {
        Assert.assertEquals(tree.getCurrent(), tree.getRoot());
    }

    @Test
    public void moveToLeft() {
        tree.moveToRoot();
        tree.moveToLeft();
        Assert.assertEquals(tree.getCurrent(), tree.getRoot().getLeft());
    }

    @Test
    public void moveToRight() {
        tree.moveToRoot();
        tree.moveToRight();
        Assert.assertEquals(tree.getCurrent(), tree.getRoot().getRight());
    }

    @Test
    public void moveToRoot() {
        tree.moveToRight();
        tree.moveToRoot();
        Assert.assertEquals(tree.getCurrent(), tree.getRoot());
    }

    @Test
    public void decode() {
        Assert.assertEquals("cba", tree.decode("10100"));
    }

    @Test
    public void testToString() {
        String expected = "Node(a:1):00\nNode(b:2):01\nNode(c:3):1\n";
        Assert.assertEquals(expected, tree.toString());
    }
}