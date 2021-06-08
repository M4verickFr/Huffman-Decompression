package main.java;

/**
 * <b>HuffmanNode est la classe représentant un noeud dans l'arbre de Huffman</b>
 * <p>
 * Cette classe est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un caractère s'il s'agit d'une feuille</li>
 * <li>Le poids d'un noeud</li>
 * <li>Le noeud enfant gauche</li>
 * <li>Le noeud enfant droit</li>
 * </ul>
 * </p>
 *
 * @see HuffmanTree
 *
 * @author M4verickFr
 */
public class HuffmanNode implements Comparable<HuffmanNode>{
    /**
     * Le caractère attribué au noeud.
     *
     * @see HuffmanNode#getCharacter()
     */
    private char character;

    /**
     * Le poids du noeud, correspondant à la fréquence du caractère ou du poids cumulé de c'est 2 fils.
     *
     * @see HuffmanNode#getWeight()
     */
    private int weight;

    /**
     * Le noeud enfant gauche.
     *
     * @see HuffmanNode#getLeft()
     */
    private HuffmanNode left;

    /**
     * Le noeud enfant droit.
     *
     * @see HuffmanNode#getRight()
     */
    private HuffmanNode right;

    /**
     * Constructeur HuffmanNode
     * <p>
     * Constructeur utilisé pour transformer les fréquences en noeud.
     * A la construction d'un objet HuffmanNode, le poids du noeud correspond la fréquence du caractère.
     * </p>
     *
     * @param character
     *                  Caractère correspondant au noeud.
     * @param weight
     *                  Fréquence du caractère.
     */
    public HuffmanNode(String character, String weight) {
        this.character = character.charAt(0);
        this.weight = Integer.parseInt(weight);
    }

    /**
     * Constructeur HuffmanNode
     * <p>
     * Constructeur utilisé pour générer l'arbre de Huffman.
     * A la construction d'un objet HuffmanNode, le poids du noeud correspond au poids cumulé des 2 fils.
     * </p>
     *
     * @param left
     *              Noeud enfant gauche.
     * @param right
     *              Noeud enfant droit.
     */
    public HuffmanNode(HuffmanNode left, HuffmanNode right) {
        this.left = left;
        this.right = right;
        this.weight = left.getWeight() + right.getWeight();
    }

    /**
     * Retourne le caractère attribué au noeud.
     *
     * @return le caractère du noeud.
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Retourne le poids du noeud.
     *
     * @return le poids du noeud
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Retourne le noeud enfant gauche
     *
     * @return le noeud enfant gauche
     */
    public HuffmanNode getLeft() {
        return left;
    }

    /**
     * Retourne le noeud enfant droit
     *
     * @return le noeud enfant droit
     */
    public HuffmanNode getRight() {
        return right;
    }

    /**
     * Test si le noeud est une feuille.
     *
     * @return an boolean.
     */
    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    /**
     * Permet de comparer 2 noeuds.
     * <p>
     * Si le poids est différent, on compare en fonction de celui-ci.
     * Sinon on compare à l'aide du caractère.
     * </p>
     *
     * @param node
     *             Noeud a comparer avec le noeud actuel.
     *
     * @return le résultat de la comparaison.
     */
    @Override public int compareTo(HuffmanNode node)
    {
        if (this.weight != node.weight) {
            return this.weight - node.weight;
        }
        return (this.character + "").compareTo((node.character + ""));
    }

    /**
     * Retourne le noeud sous la forme :
     * <p>Node(a:1)</p>
     *
     * @return le caractère du noeud et son poids.
     */
    @Override
    public String toString() {
        return "Node(" + character + ":" + weight + ")";
    }
}
