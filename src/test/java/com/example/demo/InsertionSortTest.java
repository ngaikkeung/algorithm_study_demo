package com.example.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


public class InsertionSortTest {

    @Test
    public void insertionSorting(){
        int[] unsortedArray = generateRandomIntArray(10);
        int[] expectedSortedArray = Arrays.stream(unsortedArray).sorted().toArray();

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));
        System.out.println("Expected sorted array: " + Arrays.toString(expectedSortedArray));

        /*
         * Insertion sorting func
         */
        for (int i = 0; i < unsortedArray.length; i++){
            int valueToSort = unsortedArray[i];
            int currentIndex = i;

            while (currentIndex > 0 && unsortedArray[currentIndex - 1] > valueToSort){
                // Shift the largest element to right
                unsortedArray[currentIndex] = unsortedArray[currentIndex - 1];

                // Shift the current index to left
                currentIndex--;
            }
            unsortedArray[currentIndex] = valueToSort;
        }
        System.out.println("Actual sorted array: " + Arrays.toString(expectedSortedArray));




        Assertions.assertArrayEquals(expectedSortedArray, unsortedArray);
    }




    private int[] generateRandomIntArray(int arrayLength){
        if (arrayLength <= 0 ){
            return new int[0];
        }

        int [] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++){
            array[i] = ThreadLocalRandom.current().nextInt(1, 100);
        }

        return array;
    }
}
