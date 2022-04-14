package com.example.demo.poj;

import java.util.Scanner;

/**
 * A+B Problem
 *
 * Description:
 * Calculate a+b
 *
 * Input
 * Two integer a,b (0<=a,b<=10)
 *
 * Output
 * Output a+b
 *
 * Sample Input
 * 1 2
 *
 * Sample Output
 * 3
 */
public class Question1000 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int sum = cin.nextInt() + cin.nextInt();

        System.out.println(sum);
    }
}
