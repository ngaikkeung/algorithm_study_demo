package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickSortTest {
    private static final int SIZE = 10000;

    /**
     * Quick sorting implement
     * <p>
     * Average case: O(n log n)
     * Worse case: O(n^2)
     * <p>
     * Space complexity: O(log n)
     *
     * @param unsortedArray array to sort
     * @param front         partition front index
     * @param end           partition end index
     */
    private void quickSort(int[] unsortedArray, int front, int end) {
        // keep partition until the partition array only 1 or zero element
        if (front < end) {
            int pivot = partition(unsortedArray, front, end);
            // partition of less than pivot, not include pivot
            quickSort(unsortedArray, front, pivot - 1);
            // partition of large than pivot, not include pivot
            quickSort(unsortedArray, pivot + 1, end);
        }
    }

    private int partition(int[] array, int front, int end) {
        int pivot = array[end];
        int frontSortedIndex = front - 1; // index to indicate the last position of the element is less than pivot

        for (int i = front; i < end; i++) {
            if (array[i] < pivot) {
                // the element is less than pivot, increase index
                frontSortedIndex++;

                // swap the element to left side
                int temp = array[i];
                array[i] = array[frontSortedIndex];
                array[frontSortedIndex] = temp;
            }
        }

        // End of loop through the array, the pivot itself is last index of the element which is less than pivot
        // In the worse case, all of other element are grater than pivot, the frontSortedIndex is -1, it needs to swap the pivot to first element
        frontSortedIndex++;
        array[end] = array[frontSortedIndex];
        array[frontSortedIndex] = pivot;

        return frontSortedIndex;
    }

    @Test
    public void sortRandomIntArray() {
        int[] unsortedArray = GeneralUtils.getRandomIntArray(10, 0, 10);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        quickSort(unsortedArray, 0, unsortedArray.length - 1);

        System.out.println("Actual sorted array: " + Arrays.toString(unsortedArray));


        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void sortSameIntArray() {
        int[] unsortedArray = GeneralUtils.getSameIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        quickSort(unsortedArray, 0, unsortedArray.length - 1);

        System.out.println("Actual sorted array: " + Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void sortSequentialIntArray() {
        int[] unsortedArray = GeneralUtils.getSequentialIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        quickSort(unsortedArray, 0, unsortedArray.length - 1);

        System.out.println("Actual sorted array: " + Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void sortReversedIntArray() {
        int[] unsortedArray = GeneralUtils.getReversedIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        quickSort(unsortedArray, 0, unsortedArray.length - 1);

        System.out.println("Actual sorted array: " + Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }
}
