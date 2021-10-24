package com.example.demo.classicAlgo;

import com.example.demo.GeneralUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSortTest {
    private static final int SIZE = 10000;

    /**
     * Merge sorting implement
     * <p>
     * Average case: O(n log n)
     * Worse case: O(n log n)
     * <p>
     * Space complexity: O(n)
     *
     * @param unsortedArray array to sort
     */
    private int[] mergeSort(int[] unsortedArray) {
        // Keep divide into smaller array until 1 element
        if (unsortedArray.length < 2) {
            return unsortedArray;
        }
        int mid = unsortedArray.length / 2;
        int[] leftArray = Arrays.copyOfRange(unsortedArray, 0, mid);
        int[] rightArray = Arrays.copyOfRange(unsortedArray, mid, unsortedArray.length);

        return merge(mergeSort(leftArray), mergeSort(rightArray));
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                result[resultIndex++] = leftArray[leftIndex++];
            } else {
                result[resultIndex++] = rightArray[rightIndex++];
            }
        }

        while (leftIndex < leftArray.length) {
            result[resultIndex++] = leftArray[leftIndex++];
        }
        while (rightIndex < rightArray.length) {
            result[resultIndex++] = rightArray[rightIndex++];
        }
        return result;
    }

    @Test
    public void sortRandomIntArray() {
        int[] unsortedArray = GeneralUtils.getRandomIntArray(10, 0, 10);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        int[] actualSortedArray = mergeSort(unsortedArray);

        System.out.println("Actual sorted array: " + Arrays.toString(actualSortedArray));


        Assertions.assertArrayEquals(expectedSortedArray, actualSortedArray);
    }

    @Test
    public void sortSameIntArray() {
        int[] unsortedArray = GeneralUtils.getSameIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        int[] actualSortedArray = mergeSort(unsortedArray);

        System.out.println("Actual sorted array: " + Arrays.toString(actualSortedArray));

        Assertions.assertArrayEquals(expectedSortedArray, actualSortedArray);
    }

    @Test
    public void sortSequentialIntArray() {
        int[] unsortedArray = GeneralUtils.getSequentialIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        int[] actualSortedArray = mergeSort(unsortedArray);

        System.out.println("Actual sorted array: " + Arrays.toString(actualSortedArray));

        Assertions.assertArrayEquals(expectedSortedArray, actualSortedArray);
    }

    @Test
    public void sortReversedIntArray() {
        int[] unsortedArray = GeneralUtils.getReversedIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        int[] actualSortedArray = mergeSort(unsortedArray);

        System.out.println("Actual sorted array: " + Arrays.toString(actualSortedArray));

        Assertions.assertArrayEquals(expectedSortedArray, actualSortedArray);
    }
}
