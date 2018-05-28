package com.github.lightvelocity.dsaa.chap02;

import com.github.lightvelocity.dsaa.util.NumberUtil;

import java.util.Random;

/**
 * 最大子序列和
 *
 * @author hzlimaozhi
 */
public class MaxSubsequenceSum {

    private static int[] randomInts(final int n) {
        int[] ints = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            ints[i] = (random.nextBoolean() ? 1 : -1) *
                    random.nextInt(Integer.MAX_VALUE >> 10);
        }
        return ints;
    }

    /**
     * stupid solution
     */
    private static void solution0(int[] ints) {
        long now = System.currentTimeMillis();
        long max = Long.MIN_VALUE;
        int start = 0, end = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = i; j < ints.length; j++) {
                long sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += ints[k];
                }
                if (sum > max) {
                    max = sum;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println("[" + start + ", " + end + "] = " + max
                + ", cost " + (System.currentTimeMillis() - now) + "ms");
    }

    /**
     * the simplest, the worst
     */
    private static void solution1(int[] ints) {
        long now = System.currentTimeMillis();
        long max = Long.MIN_VALUE, sum;
        int start = 0, end = 0;
        for (int i = 0; i < ints.length; i++) {
            sum = 0;
            for (int j = i; j < ints.length; j++) {
                sum += ints[j];
                if (sum >= max) { // 等于，则子序列长度更短
                    max = sum;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println("[" + start + ", " + end + "] = " + max
                + ", cost " + (System.currentTimeMillis() - now) + "ms");
    }

    private static void solution2(int[] ints) {

    }
    private static void maxSumRecursion(int[] ints, int start, int end) {

    }

    private static void solution3(int[] nums) {
        long now = System.currentTimeMillis();

        long max = Long.MIN_VALUE, sum = 0;
        int start = 0, end = 0; // 结果子序列的起始位置
        boolean started = false; // 结果子序列是否已开始

        // 数学归纳法证明算法的正确性：在已遍历的序列中，nums[start,end]是子序列和最大的。
        // 0.初始，nums[0,0]中，nums[0,0]是最大的
        // 1.前提，nums[start,end]是nums[0,i-1]中最大的子序列
        //   如果，nums[start,i-1] + nums[i] >  nums[start,i-1]，则新的子序列为nums[start,i]；
        //   如果，nums[start,i-1] + nums[i] <= nums[start,i-1]
        //       如果，nums[start,i-1] + nums[i] < 0
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > max) {
                if (!started) {
                    started = true;
                    start = i;
                }
                end = i;
                max = sum;
            } else if (sum < 0) {
                // 在
                // 若还有元素，则ints[i+1]比ints[start,end]要大
                // 若没有元素，则
                sum = 0;
                started = false;
            }
        }
        System.out.println("[" + start + ", " + end + "] = " + max
                + ", cost " + (System.currentTimeMillis() - now) + "ms");
    }

    public static void main(String[] args) {
        //int[] ints = randomInts(100000);
        int[] ints = {1, 2, 3, -10, -10, 4, 5, 6};
        //NumberUtil.printInts(ints);
        //solution0(ints);
        solution1(ints);
        solution3(ints);
    }
}
