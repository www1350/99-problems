package com.absurd.np.LogicAndCodes;

import java.util.AbstractMap;

/**
 * Created by wangwenwei on 16/11/6.
 */
public class Node<K, V> {
    private Node left;
    private Node right;
    private AbstractMap.SimpleEntry<K, V> value;
    private String code;

    public Node() {
        this.code="";
    }

    public Node(AbstractMap.SimpleEntry<K, V> value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.code="";
    }

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

    public AbstractMap.SimpleEntry<K, V> getValue() {
        return value;
    }

    public void setValue(AbstractMap.SimpleEntry<K, V> value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
