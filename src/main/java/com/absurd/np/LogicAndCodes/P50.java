package com.absurd.np.LogicAndCodes;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * First of all, study a good book on discrete mathematics or algorithms for a detailed description of Huffman codes, or consult Wikipedia
 * We suppose a set of symbols with their frequencies, given as a list of fr(S,F) terms.
 * Example: [fr(a,45),fr(b,13),fr(c,12),fr(d,16),fr(e,9),fr(f,5)].
 * Our objective is to construct a list hc(S,C) terms, where C is the Huffman code word for the symbol S.
 * In our example, the result could be Hs = [hc(a,'0'), hc(b,'101'), hc(c,'100'), hc(d,'111'), hc(e,'1101'), hc(f,'1100')] [hc(a,'01'),...etc.].
 * The task shall be performed by the predicate huffman/2 defined as follows:
 * % huffman(Fs,Hs) :- Hs is the Huffman code table for the frequency table Fs
 * Created by wangwenwei on 16/11/6.
 */
public class P50 {
    /***
     * 5 9 14
     * 12 13 25
     * 14 16 30
     * 25 30 55
     * 45 55 100
     *     T        T
     *    |\       / \
     *    T a     a  T
     *    |\        /  \
     *    T T      T   T
     *   /| |\    / \  | \
     *  b c e f  c  b  f  e
     *
     *
     * @param frList
     * @return
     */
    public static List<AbstractMap.SimpleEntry<String, String>> huffman(List<AbstractMap.SimpleEntry<String, Integer>> frList) {
        List<Node<String, Integer>> nodeList = frList.stream().map(e->new Node<String, Integer>(e)).collect(Collectors.toList());
        while(nodeList.size()>1) {
            AbstractMap.SimpleEntry<String, Integer> min = null;
            AbstractMap.SimpleEntry<String, Integer> semin = null;
            int length = nodeList.size();
            int minPos = 0;
            int seminPos = 1;
            if (nodeList.get(0).getValue().getValue() < nodeList.get(1).getValue().getValue()) {
                min = nodeList.get(0).getValue();
                semin = nodeList.get(1).getValue();
            } else {
                min = nodeList.get(1).getValue();
                semin = nodeList.get(0).getValue();
                minPos = 1;
                seminPos = 0;
            }
            if (length>1)
            for (int i = 2; i < length; i++) {
                if (nodeList.get(i).getValue().getValue() < semin.getValue()) {
                    if (nodeList.get(i).getValue().getValue() < min.getValue()) {
                        semin = min;
                        min = nodeList.get(i).getValue();
                        seminPos = minPos;
                        minPos = i;
                    } else {
                        semin = nodeList.get(i).getValue();
                        seminPos = i;
                    }
                }
            }
            AbstractMap.SimpleEntry<String, Integer> temp = new AbstractMap.SimpleEntry<String, Integer>("T", min.getValue() + semin.getValue());
            Node<String, Integer> neNode = new Node<>(temp);
            neNode.setLeft(nodeList.get(minPos));
            neNode.setRight(nodeList.get(seminPos));
           if( seminPos<minPos) {
               nodeList.remove(minPos);
               nodeList.remove(seminPos);
           }else{
               nodeList.remove(seminPos);
               nodeList.remove(minPos);
           }
            nodeList.add(neNode);
        }
        List<AbstractMap.SimpleEntry<String,String>>  result = hc(nodeList.get(0));

        return result;
    }

    private static List<AbstractMap.SimpleEntry<String, String>> hc(Node<String, Integer> treeNode) {
        List<AbstractMap.SimpleEntry<String, String>> result = new ArrayList<>();
        Queue<Node<String, Integer>> queue = new LinkedBlockingQueue();
        queue.add(treeNode);
        while(queue.size()>0){
            Node<String, Integer>  node =   queue.poll();
            if ("T".equals(node.getValue().getKey())){
                if (node.getLeft()!=null){
                    Node left =  node.getLeft();
                    left.setCode(node.getCode()+"0");
                    queue.add(left);
                }

                if (node.getRight()!=null){
                    Node right = node.getRight();
                    right.setCode(node.getCode()+"1");
                    queue.add(right);
                }

            }else{
                AbstractMap.SimpleEntry<String, String> re = new AbstractMap.SimpleEntry<String, String>(node.getValue().getKey(),node.getCode());
                result.add(re);
            }
        }

        return result;
    }
}
