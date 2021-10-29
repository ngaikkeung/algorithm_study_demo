package com.example.demo.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringQuestion {

    /**
     * Question: 1.1
     * Is Unique: Implement an algorithm to determine if a string has all unique characters.
     * What if you cannot use additional data structures?
     * Related: #44, #17, #132
     * <p>
     * Assumption: Characters in string are ASCII not unicode.
     */
    @Test
    public void isUniqueTest() {
        // input
        String expectedUnique = "abcdefghijklmn();'";
        String expectedNotUnique = "1123";

        Assertions.assertTrue(isUnique(expectedUnique));
        Assertions.assertFalse(isUnique(expectedNotUnique));

        Assertions.assertTrue(isUniqueNoAdditionalSpace(expectedUnique));
        Assertions.assertFalse(isUniqueNoAdditionalSpace(expectedNotUnique));
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(1) -> fix size of space for the flag array
     *
     * @param str string to check
     * @return true if string has all unique characters, otherwise false
     */
    private boolean isUnique(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] flag = new boolean[128];

        for (Character cha : str.toCharArray()) {
            if (flag[cha]) {
                return false;
            }

            flag[cha] = true;
        }

        return true;
    }

    /**
     * Time complexity: O(N^2)
     * Space complexity: O(1) -> no additional space
     *
     * @param str string to check
     * @return true if string has all unique characters, otherwise false
     */
    private boolean isUniqueNoAdditionalSpace(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Question: 1.2
     * Check Permutation: Given two strings,write a method to decide if one is a permutation of the
     * other
     * Related: #7, #84, #722, #737
     * <p>
     * Assumption: Case insensitive.
     */
    @Test
    public void isPermutation() {
        String[] permutationStringsA = {"abc", "cba"};
        String[] permutationStringsB = {"AabC", "Baca"};
        String[] permutationStringsC = {"AbCdef", "cbadef"};
        String[] NonPermutationStringsA = {"abcde", "cba"};
        String[] NonPermutationStringsB = {"SDF", "cba"};
        String[] NonPermutationStringsC = {"AbCdef", "cbadefA"};


        Assertions.assertTrue(isPermutation(permutationStringsA[0], permutationStringsA[1]));
        Assertions.assertTrue(isPermutation(permutationStringsB[0], permutationStringsB[1]));
        Assertions.assertTrue(isPermutation(permutationStringsC[0], permutationStringsC[1]));
        Assertions.assertFalse(isPermutation(NonPermutationStringsA[0], NonPermutationStringsA[1]));
        Assertions.assertFalse(isPermutation(NonPermutationStringsB[0], NonPermutationStringsB[1]));
        Assertions.assertFalse(isPermutation(NonPermutationStringsC[0], NonPermutationStringsC[1]));
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(1) -> fix size of space for the counting array
     *
     * @param firstStr  first string to check
     * @param secondStr second string to check
     * @return true if one string is a permutation of the other string, otherwise return false
     */
    private boolean isPermutation(String firstStr, String secondStr) {
        int[] flag = new int[26];
        boolean isPermutation = true;

        firstStr = firstStr.toLowerCase();
        secondStr = secondStr.toLowerCase();

        for (Character c : firstStr.toCharArray()) {
            flag[c - 'a'] = ++flag[c - 'a'];
        }
        for (Character c : secondStr.toCharArray()) {
            flag[c - 'a'] = --flag[c - 'a'];
        }

        for (int count : flag) {
            if (count < 0 || count % 2 == 1) {
                if (!isPermutation) {
                    return false;
                }
                isPermutation = false;
            }
        }

        return isPermutation;
    }
}
