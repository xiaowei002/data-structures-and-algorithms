package com.xiaowei.datastruct.recursion;

/**
 * 斐波那契数列
 *
 * @author weiguowei
 */
public class Fibonacci {

    private static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fibonacci(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(0));
    }
}
