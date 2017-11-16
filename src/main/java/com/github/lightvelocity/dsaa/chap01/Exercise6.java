package com.github.lightvelocity.dsaa.chap01;

/**
 * permutate all letters in string
 *
 * @author hzlimaozhi
 */
public class Exercise6 {

    public static void permute(String str) {
        char[] chars = str.toCharArray();
        permute(chars, 0, chars.length - 1);
    }

    private static void permute1(char[] str, int low, int high) {
        for (int i = low; i <= high; i++) {
            char c = str[i];
            System.out.print(c);
            if (high == low) {
                System.out.println();
            } else {
                char[] chars = new char[high - low]; // one less
                System.arraycopy(str, low, chars, 0, i - low);
                System.arraycopy(str, i + 1, chars, i, high - i);
                permute1(chars, 0, chars.length - 1);
            }
        }
    }

    /**
     * 嵌套循环移位
     * nested loop shift
     */
    private static void permute(char[] str, int low, int high) {
        if (low == high) {
            System.out.println(new String(str));
        } else {
            for (int i = 0; i <= high - low; i++) { // high+1-low turns
                permute(str, low + 1, high);
                loopShift(str, low, high);
            }
        }
    }

    /**
     * 循环移位
     * loop shift
     */
    private static void loopShift(char[] str, int low, int high) {
        char c = str[low];
        System.arraycopy(str, low + 1, str, low, high - low);
        str[high] = c;
    }

    public static void main(String[] args) {
        //permute("abcd");
        System.out.println(Math.log(Long.MAX_VALUE));
    }
}
