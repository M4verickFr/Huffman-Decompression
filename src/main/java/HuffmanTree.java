package main.java;

import java.util.Dictionary;

public class HuffmanTree {
    private HuffmanNode root;
    private HuffmanNode current;

    public HuffmanTree(Dictionary frequency) {
        throw new UnsupportedOperationException();
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
