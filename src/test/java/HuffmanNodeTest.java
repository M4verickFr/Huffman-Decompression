package test.java;

import main.java.HuffmanFile;
import main.java.HuffmanNode;
import org.junit.*;

/**
 * <b>HuffmanNodeTest est la classe les tests-unitaire de la classe HuffmanNode</b>
 * <p>
 * Cette classe est caractérisée par les tests suivants :
 * <ul>
 * <li>Récupération du caractère du noeud</li>
 * <li>Récupération du poids du noeud</li>
 * <li>Récupération du noeud enfant gauche</li>
 * <li>Récupération du noeud enfant droit</li>
 * <li>Tester s'il s'agit d'une feuille</li>
 * <li>Comparaison entre 2 noeuds</li>
 * </ul>
 * </p>
 *
 * @see HuffmanFile
 *
 * @author M4verickFr
 */
public class HuffmanNodeTest {
    /**
     * noeud fils gauche de l'arbre de test.
     */
    static HuffmanNode left;

    /**
     * noeud fils droit de l'arbre de test.
     */
    static HuffmanNode right;

    /**
     * noeud porent de l'arbre de test.
     */
    static HuffmanNode node;

    /**
     * Création d'un arbre de test.
     */
    @BeforeClass
    public static void setUp() {
        left = new HuffmanNode("a","1");
        right = new HuffmanNode("b","2");
        node = new HuffmanNode(left, right);
    }

    /**
     * Verifie que le caractère retourné est bien le caractère du noeud.
     */
    @Test
    public void getCharacter() {
        Assert.assertEquals("a".charAt(0), node.getLeft().getCharacter());
    }

    /**
     * Verifie que le poids retourné est bien le poids du noeud.
     */
    @Test
    public void getWeight() {
        Assert.assertEquals(1, node.getLeft().getWeight());
    }

    /**
     * Verifie que le fils retourner est bien le fils droit.
     */
    @Test
    public void getLeft() {
        Assert.assertEquals(left, node.getLeft());
    }

    /**
     * Verifie que le fils retourner est bien le fils droit.
     */
    @Test
    public void getRight() {
        Assert.assertEquals(right, node.getRight());
    }

    /**
     * Verifie que la méthode isLeaf test correctement si un noeud est une feuille.
     */
    @Test
    public void isLeaf() {
        Assert.assertEquals(false, node.isLeaf());
        Assert.assertEquals(true, node.getLeft().isLeaf());
    }

    /**
     * Verifie que la comparaison entre deux noeuds est correct.
     */
    @Test
    public void compareTo() {
        Assert.assertEquals(-1, left.compareTo(right));
    }
}