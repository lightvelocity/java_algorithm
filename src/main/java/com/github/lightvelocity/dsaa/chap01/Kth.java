package com.github.lightvelocity.dsaa.chap01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * kth problem
 *
 * @author hzlimaozhi
 */
public class Kth {

    private static int[] randomIntArray(final int N, final int MAX) {
        int[] numbers = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            numbers[i] = random.nextInt(MAX);
        }
        return numbers;
    }

    private static void printIntArray(final int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private static void bubbleSort(int[] numbers, boolean asc) {
        if (asc) {
            for (int i = numbers.length - 1; i >= 1; i--) { // numbers[i] is the max in this turn
                for (int j = 1; j <= i; j++) {
                    if (numbers[j - 1] > numbers[j]) {
                        int k = numbers[j - 1];
                        numbers[j - 1] = numbers[j];
                        numbers[j] = k;
                    }
                }
            }
        } else {
            for (int i = numbers.length - 1; i >= 1; i--) {
                for (int j = 1; j <= i; j++) {
                    if (numbers[j - 1] < numbers[j]) {
                        int k = numbers[j - 1];
                        numbers[j - 1] = numbers[j];
                        numbers[j] = k;
                    }
                }
            }
        }
    }

    private static int kth1(final int[] numbers, final int k) {
        int[] nums = new int[numbers.length];
        System.arraycopy(numbers, 0, nums, 0, numbers.length);

        bubbleSort(nums, false);
        return nums[k - 1];
    }

    private static int kth2(final int[] numbers, final int k) {
        int[] knums = new int[k];
        System.arraycopy(numbers, 0, knums, 0, k);
        bubbleSort(knums, false);

        for (int i = k; i < numbers.length; i++) {
            for (int j = 0; j < k; j++) {
                if (numbers[i] > knums[j]) {
                    System.arraycopy(knums, j, knums, j + 1, k - j - 1);
                    knums[j] = numbers[i];
                    break;
                }
            }
        }

        return knums[k - 1];
    }

    public static void main(String[] args) {
        int n = 10000;

        int[] numbers = randomIntArray(n, n * 100);

        long start = System.currentTimeMillis();
        System.out.println("kth1 k element is " + kth1(numbers, n / 100)
                + ", cost " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println("kth2 k element is " + kth2(numbers, n / 100)
                + ", cost " + (System.currentTimeMillis() - start) + "ms");
    }

}
