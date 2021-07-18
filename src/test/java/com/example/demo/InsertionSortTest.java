package com.example.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;


public class InsertionSortTest {
    private static final int SIZE = 10000;

    /**
     * Insertion sorting implement
     * @param unsortedArray array to sort
     */
    private void insertionSort(int[] unsortedArray){

        for (int i = 0; i < unsortedArray.length; i++){
            int valueToSort = unsortedArray[i];
            int currentIndex = i;

            // Compare the valueToSort to previous every single sorted element until first element
            while (currentIndex > 0 && unsortedArray[currentIndex - 1] > valueToSort){
                // Shift the largest element to right
                unsortedArray[currentIndex] = unsortedArray[currentIndex - 1];

                // Shift the current index to left
                currentIndex--;
            }
            // Swap the valueToSort to new index
            unsortedArray[currentIndex] = valueToSort;
        }
        System.out.println("Actual sorted array: " + Arrays.toString(unsortedArray));
    }

    @Test
    public void sortRandomIntArray(){
        int[] unsortedArray = GeneralUtils.getRandomIntArray(SIZE, 1, 100);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));
        System.out.println("Expected sorted array: " + Arrays.toString(expectedSortedArray));

        insertionSort(unsortedArray);

        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void sortSameIntArray(){
        int[] unsortedArray = GeneralUtils.getSameIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));
        System.out.println("Expected sorted array: " + Arrays.toString(expectedSortedArray));

        insertionSort(unsortedArray);

        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void sortSequentialIntArray(){
        int[] unsortedArray = GeneralUtils.getSequentialIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));
        System.out.println("Expected sorted array: " + Arrays.toString(expectedSortedArray));

        insertionSort(unsortedArray);

        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void sortReversedIntArray(){
        int[] unsortedArray = GeneralUtils.getReversedIntArray(SIZE);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));
        System.out.println("Expected sorted array: " + Arrays.toString(expectedSortedArray));

        insertionSort(unsortedArray);

        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }
}
