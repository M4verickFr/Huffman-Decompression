package test.java;

import main.java.HuffmanFile;
import main.java.HuffmanTree;
import org.junit.Test;
import org.junit.*;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * <b>HuffmanTreeTest est la classe les tests-unitaire de la classe HuffmanTree</b>
 * <p>
 * Cette classe est caractérisée par les tests suivants :
 * <ul>
 * <li>Récupération du noeud actuel</li>
 * <li>Déplacement du noeud actuel sur le noeud enfant gauche</li>
 * <li>Déplacement du noeud actuel sur le noeud enfant droit</li>
 * <li>Déplacement du noeud actuel sur le noeud root</li>
 * <li>Décodage de la chaine binaire</li>
 * <li>Affichage d'un arbre de Huffman</li>
 * </ul>
 * </p>
 *
 * @author M4verickFr
 * @see HuffmanFile
 */
public class HuffmanTreeTest {

  /**
   * Arbre Huffman de test.
   */
  static HuffmanTree tree;

  /**
   * Création d'un arbre de test.
   */
  @BeforeClass
  public static void setUp() {
    Dictionary frequency = new Hashtable();
    frequency.put("a", "1");
    frequency.put("b", "2");
    frequency.put("c", "3");
    tree = new HuffmanTree(frequency);
  }

  /**
   * Vérifie qu'initialement le noeud actuel correspond au noeud root
   */
  @Test
  public void getCurrent() {
    Assert.assertEquals(tree.getCurrent(), tree.getRoot());
  }

  /**
   * Vérifie que le noeud actuel est déplacé sur le noeud fils gauche.
   */
  @Test
  public void moveToLeft() {
    tree.moveToRoot();
    tree.moveToLeft();
    Assert.assertEquals(tree.getCurrent(), tree.getRoot().getLeft());
  }

  /**
   * Vérifie que le noeud actuel est déplacé sur le noeud fils droit.
   */
  @Test
  public void moveToRight() {
    tree.moveToRoot();
    tree.moveToRight();
    Assert.assertEquals(tree.getCurrent(), tree.getRoot().getRight());
  }

  /**
   * Vérifie que le noeud actuel est déplacé sur le noeud racine.
   */
  @Test
  public void moveToRoot() {
    tree.moveToRight();
    tree.moveToRoot();
    Assert.assertEquals(tree.getCurrent(), tree.getRoot());
  }

  /**
   * Vérifie que la chaine binaire est decodée correctement.
   */
  @Test
  public void decode() {
    Assert.assertEquals("cba", tree.decode("10100"));
  }

  /**
   * Vérifie qu'un arbre Huffman est affiché correctement.
   */
  @Test
  public void testToString() {
    String expected = "Node(a:1):00\nNode(b:2):01\nNode(c:3):1\n";
    Assert.assertEquals(expected, tree.toString());
  }
}