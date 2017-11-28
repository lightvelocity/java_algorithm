package com.github.lightvelocity.dsaa.util;

import java.util.Random;

public class NumberUtil {

    public static int[] ints(final int N) {
        return ints(N, Integer.MAX_VALUE);
    }

    public static int[] ints(final int N, final int MAX) {
        int[] numbers = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            numbers[i] = random.nextInt(MAX);
        }
        return numbers;
    }

    public static void printInts(final int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

}
