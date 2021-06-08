package main.java;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;

/**
 * <b>HuffmanTree est la classe représentant un arbre de Huffman.</b>
 * <p>
 * Un arbre de Huffman est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un noeud correspondant au noeud racine de l'arbre.</li>
 * <li>Un noeud pour se déplacer à travers l'arbre.</li>
 * </ul>
 * </p>
 *
 * @author M4verickFr
 * @see HuffmanNode
 */
public class HuffmanTree {

  /**
   * Le noeud racine du HuffmanTree.
   *
   * @see HuffmanTree#getRoot()
   * @see HuffmanTree#moveToRoot()
   */
  private HuffmanNode root;

  /**
   * Le noeud pour se déplacer à travers l'arbre.
   *
   * @see HuffmanTree#getCurrent()
   * @see HuffmanTree#moveToRoot()
   * @see HuffmanTree#moveToLeft()
   * @see HuffmanTree#moveToRight()
   */
  private HuffmanNode current;

  /**
   * Constructeur HuffmanTree.
   * <p>
   * A la construction d'un objet HuffmanTree, le noeud "current" correspond au noeud racine.
   * </p>
   *
   * @param frequency Dictionnaire contenant les fréquences de chaque caractère.
   * @see HuffmanTree#root
   * @see HuffmanTree#current
   */
  public HuffmanTree(@NotNull Dictionary frequency) {

    // Transforme chaque fréquence en noeuds.
    ArrayList<HuffmanNode> nodes = new ArrayList<>();
    for (Enumeration character = frequency.keys(); character.hasMoreElements(); ) {
      String c = character.nextElement().toString();
      nodes.add(new HuffmanNode(c, frequency.get(c).toString()));
    }

    // Génère l'arbre en créant des noeuds parent tant qu'il y a plusieurs noeuds
    while (nodes.size() > 1) {
      Collections.sort(nodes);
      HuffmanNode leftNode = nodes.remove(0);
      HuffmanNode rightNode = nodes.remove(0);
      HuffmanNode parentNode = new HuffmanNode(leftNode, rightNode);
      nodes.add(parentNode);
    }

    this.root = nodes.get(0);
    this.current = nodes.get(0);
  }

  /**
   * Retourne le noeud racine de l'arbre de Huffman
   *
   * @return le noeud racine.
   */
  public HuffmanNode getRoot() {
    return root;
  }

  /**
   * Retourne le noeud actuellement parcouru dans l'arbre de Huffman.
   *
   * @return le noeud actuel.
   */
  public HuffmanNode getCurrent() {
    return this.current;
  }

  /**
   * Deplace le noeud actuel a la racine de l'arbre
   *
   * @see HuffmanTree#root
   * @see HuffmanTree#current
   */
  public void moveToRoot() {
    // change current to reference the root of the tree
    this.current = this.root;
  }

  /**
   * Delace le noeud actuel à son enfant gauche.
   *
   * @see HuffmanTree#current
   */
  public void moveToLeft() {
    // change current to reference the left child of the current node
    this.current = this.current.getLeft();
  }

  /**
   * Delace le noeud actuel à son enfant droit.
   *
   * @see HuffmanTree#current
   */
  public void moveToRight() {
    // change current to reference the right child of the current node
    this.current = this.current.getRight();
  }

  /**
   * Retourne la chaine "binaryString" decoder avec l'arbre de Huffman.
   *
   * @param binaryString String binaire a decoder
   * @return la chaine "binaryString" decoder.
   */
  public String decode(String binaryString) {
    // Convertis binaryString en tableau de caractères.
    char[] binaryChars = binaryString.toCharArray();
    String result = "";

    /**
     * Pour chaque bit (0 ou 1), on parcourt l'arbre de Huffman.
     * Si le noeud actuel est une feuille de l'arbre, on rajoute son caractère correspondant
     * a la chaine result et on retourne au noeud racine.
     */
    for (char b : binaryChars) {
      if (!this.getCurrent().isLeaf()) {
        if (b == "0".charAt(0)) {
          this.moveToLeft();
        } else {
          this.moveToRight();
        }
      }

      if (this.getCurrent().isLeaf()) {
        result += this.getCurrent().getCharacter();
        this.moveToRoot();
      }
    }

    return result;
  }

  /**
   * Retourne l'arbre de Huffman sous la forme :
   * <p>
   * Node(a:1):00 Node(b:2):01 Node(c:3):1
   * </p>
   *
   * @return le code binaire de chaque caractères.
   */
  @Override
  public String toString() {
    return this.toString(this.root, "");
  }

  public String toString(HuffmanNode parent, String code) {
    String res = "";
    if (parent.isLeaf()) {
      res += parent.toString() + ":" + code + "\n";
    }
    if (parent.getLeft() != null) {
      res += this.toString(parent.getLeft(), code + "0");
    }
    if (parent.getRight() != null) {
      res += this.toString(parent.getRight(), code + "1");
    }
    return res;
  }
}
