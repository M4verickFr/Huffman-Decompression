package test.java;

import main.java.HuffmanNode;
import org.junit.*;

public class HuffmanNodeTest {

    static HuffmanNode left;
    static HuffmanNode right;
    static HuffmanNode node;

    @BeforeClass
    public static void setUp() {
        left = new HuffmanNode("a","1");
        right = new HuffmanNode("b","2");
        node = new HuffmanNode(left, right);
    }

    @Test
    public void getCharacter() {
        Assert.assertEquals("a".charAt(0), node.getLeft().getCharacter());
    }

    @Test
    public void getWeight() {
        Assert.assertEquals(1, node.getLeft().getWeight());
    }

    @Test
    public void getLeft() {
        Assert.assertEquals(left, node.getLeft());
    }

    @Test
    public void getRight() {
        Assert.assertEquals(right, node.getRight());
    }

    @Test
    public void isLeaf() {
        Assert.assertEquals(false, node.isLeaf());
        Assert.assertEquals(true, node.getLeft().isLeaf());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(-1, left.compareTo(right));
    }
}