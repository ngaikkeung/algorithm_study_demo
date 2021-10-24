package com.example.demo.classicAlgo;

import com.example.demo.GeneralUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleSortTest {
    private static final int SIZE = 10000;

    /**
     * Bubble sorting implement
     * <p>
     * Average case: O(n^2)
     * Worse case: O(n^2)
     *
     * @param unsortedArray array to sort
     */
    private void bubbleSort(int[] unsortedArray) {
        for (int i = 0; i < unsortedArray.length; i++) {
            // compare the adjacent element, swap if right element is large than left element
            for (int j = 1; j < unsortedArray.length; j++) {
                if (unsortedArray[j - 1] > unsortedArray[j]) {
                    int temp = unsortedArray[j - 1];
                    unsortedArray[j - 1] = unsortedArray[j];
                    unsortedArray[j] = temp;
                }
            }
        }
    }

    @Test
    public void sortRandomIntArray() {
        int[] unsortedArray = GeneralUtils.getRandomIntArray(10, 0, 10);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        bubbleSort(unsortedArray);

        System.out.println("Actual sorted array: " + Arrays.toString(unsortedArray));


        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void sortSameIntArray() {
        int[] unsortedArray = GeneralUtils.getSameIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        bubbleSort(unsortedArray);

        System.out.println("Actual sorted array: " + Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void sortSequentialIntArray() {
        int[] unsortedArray = GeneralUtils.getSequentialIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        bubbleSort(unsortedArray);

        System.out.println("Actual sorted array: " + Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void sortReversedIntArray() {
        int[] unsortedArray = GeneralUtils.getReversedIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        bubbleSort(unsortedArray);

        System.out.println("Actual sorted array: " + Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }
}
