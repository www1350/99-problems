package com.absurd.np.binaryTrees;

/**
 * @author <a href="mailto:wangwenwei@myhexin.com">王文伟</a>
 * @Company:浙江核新同花顺网络信息股份有限公司
 * @Title: ninetynine_problems
 * @Package com.absurd.np.binaryTrees
 * @Description:
 * @date 2016/12/8 16:04
 */
public class BinaryTree<T> {
    private T value;
    private BinaryTree leftNode;
    private BinaryTree rightNode;


    public BinaryTree() {
    }

    public BinaryTree(T value, BinaryTree leftNode, BinaryTree rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }



    public BinaryTree getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTree leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTree getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTree rightNode) {
        this.rightNode = rightNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
