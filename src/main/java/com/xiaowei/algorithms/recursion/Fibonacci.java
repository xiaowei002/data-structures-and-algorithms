package com.xiaowei.algorithms.recursion;

import java.util.Arrays;

/**
 * 斐波那契数列
 *
 * @author weiguowei
 */
public class Fibonacci {

    private static int fibonacci(int n, int[] arr) {
        if (arr[n] != -1) {
            return arr[n];
        }
        int x = fibonacci(n - 1, arr);
        int y = fibonacci(n - 2, arr);
        arr[n - 1] = x;
        arr[n - 2] = y;
        return x + y;
    }

    private static int cache(int n) {
        int[] cache = new int[n + 2];
        Arrays.fill(cache, -1);
        cache[0] = 1;
        cache[1] = 1;
        return fibonacci(n, cache);
    }

    public static void main(String[] args) {
        System.out.println(cache(5));
    }
}
