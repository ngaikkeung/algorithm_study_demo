package com.example.demo;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateArrayUtils {

    public static int[] generateRandomIntArray(int arrayLength, int startFrom, int endTo){
        if (arrayLength <= 0 ){
            return new int[0];
        }

        int [] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++){
            array[i] = ThreadLocalRandom.current().nextInt(startFrom, endTo);
        }

        return array;
    }

    public static int[] generateSameIntArray(int arrayLength){
        if (arrayLength <= 0 ){
            return new int[0];
        }

        int [] array = new int[arrayLength];
        Arrays.fill(array, 1);

        return array;
    }
}
