package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;

public class HuffmanTree {
    private HuffmanNode root;
    private HuffmanNode current;

    public HuffmanTree(Dictionary frequency) {
        ArrayList<HuffmanNode> nodes = new ArrayList<>();
        for (Enumeration character = frequency.keys(); character.hasMoreElements(); ) {
            String c = character.nextElement().toString();
            nodes.add(new HuffmanNode(c, frequency.get(c).toString()));
        }

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

    public HuffmanNode getRoot() {
        return root;
    }

    public HuffmanNode getCurrent() {
        return this.current;
    }

    public void moveToRoot() {
        // change current to reference the root of the tree
        this.current = this.root;
    }

    public void moveToLeft() {
        // change current to reference the left child of the current node
        this.current = this.current.getLeft();
    }

    public void moveToRight() {
        // change current to reference the right child of the current node
        this.current = this.current.getRight();
    }

    public String decode(String binaryString) {
        throw new UnsupportedOperationException();
    }
}
