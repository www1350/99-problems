package com.absurd.np.LogicAndCodes;

import java.util.AbstractMap;

/**
 * Created by wangwenwei on 16/11/6.
 */
public class Node {
    private Node left;
    private Node right;
    private AbstractMap.SimpleEntry value;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public AbstractMap.SimpleEntry getValue() {
        return value;
    }

    public void setValue(AbstractMap.SimpleEntry value) {
        this.value = value;
    }
}
