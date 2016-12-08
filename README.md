# Ninety-Nine Problems in Java 8

This is an adaptation of the [Ninety-Nine Prolog Problems](https://sites.google.com/site/prologsite/prolog-problems) written by Werner Hett at the Berne University of Applied Sciences in Berne, Switzerland.

From the original source:

> The purpose of this problem collection is to give you the opportunity to practice your skills in logic programming. Your goal should be to find the most elegant solution of the given problems. Efficiency is important, but logical clarity is even more crucial. Some of the (easy) problems can be trivially solved using built-in predicates. However, in these cases, you learn more if you try to find your own solution.

> The problems have different levels of difficulty. Those marked with a single asterisk (\*) are easy. If you have successfully solved the preceding problems you should be able to solve them within a few (say 15) minutes. Problems marked with two asterisks (\*\*) are of intermediate difficulty. If you are a skilled Java programmer it shouldn't take you more than 30-90 minutes to solve them. Problems marked with three asterisks (\*\*\*) are more difficult. You may need more time (i.e. a few hours or more) to find a good solution.

I will use Java 8 features wherever it makes sense so that developers can learn how to use new features introduced in Java 8. If you are new to Java 8 then you can learn more about it by following my in-depth [Java 8 tutorial](https://github.com/shekhargulati/java8-the-missing-tutorial).

## Table of Contents

* [Lists](#lists)
* [Arithmetic](#arithmetic)
* [Logic and Codes](#logic-and-codes)
* [Binary Trees](#binary-trees)
* [Multiway Trees](#multiway-trees)
* [Graphs](#graphs)
* [Miscellaneous](#miscellaneous)

## Lists

In Java, lists are instances of `List<T>` sub-types. You could use `ArrayList<T>` or `LinkedList<T>`. `LinkedList` are better suited for writing functional programs because they provide you methods to get the first and last elements of a List. One of the method that you will miss when working with Java LinkedList is `tail`. `tail` gives you everything except the first element. You could easily implement `tail` as shown below.

```java
public static <T> List<T> tail(LinkedList<T> elements) {
    if (elements == null || elements.isEmpty()) {
        throw new NoSuchElementException();
    }
    if (elements.size() == 1) {
        return Collections.emptyList();
    }
    return elements.subList(1, elements.size());
}
```

> Java 8 does not support pattern matching so you have to use if-else in your code.

### [P01](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P01.java) **(*) Find the last element of a list**

```java
@Test
public void shouldFindLastElementFromAListOfAlphabets() throws Exception {
    assertThat(P01.last(asList("a", "b", "c", "d")), is(equalTo("d")));
}
```

### [P02](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P02.java) **(*) Find the last but one element of a list**

```java
@Test
public void shouldFindSecondLastElementFromAList() throws Exception {
    List<Integer> numbers = asList(1, 2, 11, 4, 5, 8, 10, 6);
    assertThat(P02.secondLast(numbers), is(equalTo(10)));
}
```

The method should throw `NoSuchElementException` when list is either empty or has one element.

```java
@Test(expected = NoSuchElementException.class)
public void shouldThrowExceptionWhenListEmpty() throws Exception {
    P02.secondLast(Collections.emptyList());
}

@Test(expected = NoSuchElementException.class)
public void shouldThrowExceptionWhenListHasSingleElement() throws Exception {
    P02.secondLast(Arrays.asList(1));
}
```

### [P03](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P03.java) **(*) Find the Kth element of a list**

The first element of a list has index 0. In the example shown below, last element would be at kth position 4.

```java
@Test
public void shouldFindKthElementFromAList() throws Exception {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    assertThat(P03.kth(numbers, 2), is(equalTo(3)));
}
```

### [P04](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P04.java) **(*) Find the number of elements of a list**

```java
@Test
public void listOfEmptyListShouldBe0() throws Exception {
    int length = P04.length(Collections.emptyList());
    assertThat(length, is(equalTo(0)));
}

@Test
public void shouldFindListOfNonEmptyList() throws Exception {
    assertThat(P04.length(Arrays.asList(1, 2, 3, 4, 5)), is(equalTo(5)));
}
```

### [P05](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P05.java) **(*) Reverse a list**

```java
@Test
public void shouldReverseAList() throws Exception {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    assertThat(P05.reverse(numbers), is(equalTo(Arrays.asList(5, 4, 3, 2, 1))));
}
```

### [P06](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P06.java) **(*) Find out whether a list is a palindrome**

```java
@Test
public void shouldReturnTrueWhenListIsPalindrome() throws Exception {
    assertTrue(isPalindrome(Arrays.asList("x", "a", "m", "a", "x")));
}

@Test
public void shouldReturnFalseWhenListIsNotPalindrome() throws Exception {
    assertFalse(isPalindrome(Arrays.asList(1, 2, 3, 4, 5)));
}
```

### [P07](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P07.java) **(\*\*) Flatten a nested list structure**

```java
import static java.util.Arrays.asList;

@Test
public void shouldFlattenAListOfList() throws Exception {
    List<String> flatten = P07.flatten(asList("a", asList("b", asList("c", "d")), "e"), String.class);
    assertThat(flatten, hasSize(5));
    assertThat(flatten, hasItems("a", "b", "c", "d", "e"));
}

@Test
public void shouldFlattenDeepNestedLists() throws Exception {
    List<String> flatten = P07.flatten(asList("a", asList("b", asList("c", asList("d", "e", asList("f", "g"))), "h")), String.class);
    assertThat(flatten, hasSize(8));
    assertThat(flatten, hasItems("a", "b", "c", "d", "e", "f", "g", "h"));
}

@Test
public void shouldReturnEmptyListWhenTryingToFlattenAnEmptyList() throws Exception {
    List<String> flatten = P07.flatten(Collections.emptyList(), String.class);
    assertTrue(flatten.isEmpty());
}
```

### [P08](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P08.java) **(\*\*) Eliminate consecutive duplicates of list elements**

If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.

```java
@Test
public void shouldRemoveConsecutiveDuplicatesInAList() throws Exception {
   List<String> compressedList = P08.compress(asList("a", "a", "a", "a", "b", "c", "c", "d", "e", "e", "e", "e"));
   assertThat(compressedList, hasSize(5));
   assertThat(compressedList, contains("a", "b", "c","d", "e"));
}

@Test
public void shouldNotRemoveNonConsecutiveSimilarElementsFromAList() throws Exception {
   List<String> compressedList = P08.compress(asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
   assertThat(compressedList, hasSize(6));
   assertThat(compressedList, contains("a", "b", "c","a", "d", "e"));
}
```

### [P09](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P09.java) **(\*\*) Pack consecutive duplicates of list elements into sublists**

If a list contains repeated elements they should be placed in separate sublists.

```java

@Test
public void shouldReturnAListWithTwoListElementsWhenAListWithTwoUniqueElementsIsPassed() throws Exception {
    List<List<String>> packedList = P09.pack(Arrays.asList("a", "b"));
    assertThat(packedList, hasSize(2));
    assertThat(packedList.get(0), contains("a"));
    assertThat(packedList.get(1), contains("b"));
}

@Test
public void shouldPackConsecutiveDuplicatesInTheirOwnLists() throws Exception {
    List<List<String>> packedList = P09.pack(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
    assertThat(packedList, hasSize(6));
    assertThat(packedList.get(0), contains("a", "a", "a", "a"));
    assertThat(packedList.get(1), contains("b"));
    assertThat(packedList.get(2), contains("c", "c"));
    assertThat(packedList.get(3), contains("a", "a"));
    assertThat(packedList.get(4), contains("d"));
    assertThat(packedList.get(5), contains("e", "e", "e", "e"));
}
```

### [P10](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P10.java) **(*) Run-length encoding of a list**

Use the result of problem 1.09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as terms [N,E] where N is the number of duplicates of the element E.

```java
@Test
public void shouldEncodeAList() throws Exception {
    List<SimpleEntry<Integer, String>> encodedList = P10.encode(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
    assertThat(encodedList, hasSize(6));
    assertThat(encodedList.get(0), is(equalTo(new SimpleEntry<>(4, "a"))));
    assertThat(encodedList.get(1), is(equalTo(new SimpleEntry<>(1, "b"))));
    assertThat(encodedList.get(2), is(equalTo(new SimpleEntry<>(2, "c"))));
    assertThat(encodedList.get(3), is(equalTo(new SimpleEntry<>(2, "a"))));
    assertThat(encodedList.get(4), is(equalTo(new SimpleEntry<>(1, "d"))));
    assertThat(encodedList.get(5), is(equalTo(new SimpleEntry<>(4, "e"))));
}
```

### [P11](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P11.java) **(*) Modified run-length encoding**

Modify the result of problem 1.10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as [N,E] terms.

```java
@Test
public void shouldEncodeAList() throws Exception {
    List<Object> encodedList = P11.encode_modified(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
    assertThat(encodedList, hasSize(6));
    assertThat(encodedList.get(0), is(equalTo(new SimpleEntry<>(4, "a"))));
    assertThat(encodedList.get(1), is(equalTo("b")));
    assertThat(encodedList.get(2), is(equalTo(new SimpleEntry<>(2, "c"))));
    assertThat(encodedList.get(3), is(equalTo(new SimpleEntry<>(2, "a"))));
    assertThat(encodedList.get(4), is(equalTo("d")));
    assertThat(encodedList.get(5), is(equalTo(new SimpleEntry<>(4, "e"))));
}
```

### [P12](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P12.java) **(\*\*) Decode a run-length encoded list**

Given a run-length code list generated as specified in problem 1.11. Construct its uncompressed version.


```java
@Test
public void shouldDecodeEncodedList() throws Exception {
    List<String> encoded = P12.decode(
            Arrays.asList(
                    new SimpleEntry<>(4, "a"),
                    "b",
                    new SimpleEntry<>(2, "c"),
                    new SimpleEntry<>(2, "a"),
                    "d",
                    new SimpleEntry<>(4, "e")));

    assertThat(encoded, hasSize(14));
}
```

### [P13](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P13.java) **(\*\*) Run-length encoding of a list (direct solution)**

Implement the so-called run-length encoding data compression method directly. I.e. don't explicitly create the sublists containing the duplicates, as in problem P09, but only count them.

```java
@Test
public void shouldEncodeAList() throws Exception {
    List<SimpleEntry<Integer, String>> encodedList = P13.encode_direct(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
    assertThat(encodedList, hasSize(6));
    assertThat(encodedList.get(0), is(equalTo(new SimpleEntry<>(4, "a"))));
    assertThat(encodedList.get(1), is(equalTo(new SimpleEntry<>(1, "b"))));
    assertThat(encodedList.get(2), is(equalTo(new SimpleEntry<>(2, "c"))));
    assertThat(encodedList.get(3), is(equalTo(new SimpleEntry<>(2, "a"))));
    assertThat(encodedList.get(4), is(equalTo(new SimpleEntry<>(1, "d"))));
    assertThat(encodedList.get(5), is(equalTo(new SimpleEntry<>(4, "e"))));
}
```

### [P14](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P14.java) **(*) Duplicate the elements of a list**

```java
@Test
public void shouldDuplicateElementsInAList() throws Exception {
    List<String> duplicates = P14.duplicate(Arrays.asList("a", "b", "c", "d"));
    assertThat(duplicates, hasSize(8));
    assertThat(duplicates, contains("a", "a", "b", "b", "c", "c", "d", "d"));
}
```

### [P15](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P15.java) ** (\*\*) Duplicate the elements of a list a given number of times**

```java
@Test
public void shouldDuplicateElementsInAList() throws Exception {
    List<String> duplicates = P15.duplicate(Arrays.asList("a", "b", "c"), 3);
    assertThat(duplicates, hasSize(9));
    assertThat(duplicates, contains("a", "a", "a", "b", "b", "b", "c", "c", "c"));
}
```

### [P16](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P16.java) **(\*\*) Drop every N'th element from a list**

```java
@Test
public void shouldDropEveryNthElement() throws Exception {
    List<String> result = P16.dropEveryNth(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 3);
    assertThat(result, hasSize(8));
    assertThat(result, contains("a", "b", "d", "e", "g", "h", "j", "k"));
}

@Test
public void shouldReturnSameListWhenNIsLessThanListSize() throws Exception {
    List<String> result = P16.dropEveryNth(Arrays.asList("a", "b"), 3);
    assertThat(result, hasSize(2));
    assertThat(result, contains("a", "b"));
}

@Test
public void shouldReturnSameListWhenNIsZero() throws Exception {
    List<String> result = P16.dropEveryNth(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 0);
    assertThat(result, hasSize(11));
    assertThat(result, contains("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
}
```

### [P17](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P17.java) **(*) Split a list into two parts; the length of the first part is given**

```java
@Test
public void shouldSplitInTwoHalves() throws Exception {
    Map<Boolean, List<String>> result = P17.split(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3);
    assertThat(result.get(true), contains("a", "b", "c"));
    assertThat(result.get(false), contains("d", "e", "f", "g", "h", "i", "k"));
}
```

### [P18](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P18.java) **(\*\*) Extract a slice from a list**

```java
@Test
public void shouldGiveSliceOfAList() throws Exception {
    List<String> slice = P18.slice(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3, 7);
    assertThat(slice, hasSize(5));
    assertThat(slice, contains("c", "d", "e", "f", "g"));
}
```

### [P19](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P19.java) **(\*\*) Rotate a list N places to the left**

```java
@Test
public void shouldRotateAListByThreeElementsWhenNIs3() throws Exception {
    List<String> rotated = P19.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 3);
    assertThat(rotated, equalTo(Arrays.asList("d", "e", "f", "g", "h", "a", "b", "c")));
}

@Test
public void shouldReturnSameListWhenNIs0() throws Exception {
    List<String> rotated = P19.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 0);
    assertThat(rotated, equalTo(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h")));
}

@Test
public void shouldRotateWhenNIsNegative() throws Exception {
    List<String> rotated = P19.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), -2);
    assertThat(rotated, equalTo(Arrays.asList("g", "h", "a", "b", "c", "d", "e", "f")));
}
```


### [P20](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P20.java) **(*) Remove the K'th element from a list**

```java
@Test
public void shouldRemoveKthElementFromList() throws Exception {
    Object[] result = P20.removeAt(Arrays.asList("a", "b", "c", "d"), 2);
    assertThat(result[0], equalTo(Arrays.asList("a", "c", "d")));
    assertThat(result[1], equalTo("b"));
}
```

### [P21](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P21.java) **(*) Insert an element at a given position into a list**

```java
@Test
public void shouldInsertElementAtSecondPosition() throws Exception {
    List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
    List<String> result = P21.insertAt(input, 2, "alfa");
    assertThat(result, hasSize(5));
    assertThat(result, contains("a", "alfa", "b", "c", "d"));

}

@Test
public void shouldInsertElementAtFirstPosition() throws Exception {
    List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
    List<String> result = P21.insertAt(input, 1, "alfa");
    assertThat(result, hasSize(5));
    assertThat(result, contains("alfa", "a", "b", "c", "d"));

}

@Test
public void shouldInsertElementAtEnd() throws Exception {
    List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
    List<String> result = P21.insertAt(input, 5, "alfa");
    assertThat(result, hasSize(5));
    assertThat(result, contains("a", "b", "c", "d", "alfa"));
}
```

### [P22](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P22.java) **(*) Create a list containing all integers within a given range**

```java
@Test
public void shouldCreateARangeBetween4And9() throws Exception {
    List<Integer> range = P22.range(4, 9);
    assertThat(range, hasSize(6));
    assertThat(range, contains(4, 5, 6, 7, 8, 9));

}
```

### [P23](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P23.java) **(\*\*) Extract a given number of randomly selected elements from a list**

```java
@Test
public void shouldReturnAListOfThreeRandomSelectedElements() throws Exception {
    List<String> result = P23.randomSelect(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 3);
    System.out.println(result);
    assertThat(result, hasSize(3));
}
```

### [P24](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P24.java) **(*) Lotto: Draw N different random numbers from the set 1..M**

> Hint: Combine the solutions of problems P22 and P23

```java
@Test
public void shouldGive6RandomNumbersFromARangeStartingFrom1To49() throws Exception {
    List<Integer> randomList = P24.randomSelect(6, 1, 49);
    assertThat(randomList, hasSize(6));
    System.out.println(randomList); // One possible output [47, 30, 36, 38, 11, 1]
}
```

### [P25](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P25.java) **(*) Generate a random permutation of the elements of a list**

> Hint: Use the solution of problem P23

```java
@Test
public void shouldGenerateRandomPermutationOfElementsOfAList() throws Exception {
    List<String> permutation = P25.randomPermutation(Stream.of("a", "b", "c", "d", "e", "f").collect(toList()));
    assertThat(permutation, hasSize(6));
    assertThat(permutation, containsInAnyOrder("a", "b", "c", "d", "e", "f"));
    System.out.println(permutation); // one possible output [a, e, f, c, b, d]
}
```

### [P26](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P26.java) **(\*\*) Generate the combinations of K distinct objects chosen from the N elements of a list**

```java
@Test
public void shouldFindAllCombinationsOfSize3FromAListWithSize6() throws Exception {
    List<String> input = Stream.of("a", "b", "c", "d", "e", "f").collect(toList());
    List<List<String>> combinations = P26.combinations(input, 3);
    assertThat(combinations, hasSize(20));
}
```

### [P27](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P27.java) **(\*\*) Group the elements of a set into disjoint subsets**

a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a predicate that generates all the possibilities via backtracking

```java
@Test
public void shouldGroupIntoThreeGroupsOfSize_2_3_and_4() throws Exception {
    List<String> input = Stream.of("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida").collect(toList());
    List<List<List<String>>> groups = P27.group3(input);
    assertThat(groups, hasSize(1260));
}
```

b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.

```java
@Test
public void shouldGroupIntoThreeGroupsOfSize_2_2_and_5() throws Exception {
    List<String> input = Stream.of("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida").collect(toList());
    List<List<List<String>>> groups = P27.group(input, Stream.of(2, 2, 5).collect(Collectors.toList()));
    assertThat(groups, hasSize(756));
}
```

### [P28](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/prologLists/P28.java) **(\*\*) Sorting a list of lists according to length of sublists**

a) We suppose that a list (InList) contains elements that are lists themselves. The objective is to sort the elements of InList according to their **length**. E.g. short lists first, longer lists later, or vice versa.

```java
@Test
public void shouldSortByElementLength() throws Exception {
    List<List<String>> input = Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("d", "e"), Arrays.asList("f", "g", "h"), Arrays.asList("d", "e"), Arrays.asList("i", "j", "k"), Arrays.asList("m", "n"), Arrays.asList("o"));
    List<List<String>> result = P28.lsort(input);
    assertThat(result, is(equalTo(Arrays.asList(Arrays.asList("o"), Arrays.asList("d", "e"), Arrays.asList("d", "e"), Arrays.asList("m", "n"), Arrays.asList("a", "b", "c"), Arrays.asList("f", "g", "h"), Arrays.asList("i", "j", "k")))));
}
```

b) Again, we suppose that a list (InList) contains elements that are lists themselves. But this time the objective is to sort the elements of InList according to their **length frequency**; i.e. in the default, where sorting is done in ascending order, lists with rare lengths are placed first, others with a more frequent length come later.

```java
@Test
public void shouldSortByLengthFrequency() throws Exception {
    List<List<String>> input = Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("d", "e"), Arrays.asList("f", "g", "h"), Arrays.asList("d", "e"), Arrays.asList("i", "j", "k", "l"), Arrays.asList("m", "n"), Arrays.asList("o"));
    List<List<String>> result = P28.lfsort(input);
    assertThat(result, is(equalTo(Arrays.asList(Arrays.asList("i", "j", "k", "l"), Arrays.asList("o"), Arrays.asList("a", "b", "c"), Arrays.asList("f", "g", "h"), Arrays.asList("d", "e"), Arrays.asList("d", "e"), Arrays.asList("m", "n")))));
}
```

## Arithmetic

### [P31](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/arithmetic/P31.java) **(\*\*) Determine whether a given integer number is prime.**

```java
@Test
public void shouldSay7IsAPrimeNumber() throws Exception {
    boolean prime = P31.isPrime(7);
    assertTrue(prime);
}

@Test
public void shouldSay10IsNotAPrimeNumber() throws Exception {
    boolean prime = P31.isPrime(10);
    assertFalse(prime);
}
```

### [P32](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/arithmetic/P32.java) **(\*\*) Determine the prime factors of a given positive integer.**

```java
@Test
public void shouldFindPrimeFactorsOf315() throws Exception {
    List<Integer> primeFactors = P32.primeFactors(315);
    assertThat(primeFactors, hasItems(3, 3, 5, 7));
}

@Test
public void shouldFindPrimeFactorsOf33() throws Exception {
    List<Integer> primeFactors = P32.primeFactors(33);
    assertThat(primeFactors, hasItems(3, 11));
}
```


### [P33](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/arithmetic/P33.java) **(\*\*) Determine the prime factors of a given positive integer (2).**


```java
@Test
public void shouldFindPrimeFactorsOf315() throws Exception {
    List<SimpleEntry<Integer, Integer>> primeFactors = P33.primeFactorsMult(315);
    assertThat(primeFactors, hasItems(new SimpleEntry<>(3, 2), new SimpleEntry<>(5, 1), new SimpleEntry<>(7, 1)));
}

@Test
public void shouldFindPrimeFactorsOf33() throws Exception {
    List<SimpleEntry<Integer, Integer>> primeFactors = P33.primeFactorsMult(33);
    assertThat(primeFactors, hasItems(new SimpleEntry<>(3, 1), new SimpleEntry<>(11, 1)));
}
```

### [P34](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/arithmetic/P34.java) **(*) A list of prime numbers**

```java
import java.util.stream.IntStream;

@Test
public void shouldGiveAllPrimeNumbersBetween2And10() throws Exception {
    List<Integer> primeNumbers = P34.primeNumbers(IntStream.rangeClosed(2, 10));
    assertThat(primeNumbers, hasSize(4));
    assertThat(primeNumbers, hasItems(2, 3, 5, 7));
}

@Test
public void shouldGiveAllPrimeNumbersBetween7And31() throws Exception {
    List<Integer> primeNumbers = P34.primeNumbers(IntStream.rangeClosed(7, 31));
    assertThat(primeNumbers, hasSize(8));
    assertThat(primeNumbers, hasItems(7, 11, 13, 17, 19, 23, 29, 31));
}
```

### [P35](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/arithmetic/P35.java) **(\*\*)  Goldbach's conjecture.**

Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers. Example: `28 = 5 + 23`. It is one of the most famous facts in number theory that has not been proved to be correct in the general case. It has been numerically confirmed up to very large numbers. Write a predicate to find the two prime numbers that sum up to a given even integer.

```java
@Test
public void _8_isthesumof_3_and_5() throws Exception {
    List<Integer> numbers = P35.goldbach(8);
    assertThat(numbers, hasSize(2));
    assertThat(numbers, hasItems(3, 5));
}

@Test
public void _28_isthesumof_5_and_23() throws Exception {
    List<Integer> numbers = P35.goldbach(28);
    assertThat(numbers, hasSize(2));
    assertThat(numbers, hasItems(5, 23));
}
```

### [P36](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/arithmetic/P36.java) **(\*\*)  A list of Goldbach compositions.**

Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach composition.

```java
@Test
public void shouldProduceAListOfGoldbachCompositions() throws Exception {
    List<SimpleEntry<Integer, List<Integer>>> compositions = P36.goldbach_list(IntStream.rangeClosed(9, 20));
    assertThat(compositions, hasSize(6));
    assertThat(compositions, hasItems(
            new SimpleEntry<>(10, Arrays.asList(3, 7)),
            new SimpleEntry<>(12, Arrays.asList(5, 7)),
            new SimpleEntry<>(14, Arrays.asList(3, 11)),
            new SimpleEntry<>(16, Arrays.asList(3, 13)),
            new SimpleEntry<>(18, Arrays.asList(5, 13)),
            new SimpleEntry<>(20, Arrays.asList(3, 17))
    ));
}

@Test
public void shouldProduceAListOfGoldbachCompositionsWhereBothPrimeNumbersAreGreaterThan50() throws Exception {
    List<SimpleEntry<Integer, List<Integer>>> compositions = P36.goldbach_list1(IntStream.rangeClosed(1, 2000), 50);
    assertThat(compositions, hasSize(4));
    assertThat(compositions, hasItems(
            new SimpleEntry<>(992, Arrays.asList(73, 919)),
            new SimpleEntry<>(1382, Arrays.asList(61, 1321)),
            new SimpleEntry<>(1856, Arrays.asList(67, 1789)),
            new SimpleEntry<>(1928, Arrays.asList(61, 1867))
    ));
}
```

### [P37](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/arithmetic/P37.java) **(\*\*)  Determine the greatest common divisor of two positive integer numbers.**

Use Euclid's algorithm.

```java
@Test
public void gcdOf36And63Is9() throws Exception {
    int gcd = P37.gcd(36, 63);
    assertThat(gcd, equalTo(9));
}
```

### [P38](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/arithmetic/P38.java) **(*)  Determine whether two positive integer numbers are coprime.**

Two numbers are coprime if their greatest common divisor equals 1.

```java
@Test
public void shouldSay35And64IsCoprime() throws Exception {
    boolean coprime = P38.coprime(35, 64);
    assertTrue(coprime);
}
```

### [P39](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/arithmetic/P39.java) **(\*\*)  Calculate Euler's totient function phi(m).**

Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r < m) that are coprime to m.

```java
@Test
public void shouldSayPhiOf10Is4() throws Exception {
    long phi = P39.phi(10);
    assertThat(phi, equalTo(4L));
}
```

### [P40](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/arithmetic/P40.java) **(\*\*)  Calculate Euler's totient function phi(m) (2).**

See problem P39 for the definition of Euler's totient function. If the list of the prime factors of a number m is known in the form of problem 2.03 then the function phi(m) can be efficiently calculated as follows: Let `[[p1,m1],[p2,m2],[p3,m3],...]` be the list of prime factors (and their multiplicities) of a given number m. Then phi(m) can be calculated with the following formula:

`phi(m) = (p1 - 1) * p1**(m1 - 1) * (p2 - 1) * p2**(m2 - 1) * (p3 - 1) * p3**(m3 - 1) * ...`

Note that a**b stands for the b'th power of a.


```java
@Test
public void phiOf10Is4() throws Exception {
    int p = P40.phi(10);
    assertThat(p, equalTo(4));
}

@Test
public void phiOf99Is60() throws Exception {
    int p = P40.phi(99);
    assertThat(p, equalTo(60));
}
```

### [P41](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/arithmetic/P41.java) **(*)  Compare the two methods of calculating Euler's totient function.**

Use the solutions of problems P39 and P40 to compare the algorithms. Take the number of logical inferences as a measure for efficiency. Try to calculate `phi(10090)` as an example.

```java
@Test
public void shouldCalculatePhiOf10090UsingP39() throws Exception {
    long p = P39.phi(10090);
    assertThat(p, equalTo(4032L));
}

@Test
public void shouldCalculatePhiOf10090UsingP40() throws Exception {
    long p = P40.phi(10090);
    assertThat(p, equalTo(4032L));
}
```


## logic-and-codes

### [P46](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/LogicAndCodes/P46.java) **(\*\*)  Truth tables for logical expressions.**

Define predicates and/2, or/2, nand/2, nor/2, xor/2, impl/2 and equ/2 (for logical equivalence) which succeed or fail according to the result of their respective operations; e.g. and(A,B) will succeed, if and only if both A and B succeed. Note that A and B can be Prolog goals (not only the constants true and fail).

A logical expression in two variables can then be written in prefix notation, as in the following example: and(or(A,B),nand(A,B)).

Now, write a predicate table/3 which prints the truth table of a given logical expression in two variables.

```java
@Test
public void shouldGenerateTruthTable() throws Exception {
    String table = P46.table((a, b) -> and(a, or(a, b)));
    String result = "A          B          result\n" +
            "true       true       true\n" +
            "true       false      true\n" +
            "false      true       false\n" +
            "false      false      false";

    assertThat(table, is(equalTo(result)));
}
```

### [P47](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/LogicAndCodes/P47.java) **(*)  Truth tables for logical expressions (2).**

Skipping this problem for now.

### [P48](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/LogicAndCodes/P48.java) **(\*\*)  Truth tables for logical expressions (3).**

Skipping this problem for now.


### [P49](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/LogicAndCodes/P49.java) **(\*\*)  Gray code.**

An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,
```
n = 1: C(1) = ['0','1'].
n = 2: C(2) = ['00','01','11','10'].
n = 3: C(3) = ['000','001','011','010','110','111','101','100'].
```
```java
@Test
public void shouldFindGrayCodeWhenNIs1() throws Exception {
    List<String> graySequence = P49.gray(1);
    assertThat(graySequence, contains("0", "1"));
}

@Test
public void shouldFindGrayCodeWhenNIs2() throws Exception {
    List<String> graySequence = P49.gray(2);
    assertThat(graySequence, contains("00", "01", "11", "10"));
}

@Test
public void shouldFindGrayCodeWhenNIs3() throws Exception {
    List<String> graySequence = P49.gray(3);
    assertThat(graySequence, contains("000", "001", "011", "010", "110", "111", "101", "100"));
}
```


### [P50](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/LogicAndCodes/P50.java) **(\*\*\*)  Generate Huffman codes.**
  First of all, study a good book on discrete mathematics or algorithms for a detailed description of Huffman codes, or consult Wikipedia
  We suppose a set of symbols with their frequencies, given as a list of fr(S,F) terms.
  Example: [fr(a,45),fr(b,13),fr(c,12),fr(d,16),fr(e,9),fr(f,5)].
  Our objective is to construct a list hc(S,C) terms, where C is the Huffman code word for the symbol S.
  In our example, the result could be Hs = [hc(a,'0'), hc(b,'101'), hc(c,'100'), hc(d,'111'), hc(e,'1101'), hc(f,'1100')] [hc(a,'01'),...etc.].
  The task shall be performed by the predicate huffman/2 defined as follows:
  ```
  % huffman(Fs,Hs) :- Hs is the Huffman code table for the frequency table Fs
  ```
  
  ```
     *     T        T
     *    |\       / \
     *    T a     a  T
     *    |\        /  \
     *    T T      T   T
     *   /| |\    / \  | \
     *  b c e f  c  b  f  e
  ```
```java
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
```

## binary-trees

![image](https://web.ti.bfh.ch/~hew1/informatik3/prolog/p-99/p67.gif)
A binary tree is either empty or it is composed of a root element and two successors, which are binary trees themselves.  
In Prolog we represent the empty tree by the atom 'nil' and the non-empty tree by the term t(X,L,R), where X denotes the root node and L and R denote the left and right subtree, respectively. 
The example tree depicted opposite is therefore represented by the following Prolog term

```
T1 = t(a,t(b,t(d,nil,nil),t(e,nil,nil)),t(c,nil,t(f,t(g,nil,nil),nil))) 
```

Other examples are a binary tree that consists of a root node only:
```
T2 = t(a,nil,nil) or an empty binary tree: T3 = nil
```
You can check your predicates using these example trees. 


### [P54A](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P54A.java) **(*)  Check whether a given term represents a binary tree.**
```
    @Test
    public void  check_a_given_null_is_a_tree(){
        assertTrue(P54A.isTree(null));
    }

    @Test
    public void check_a_given_term_is_a_tree(){
        assertTrue(P54A.isTree(new BinaryTree("a",
                null,
                new BinaryTree("b",
                        null,
                        new BinaryTree("c",null,null))
                                            )
                            )
                    );
    }
```

### [P55](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P55.java) **(\*\*)  Construct completely balanced binary trees.**

In a completely balanced binary tree, the following property holds for every node: The number of nodes in its left subtree and the number of nodes in its right subtree are almost equal, which means their difference is not greater than one.
Write a function cbal-tree to construct completely balanced binary trees for a given number of nodes. The predicate should generate all solutions via backtracking. Put the letter 'x' as information into all nodes of the tree.
Example:

```
* cbal-tree(4,T).
T = t(x, t(x, nil, nil), t(x, nil, t(x, nil, nil))) ;
T = t(x, t(x, nil, nil), t(x, t(x, nil, nil), nil)) ;
etc......No
```
Example in Haskell, whitespace and "comment diagrams" added for clarity and exposition:

*Main> cbalTree 4
[
-- permutation 1
--     x
--    / \
--   x   x
--        \
--         x
Branch 'x' (Branch 'x' Empty Empty) 
           (Branch 'x' Empty 
                       (Branch 'x' Empty Empty)),
 
-- permutation 2
--     x
--    / \
--   x   x
--      /
--     x
Branch 'x' (Branch 'x' Empty Empty) 
           (Branch 'x' (Branch 'x' Empty Empty) 
                       Empty),
 
-- permutation 3
--     x
--    / \
--   x   x
--    \
--     x
Branch 'x' (Branch 'x' Empty 
                       (Branch 'x' Empty Empty)) 
           (Branch 'x' Empty Empty),
 
-- permutation 4
--     x
--    / \
--   x   x
--  /
-- x
Branch 'x' (Branch 'x' (Branch 'x' Empty Empty) 
                       Empty) 
           (Branch 'x' Empty Empty)
]

### [P56](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P56.java) **(\*\*)  Symmetric binary trees.**

Let us call a binary tree symmetric if you can draw a vertical line through the root node and then the right subtree is the mirror image of the left subtree. Write a predicate symmetric/1 to check whether a given binary tree is symmetric. Hint: Write a predicate mirror/2 first to check whether one tree is the mirror image of another. We are only interested in the structure, not in the contents of the nodes.

Example in Haskell:

*Main> symmetric (Branch 'x' (Branch 'x' Empty Empty) Empty)
False
*Main> symmetric (Branch 'x' (Branch 'x' Empty Empty) (Branch 'x' Empty Empty))
True


### [P57](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P57.java) **(\*\*)  Binary search trees (dictionaries).**

Use the predicate add/3, developed in chapter 4 of the course, to write a predicate to construct a binary search tree from a list of integer numbers.

Example:
```
* construct([3,2,5,7,1],T).
T = t(3, t(2, t(1, nil, nil), nil), t(5, nil, t(7, nil, nil)))
Then use this predicate to test the solution of the problem P56.
```
Example:

* test-symmetric([5,3,18,1,4,12,21]).
Yes
* test-symmetric([3,2,5,7,4]).
No
Example in Haskell:

*Main> construct [3, 2, 5, 7, 1]
Branch 3 (Branch 2 (Branch 1 Empty Empty) Empty) (Branch 5 Empty (Branch 7 Empty Empty))
*Main> symmetric . construct $ [5, 3, 18, 1, 4, 12, 21]
True
*Main> symmetric . construct $ [3, 2, 5, 7, 1]
True



### [P58](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P58.java) **(\*\*)  Generate-and-test paradigm.**

Apply the generate-and-test paradigm to construct all symmetric, completely balanced binary trees with a given number of nodes.

Example:

* sym-cbal-trees(5,Ts).
Ts = [t(x, t(x, nil, t(x, nil, nil)), t(x, t(x, nil, nil), nil)), t(x, t(x, t(x, nil, nil), nil), t(x, nil, t(x, nil, nil)))] 
Example in Haskell:

*Main> symCbalTrees 5
[Branch 'x' (Branch 'x' Empty (Branch 'x' Empty Empty)) (Branch 'x' (Branch 'x' Empty Empty) Empty),Branch 'x' (Branch 'x' (Branch 'x' Empty Empty) Empty) (Branch 'x' Empty (Branch 'x' Empty Empty))]
Solutions


### [P59](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P59.java) **(\*\*)  Construct height-balanced binary trees.**

In a height-balanced binary tree, the following property holds for every node: The height of its left subtree and the height of its right subtree are almost equal, which means their difference is not greater than one.

Construct a list of all height-balanced binary trees with the given element and the given maximum height.

Example:
```
?- hbal_tree(3,T).
T = t(x, t(x, t(x, nil, nil), t(x, nil, nil)), t(x, t(x, nil, nil), t(x, nil, nil))) ;
T = t(x, t(x, t(x, nil, nil), t(x, nil, nil)), t(x, t(x, nil, nil), nil)) ;
etc......No
```
Example in Haskell:

*Main> take 4 $ hbalTree 'x' 3
[Branch 'x' (Branch 'x' Empty Empty) (Branch 'x' Empty (Branch 'x' Empty Empty)),
 Branch 'x' (Branch 'x' Empty Empty) (Branch 'x' (Branch 'x' Empty Empty) Empty),
 Branch 'x' (Branch 'x' Empty Empty) (Branch 'x' (Branch 'x' Empty Empty) (Branch 'x' Empty Empty)),
 Branch 'x' (Branch 'x' Empty (Branch 'x' Empty Empty)) (Branch 'x' Empty Empty)]


### [P60](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P60.java) **(\*\*)  Construct height-balanced binary trees with a given number of nodes.**

Consider a height-balanced binary tree of height H. What is the maximum number of nodes it can contain?

Clearly, MaxN = 2**H - 1. However, what is the minimum number MinN? This question is more difficult. Try to find a recursive statement and turn it into a function minNodes that returns the minimum number of nodes in a height-balanced binary tree of height H. On the other hand, we might ask: what is the maximum height H a height-balanced binary tree with N nodes can have? Write a function maxHeight that computes this.
Now, we can attack the main problem: construct all the height-balanced binary trees with a given number of nodes. Find out how many height-balanced trees exist for N = 15.

Example in Prolog:

?- count_hbal_trees(15,C).
C = 1553
Example in Haskell:

*Main> length $ hbalTreeNodes 'x' 15
1553
*Main> map (hbalTreeNodes 'x') [0..3]
[[Empty],
 [Branch 'x' Empty Empty],
 [Branch 'x' Empty (Branch 'x' Empty Empty),Branch 'x' (Branch 'x' Empty Empty) Empty],
 [Branch 'x' (Branch 'x' Empty Empty) (Branch 'x' Empty Empty)]]

### [P61](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P61.java) **(\*)  Count the leaves of a binary tree.**

A leaf is a node with no successors. Write a predicate count_leaves/2 to count them. 
```
% count_leaves(T,N) :- the binary tree T has N leaves
```

### [P61A](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P60A.java) **(\*)  Collect the leaves of a binary tree in a list.**

A leaf is a node with no successors. Write a predicate leaves/2 to collect them in a list. 
```
% leaves(T,S) :- S is the list of all leaves of the binary tree T
```

### [P62](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P62.java) **(\*)  Collect the internal nodes of a binary tree in a list.**

An internal node of a binary tree has either one or two non-empty successors. Write a predicate internals/2 to collect them in a list. 
```
% internals(T,S) :- S is the list of internal nodes of the binary tree T.
```

### [P62B](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P62B.java) **(\*)  Collect the nodes at a given level in a list.**

A node of a binary tree is at level N if the path from the root to the node has length N-1. The root node is at level 1. Write a predicate atlevel/3 to collect all nodes at a given level in a list. 
```
% atlevel(T,L,S) :- S is the list of nodes of the binary tree T at level L
```

Using atlevel/3 it is easy to construct a predicate levelorder/2 which creates the level-order sequence of the nodes. However, there are more efficient ways to do that.

### [P63](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P63.java) **(\*\*)  Construct a complete binary tree.**

A complete binary tree with height H is defined as follows: The levels 1,2,3,...,H-1 contain the maximum number of nodes (i.e 2**(i-1) at the level i, note that we start counting the levels from 1 at the root). In level H, which may contain less than the maximum possible number of nodes, all the nodes are "left-adjusted". This means that in a levelorder tree traversal all internal nodes come first, the leaves come second, and empty successors (the nil's which are not really nodes!) come last.

Particularly, complete binary trees are used as data structures (or addressing schemes) for heaps.

We can assign an address number to each node in a complete binary tree by enumerating the nodes in levelorder, starting at the root with number 1. In doing so, we realize that for every node X with address A the following property holds: The address of X's left and right successors are 2*A and 2*A+1, respectively, supposed the successors do exist. This fact can be used to elegantly construct a complete binary tree structure. Write a predicate complete_binary_tree/2 with the following specification: 

```
% complete_binary_tree(N,T) :- T is a complete binary tree with N nodes. (+,?)
```

Test your predicate in an appropriate way.

### [P64](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P64.java) **(\*\*)  Layout a binary tree (1).**

![image](https://web.ti.bfh.ch/~hew1/informatik3/prolog/p-99/p64.gif)

Given a binary tree as the usual Prolog term t(X,L,R) (or nil). As a preparation for drawing the tree, a layout algorithm is required to determine the position of each node in a rectangular grid. Several layout methods are conceivable, one of them is shown in the illustration below.

In this layout strategy, the position of a node v is obtained by the following two rules:

x(v) is equal to the position of the node v in the inorder sequence
y(v) is equal to the depth of the node v in the tree


In order to store the position of the nodes, we extend the Prolog term representing a node (and its successors) as follows: 

```
% nil represents the empty tree (as usual)
% t(W,X,Y,L,R) represents a (non-empty) binary tree with root W "positioned" at (X,Y), and subtrees L and R
```

Write a predicate layout_binary_tree/2 with the following specification: 

% layout_binary_tree(T,PT) :- PT is the "positioned" binary tree obtained from the binary tree T. (+,?)

Test your predicate in an appropriate way. 

### [P65](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P65.java) **(\*\*)  Layout a binary tree (2).**

![image](https://web.ti.bfh.ch/~hew1/informatik3/prolog/p-99/p65.gif)


An alternative layout method is depicted in the illustration opposite. Find out the rules and write the corresponding Prolog predicate. Hint: On a given level, the horizontal distance between neighboring nodes is constant.

Use the same conventions as in problem P64 and test your predicate in an appropriate way. 

### [P66](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P66.java) **(\*\*)  Layout a binary tree (3).**

![image](https://web.ti.bfh.ch/~hew1/informatik3/prolog/p-99/p66.gif)

Yet another layout strategy is shown in the illustration opposite. The method yields a very compact layout while maintaining a certain symmetry in every node. Find out the rules and write the corresponding Prolog predicate. Hint: Consider the horizontal distance between a node and its successor nodes. How tight can you pack together two subtrees to construct the combined binary tree?

Use the same conventions as in problem P64 and P65 and test your predicate in an appropriate way. Note: This is a difficult problem. Don't give up too early!

Which layout do you like most? 


### [P67](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P67.java) **(\*\*)  A string representation of binary trees.**

![image](https://web.ti.bfh.ch/~hew1/informatik3/prolog/p-99/p67.gif)

Somebody represents binary trees as strings of the following type (see example opposite):
```
a(b(d,e),c(,f(g,)))
```

a) Write a Prolog predicate which generates this string representation, if the tree is given as usual (as nil or t(X,L,R) term). Then write a predicate which does this inverse; i.e. given the string representation, construct the tree in the usual form. Finally, combine the two predicates in a single predicate tree_string/2 which can be used in both directions.

b) Write the same predicate tree_string/2 using difference lists and a single predicate tree_dlist/2 which does the conversion between a tree and a difference list in both directions.

For simplicity, suppose the information in the nodes is a single letter and there are no spaces in the string. 

### [P68](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P68.java) **(\*\*)  Preorder and inorder sequences of binary trees.**

We consider binary trees with nodes that are identified by single lower-case letters, as in the example of problem P67.

a) Write predicates preorder/2 and inorder/2 that construct the preorder and inorder sequence of a given binary tree, respectively. The results should be atoms, e.g. 'abdecfg' for the preorder sequence of the example in problem P67.

b) Can you use preorder/2 from problem part a) in the reverse direction; i.e. given a preorder sequence, construct a corresponding tree? If not, make the necessary arrangements.

c) If both the preorder sequence and the inorder sequence of the nodes of a binary tree are given, then the tree is determined unambiguously. Write a predicate pre_in_tree/3 that does the job.

d) Solve problems a) to c) using difference lists. Cool! Use the predefined predicate time/1 to compare the solutions.

What happens if the same character appears in more than one node. Try for instance pre_in_tree(aba,baa,T).

### [P69](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P69.java) **(\*\*)  Dotstring representation of binary trees.**

We consider again binary trees with nodes that are identified by single lower-case letters, as in the example of problem P67. Such a tree can be represented by the preorder sequence of its nodes in which dots (.) are inserted where an empty subtree (nil) is encountered during the tree traversal. For example, the tree shown in problem P67 is represented as 'abd..e..c.fg...'. First, try to establish a syntax (BNF or syntax diagrams) and then write a predicate tree_dotstring/2 which does the conversion in both directions. Use difference lists.
Multiway Trees

A multiway tree is composed of a root element and a (possibly empty) set of successors which are multiway trees themselves. A multiway tree is never empty. The set of successor trees is sometimes called a forest. 


In Prolog we represent a multiway tree by a term t(X,F), where X denotes the root node and F denotes the forest of successor trees (a Prolog list). The example tree depicted opposite is therefore represented by the following Prolog term:
T = t(a,[t(f,[t(g,[])]),t(c,[]),t(b,[t(d,[]),t(e,[])])])

### [P70B](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P70B.java) **(\*\*)  Check whether a given term represents a multiway tree.**

![image](https://web.ti.bfh.ch/~hew1/informatik3/prolog/p-99/p70.gif)


Write a predicate istree/1 which succeeds if and only if its argument is a Prolog term representing a multiway tree.
Example:
```
?- istree(t(a,[t(f,[t(g,[])]),t(c,[]),t(b,[t(d,[]),t(e,[])])])).
Yes
```

### [P70C](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P70C.java) **(\*\*)  Count the nodes of a multiway tree.**

Write a predicate nnodes/1 which counts the nodes of a given multiway tree.
Example:
```
?- nnodes(t(a,[t(f,[])]),N).
N = 2
```

Write another version of the predicate that allows for a flow pattern (o,i).

### [P70C](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P70C.java) **(\*\*)  Tree construction from a node string .**

We suppose that the nodes of a multiway tree contain single characters. In the depth-first order sequence of its nodes, a special character ^ has been inserted whenever, during the tree traversal, the move is a backtrack to the previous level.

By this rule, the tree in the figure opposite is represented as: afg^^c^bd^e^^^ 

Define the syntax of the string and write a predicate tree(String,Tree) to construct the Tree when the String is given. Work with atoms (instead of strings). Make your predicate work in both directions. 

### [P71](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P71.java) **(\*)  Determine the internal path length of a tree.**

We define the internal path length of a multiway tree as the total sum of the path lengths from the root to all nodes of the tree. By this definition, the tree in the figure of problem P70 has an internal path length of 9. Write a predicate ipl(Tree,IPL) for the flow pattern (+,-).

### [P72](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P72.java) **(\*)  Construct the bottom-up order sequence of the tree nodes.**

Write a predicate bottom_up(Tree,Seq) which constructs the bottom-up sequence of the nodes of the multiway tree Tree. Seq should be a Prolog list. What happens if you run your predicate backwords?

### [P73](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P73.java) **(\*\*)  Lisp-like tree representation.**

![image](https://web.ti.bfh.ch/~hew1/informatik3/prolog/p-99/p73.png)

There is a particular notation for multiway trees in Lisp. Lisp is a prominent functional programming language, which is used primarily for artificial intelligence problems. As such it is one of the main competitors of Prolog. In Lisp almost everything is a list, just as in Prolog everything is a term. 

The following pictures show how multiway tree structures are represented in Lisp. 
 
Note that in the "lispy" notation a node with successors (children) in the tree is always the first element in a list, followed by its children. The "lispy" representation of a multiway tree is a sequence of atoms and parentheses '(' and ')', which we shall collectively call "tokens". We can represent this sequence of tokens as a Prolog list; e.g. the lispy expression (a (b c)) could be represented as the Prolog list ['(', a, '(', b, c, ')', ')']. Write a predicate tree_ltl(T,LTL) which constructs the "lispy token list" LTL if the tree is given as term T in the usual Prolog notation.

Example:
```
?- tree_ltl(t(a,[t(b,[]),t(c,[])]),LTL).
LTL = ['(', a, '(', b, c, ')', ')']
```

As a second, even more interesting exercise try to rewrite tree_ltl/2 in a way that the inverse conversion is also possible: Given the list LTL, construct the Prolog tree T. Use difference lists.

Graphs

A graph is defined as a set of nodes and a set of edges, where each edge is a pair of nodes.
There are several ways to represent graphs in Prolog. One method is to represent each edge separately as one clause (fact). In this form, the graph depicted below is represented as the following predicate: 
```
edge(h,g).
edge(k,f).
edge(f,b).
...
```
We call this edge-clause form. Obviously, isolated nodes cannot be represented. Another method is to represent the whole graph as one data object. According to the definition of the graph as a pair of two sets (nodes and edges), we may use the following Prolog term to represent the example graph:
```
graph([b,c,d,f,g,h,k],[e(b,c),e(b,f),e(c,f),e(f,k),e(g,h)])
```
We call this graph-term form. Note, that the lists are kept sorted, they are really sets, without duplicated elements. Each edge appears only once in the edge list; i.e. an edge from a node x to another node y is represented as e(x,y), the term e(y,x) is not present. The graph-term form is our default representation. In SWI-Prolog there are predefined predicates to work with sets.
A third representation method is to associate with each node the set of nodes that are adjacent to that node. We call this the adjacency-list form. In our example:
```
[n(b,[c,f]), n(c,[b,f]), n(d,[]), n(f,[b,c,k]), ...]
```
The representations we introduced so far are Prolog terms and therefore well suited for automated processing, but their syntax is not very user-friendly. Typing the terms by hand is cumbersome and error-prone. We can define a more compact and "human-friendly" notation as follows: A graph is represented by a list of atoms and terms of the type X-Y (i.e. functor '-' and arity 2). The atoms stand for isolated nodes, the X-Y terms describe edges. If an X appears as an endpoint of an edge, it is automatically defined as a node. Our example could be written as:
```
[b-c, f-c, g-h, d, f-b, k-f, h-g]
```
We call this the human-friendly form. As the example shows, the list does not have to be sorted and may even contain the same edge multiple times. Notice the isolated node d. (Actually, isolated nodes do not even have to be atoms in the Prolog sense, they can be compound terms, as in d(3.75,blue) instead of d in the example).

When the edges are directed we call them arcs. These are represented by ordered pairs. Such a graph is called directed graph. To represent a directed graph, the forms discussed above are slightly modified. The example graph opposite is represented as follows:

Arc-clause form
```
arc(s,u).
arc(u,r).
...
```
Graph-term form
```
digraph([r,s,t,u,v],[a(s,r),a(s,u),a(u,r),a(u,s),a(v,u)])
```
Adjacency-list form
```
[n(r,[]),n(s,[r,u]),n(t,[]),n(u,[r]),n(v,[u])]
```
Note that the adjacency-list does not have the information on whether it is a graph or a digraph.
Human-friendly form
```
[s > r, t, u > r, s > u, u > s, v > u]
```

Finally, graphs and digraphs may have additional information attached to nodes and edges (arcs). For the nodes, this is no problem, as we can easily replace the single character identifiers with arbitrary compound terms, such as city('London',4711). On the other hand, for edges we have to extend our notation. Graphs with additional information attached to edges are called labelled graphs.


Arc-clause form
```
arc(m,q,7).
arc(p,q,9).
arc(p,m,5).
```
Graph-term form
```
digraph([k,m,p,q],[a(m,p,7),a(p,m,5),a(p,q,9)])
```
Adjacency-list form
```
[n(k,[]),n(m,[q/7]),n(p,[m/5,q/9]),n(q,[])]
```
Notice how the edge information has been packed into a term with functor '/' and arity 2, together with the corresponding node.
Human-friendly form
```
[p>q/9, m>q/7, k, p>m/5]
```

The notation for labelled graphs can also be used for so-called multi-graphs, where more than one edge (or arc) are allowed between two given nodes.

### [P80](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P80.java) **(\*\*\*)  Conversions.**

Write predicates to convert between the different graph representations. With these predicates, all representations are equivalent; i.e. for the following problems you can always pick freely the most convenient form. The reason this problem is rated (***) is not because it's particularly difficult, but because it's a lot of work to deal with all the special cases.


### [P81](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P80.java) **(\*\*)  Path from one node to another one.**

Write a predicate path(G,A,B,P) to find an acyclic path P from node A to node b in the graph G. The predicate should return all paths via backtracking.

### [P82](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P82.java) **(\*)  Cycle from a given node.**

Write a predicate cycle(G,A,P) to find a closed path (cycle) P starting at a given node A in the graph G. The predicate should return all cycles via backtracking.

### [P83](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P83.java) **(\*)  Construct all spanning trees.**

Write a predicate s_tree(Graph,Tree) to construct (by backtracking) all spanning trees of a given graph. With this predicate, find out how many spanning trees there are for the graph depicted to the left. The data of this example graph can be found in the file p83.dat. When you have a correct solution for the s_tree/2 predicate, use it to define two other useful predicates: is_tree(Graph) and is_connected(Graph). Both are five-minutes tasks!


### [P84](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P84.java) **(\*)  Construct the minimal spanning tree.**

Write a predicate ms_tree(Graph,Tree,Sum) to construct the minimal spanning tree of a given labelled graph. Hint: Use the algorithm of Prim. A small modification of the solution of P83 does the trick. The data of the example graph to the right can be found in the file p84.dat.

### [P85](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P84.java) **(\*\*)  Graph isomorphism.**

Two graphs G1(N1,E1) and G2(N2,E2) are isomorphic if there is a bijection f: N1 -> N2 such that for any nodes X,Y of N1, X and Y are adjacent if and only if f(X) and f(Y) are adjacent.
Write a predicate that determines whether two graphs are isomorphic. Hint: Use an open-ended list to represent the function f.

### [P86](https://github.com/www1350/99-problems/blob/master/src/main/java/com/absurd/np/binaryTrees/P86.java) **(\*\*)  Node degree and graph coloration.**

a) Write a predicate degree(Graph,Node,Deg) that determines the degree of a given node.
b) Write a predicate that generates a list of all nodes of a graph sorted according to decreasing degree.

c) Use Welch-Powell's algorithm to paint the nodes of a graph in such a way that adjacent nodes have different colors.

P87 (**) Depth-first order graph traversal (alternative solution)
Write a predicate that generates a depth-first order graph traversal sequence. The starting point should be specified, and the output should be a list of nodes that are reachable from this starting point (in depth-first order).
P88 (**) Connected components (alternative solution)
Write a predicate that splits a graph into its connected components.
P89 (**) Bipartite graphs
Write a predicate that finds out whether a given graph is bipartite.

Miscellaneous Problems

P90 (**) Eight queens problem
This is a classical problem in computer science. The objective is to place eight queens on a chessboard so that no two queens are attacking each other; i.e., no two queens are in the same row, the same column, or on the same diagonal.

Hint: Represent the positions of the queens as a list of numbers 1..N. Example: [4,2,7,3,6,8,5,1] means that the queen in the first column is in row 4, the queen in the second column is in row 2, etc. Use the generate-and-test paradigm.
P91 (**) Knight's tour
Another famous problem is this one: How can a knight jump on an NxN chessboard in such a way that it visits every square exactly once?

Hints: Represent the squares by pairs of their coordinates of the form X/Y, where both X and Y are integers between 1 and N. (Note that '/' is just a convenient functor, not division!) Define the relation jump(N,X/Y,U/V) to express the fact that a knight can jump from X/Y to U/V on a NxN chessboard. And finally, represent the solution of our problem as a list of N*N knight positions (the knight's tour).
P92 (***) Von Koch's conjecture
Several years ago I met a mathematician who was intrigued by a problem for which he didn't know a solution. His name was Von Koch, and I don't know whether the problem has been solved since.
  

Anyway the puzzle goes like this: Given a tree with N nodes (and hence N-1 edges). Find a way to enumerate the nodes from 1 to N and, accordingly, the edges from 1 to N-1 in such a way, that for each edge K the difference of its node numbers equals to K. The conjecture is that this is always possible.

For small trees the problem is easy to solve by hand. However, for larger trees, and 14 is already very large, it is extremely difficult to find a solution. And remember, we don't know for sure whether there is always a solution!

Write a predicate that calculates a numbering scheme for a given tree. What is the solution for the larger tree pictured above?

P93 (***) An arithmetic puzzle
Given a list of integer numbers, find a correct way of inserting arithmetic signs (operators) such that the result is a correct equation. Example: With the list of numbers [2,3,5,7,11] we can form the equations 2-3+5+7 = 11 or 2 = (3*5+7)/11 (and ten others!).
P94 (***) Generate K-regular simple graphs with N nodes
In a K-regular graph all nodes have a degree of K; i.e. the number of edges incident in each node is K. How many (non-isomorphic!) 3-regular graphs with 6 nodes are there? See also a table of results and a Java applet that can represent graphs geometrically.
P95 (**) English number words
On financial documents, like cheques, numbers must sometimes be written in full words. Example: 175 must be written as one-seven-five. Write a predicate full_words/1 to print (non-negative) integer numbers in full words.
P96 (**) Syntax checker (alternative solution with difference lists)
In a certain programming language (Ada) identifiers are defined by the syntax diagram (railroad chart) opposite. Transform the syntax diagram into a system of syntax diagrams which do not contain loops; i.e. which are purely recursive. Using these modified diagrams, write a predicate identifier/1 that can check whether or not a given string is a legal identifier.

% identifier(Str) :- Str is a legal identifier 
P97 (**) Sudoku
Sudoku puzzles go like this:
   Problem statement                 Solution

    .  .  4 | 8  .  . | .  1  7	     9  3  4 | 8  2  5 | 6  1  7	     
            |         |                      |         |
    6  7  . | 9  .  . | .  .  .	     6  7  2 | 9  1  4 | 8  5  3
            |         |                      |         |
    5  .  8 | .  3  . | .  .  4      5  1  8 | 6  3  7 | 9  2  4
    --------+---------+--------      --------+---------+--------
    3  .  . | 7  4  . | 1  .  .      3  2  5 | 7  4  8 | 1  6  9
            |         |                      |         |
    .  6  9 | .  .  . | 7  8  .      4  6  9 | 1  5  3 | 7  8  2
            |         |                      |         |
    .  .  1 | .  6  9 | .  .  5      7  8  1 | 2  6  9 | 4  3  5
    --------+---------+--------      --------+---------+--------
    1  .  . | .  8  . | 3  .  6	     1  9  7 | 5  8  2 | 3  4  6
            |         |                      |         |
    .  .  . | .  .  6 | .  9  1	     8  5  3 | 4  7  6 | 2  9  1
            |         |                      |         |
    2  4  . | .  .  1 | 5  .  .      2  4  6 | 3  9  1 | 5  7  8
   
Every spot in the puzzle belongs to a (horizontal) row and a (vertical) column, as well as to one single 3x3 square (which we call "square" for short). At the beginning, some of the spots carry a single-digit number between 1 and 9. The problem is to fill the missing spots with digits in such a way that every number between 1 and 9 appears exactly once in each row, in each column, and in each square.

P98 (***) Nonograms
Around 1994, a certain kind of puzzles was very popular in England. The "Sunday Telegraph" newspaper wrote: "Nonograms are puzzles from Japan and are currently published each week only in The Sunday Telegraph. Simply use your logic and skill to complete the grid and reveal a picture or diagram." As a Prolog programmer, you are in a better situation: you can have your computer do the work! Just write a little program ;-).
The puzzle goes like this: Essentially, each row and column of a rectangular bitmap is annotated with the respective lengths of its distinct strings of occupied cells. The person who solves the puzzle must complete the bitmap given only these lengths.

          Problem statement:          Solution:

          |_|_|_|_|_|_|_|_| 3         |_|X|X|X|_|_|_|_| 3           
          |_|_|_|_|_|_|_|_| 2 1       |X|X|_|X|_|_|_|_| 2 1         
          |_|_|_|_|_|_|_|_| 3 2       |_|X|X|X|_|_|X|X| 3 2         
          |_|_|_|_|_|_|_|_| 2 2       |_|_|X|X|_|_|X|X| 2 2         
          |_|_|_|_|_|_|_|_| 6         |_|_|X|X|X|X|X|X| 6           
          |_|_|_|_|_|_|_|_| 1 5       |X|_|X|X|X|X|X|_| 1 5         
          |_|_|_|_|_|_|_|_| 6         |X|X|X|X|X|X|_|_| 6           
          |_|_|_|_|_|_|_|_| 1         |_|_|_|_|X|_|_|_| 1           
          |_|_|_|_|_|_|_|_| 2         |_|_|_|X|X|_|_|_| 2           
           1 3 1 7 5 3 4 3             1 3 1 7 5 3 4 3              
           2 1 5 1                     2 1 5 1                      
   
For the example above, the problem can be stated as the two lists [[3],[2,1],[3,2],[2,2],[6],[1,5],[6],[1],[2]] and [[1,2],[3,1],[1,5],[7,1],[5],[3],[4],[3]] which give the "solid" lengths of the rows and columns, top-to-bottom and left-to-right, respectively. Published puzzles are larger than this example, e.g. 25 x 20, and apparently always have unique solutions.
P99 (***) Crossword puzzle
Given an empty (or almost empty) framework of a crossword puzzle and a set of words. The problem is to place the words into the framework.
The particular crossword puzzle is specified in a text file which first lists the words (one word per line) in an arbitrary order. Then, after an empty line, the crossword framework is defined. In this framework specification, an empty character location is represented by a dot (.). In order to make the solution easier, character locations can also contain predefined character values. The puzzle opposite is defined in the file p99a.dat, other examples are p99b.dat and p99d.dat. There is also an example of a puzzle (p99c.dat) which does not have a solution. 

Words are strings (character lists) of at least two characters. A horizontal or vertical sequence of character places in the crossword puzzle framework is called a site. Our problem is to find a compatible way of placing words onto sites. 
Hints: (1) The problem is not easy. You will need some time to thoroughly understand it. So, don't give up too early! And remember that the objective is a clean solution, not just a quick-and-dirty hack!
(2) Reading the data file is a tricky problem for which a solution is provided in the file p99-readfile.pl. Use the predicate read_lines/2.
(3) For efficiency reasons it is important, at least for larger puzzles, to sort the words and the sites in a particular order. For this part of the problem, the solution of P28 may be very helpful.
