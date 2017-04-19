package com.absurd.common.algorithm.trees;

import java.util.List;


/**
 * Given a binary tree, can you write a method to return a list of nodes by level?
 * And without any additional data structure?
 * @author Absurd.
 */
public class BinaryTreeByLevel {
    /**
     * Add implementation based on an additional data structure, one queue which implementation is a
     * LinkedList. We we are going to do is add elements of the tree to the queue and one by one
     * evaluate it adding more binary nodes to the queue if exist. The complexity order in time terms
     * is O(N) where N is the number of elements in the tree. The complexity order in space terms is
     * O(N) where N is the number of elements in the tree because we are going to store every node in
     * a queue.
     */
    public List<BinaryNode> getUsingQueue(BinaryNode root) {
        //TODO
        return null;
    }





    /**
     * Slower implementation created to resolve one of the questions of problem 13, print the binary
     * tree by level without use any additional data structure for the main algorithm.
     * The complexity order in space terms is O(N) because we are using one structure to return the
     * result. The complexity order in time terms is O(N*M) where the N is the depth of the Binary
     * Tree and M is the number of elements below one level.
     *
     * To be able to implement this approach you need to know the depth of the tree before to start.
     * This approach is based on recursion and uses the level param as counter to go through the
     * binary tree.
     */
    public List<BinaryNode> getWithoutAdditionalDataStructures(BinaryNode root) {
        //TODO
        return null;
    }



    /**
     * Calculate the Binary Tree depth based on recursion. The complexity order in space terms of
     * this algorithm is O(N) and in time terms is O(N) where N is the number of nodes in the tree.
     */
    private int getDepth(BinaryNode root) {
        //TODO
        return 0;
    }
}
