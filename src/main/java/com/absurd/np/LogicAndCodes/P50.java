package com.absurd.np.LogicAndCodes;

import java.util.AbstractMap;
import java.util.List;
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
        return null;
    }
}
