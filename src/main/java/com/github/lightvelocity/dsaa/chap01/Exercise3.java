package com.github.lightvelocity.dsaa.chap01;

/**
 * print double
 *
 * @author hzlimaozhi
 */
public class Exercise3 {

    // print the integer fraction
    private static void printInteger(long integer) {
        if (integer < 10) {
            System.out.print(integer);
        } else {
            printInteger(integer / 10); // the previous digits
            System.out.print(integer % 10); // the last digit
        }
    }

    // print the decimal fraction
    private static void printDecimal(double decimal) {
        if (decimal > 0) { // don't print the last 0
            decimal *= 10;
            long integer = (long) decimal;
            decimal = decimal - integer;
            System.out.print(integer); // the first digit
            printDecimal(decimal); // the last digits
        }
    }

    private static void printDouble(double num) {
        if (num < 0) {
            System.out.print("-");
            num = -num;
        }

        long integer = (long) num;
        double decimal = num - integer;

        printInteger(integer);
        if (decimal > 0) {
            System.out.print(".");
            printDecimal(decimal);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printDouble(-12345.6789012);
        printDouble(12345.0);
        printDouble(0.6789012);
        printDouble(0.0);
        printDouble(54321);
    }
}
