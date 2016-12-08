package com.absurd.np.LogicAndCodes;

import org.junit.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * Created by wangwenwei on 16/11/6.
 */
public class P50Test {



    @Test
    public void shouldreturnHuffmanCode(){
      List<SimpleEntry<String,Integer>> frList  =Arrays.asList(new SimpleEntry<>("a",45),
                new SimpleEntry<>("b",13),
                new SimpleEntry<>("c",12),
                new SimpleEntry<>("d",16),
                new SimpleEntry<>("e",9),
                new SimpleEntry<>("f",5));
        List<SimpleEntry<String,String>>  result =  P50.huffman(frList);
        assertThat(result, hasSize(6));
        assertThat(result, hasItems(new SimpleEntry<>("a","0"),
                new SimpleEntry<>("b","101"),
                new SimpleEntry<>("c","100"),
                new SimpleEntry<>("d","111"),
                new SimpleEntry<>("e","1101"),
                new SimpleEntry<>("f","1100")));

    }

    @Test
    public void sort(){
        System.out.printf(""+Arrays.asList(3,2,5,6,7).stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList()));
    }
}
