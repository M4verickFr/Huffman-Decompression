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
        char[] binaryChars = binaryString.toCharArray();

        String result = "";
        for (char b: binaryChars) {

            if(!this.getCurrent().isLeaf()) {
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

    @Override
    public String toString() {
        return this.toString(this.root, "");
    }

    public String toString(HuffmanNode parent, String code) {
        String res = "";
        if (parent.isLeaf()) {
            res += parent.toString()+":"+code+"\n";
        }
        if (parent.getLeft() != null) {
            res += this.toString(parent.getLeft(), code+"0");
        }
        if (parent.getRight() != null) {
            res += this.toString(parent.getRight(),code+"1");
        }
        return res;
    }
}
