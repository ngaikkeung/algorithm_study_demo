package com.example.demo.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringQuestion {

    /**
     * Is Unique: Implement an algorithm to determine if a string has all unique characters.
     * What if you cannot use additional data structures?
     * Hints: #44, #17, #132
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
}
