package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SelectionSortTest {
    private static final int SIZE = 10000;

    /**
     * Selection sorting implement
     *
     * @param unsortedArray array to sort
     */
    private void selectionSort(int[] unsortedArray) {
        for (int i = 0; i < unsortedArray.length; i++) {
            int minIndex = i;

            // Compare the rest of the array elements, find the smallest element index
            for (int j = i + 1; j < unsortedArray.length; j++) {
                if (unsortedArray[j] < unsortedArray[minIndex]) {
                    minIndex = j;
                }
            }
            int minValue = unsortedArray[minIndex];
            unsortedArray[minIndex] = unsortedArray[i];
            unsortedArray[i] = minValue;
        }
    }

    @Test
    public void sortRandomIntArray(){
        int[] unsortedArray = GeneralUtils.getRandomIntArray(SIZE, 0, SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        selectionSort(unsortedArray);

        System.out.println("Actual sorted array: " + Arrays.toString(unsortedArray));


        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void sortSameIntArray(){
        int[] unsortedArray = GeneralUtils.getSameIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        selectionSort(unsortedArray);

        System.out.println("Actual sorted array: " + Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void sortSequentialIntArray(){
        int[] unsortedArray = GeneralUtils.getSequentialIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        selectionSort(unsortedArray);

        System.out.println("Actual sorted array: " + Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void sortReversedIntArray(){
        int[] unsortedArray = GeneralUtils.getReversedIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        selectionSort(unsortedArray);

        System.out.println("Actual sorted array: " + Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

}
