package main.java;

public class HuffmanNode implements Comparable<HuffmanNode>{
    private char character;
    private int weight;
    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode(String character, String weight) {
        this.character = character.charAt(0);
        this.weight = Integer.parseInt(weight);
    }

    public HuffmanNode(HuffmanNode left, HuffmanNode right) {
        this.left = left;
        this.right = right;
        this.weight = left.getWeight() + right.getWeight();
    }

    public char getCharacter() {
        return character;
    }

    public int getWeight() {
        return this.weight;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    @Override public int compareTo(HuffmanNode node)
    {
        return this.weight - node.weight;
    }

    @Override
    public String toString() {
        return "Node(" + character + ":" + weight + ")";
    }
}
