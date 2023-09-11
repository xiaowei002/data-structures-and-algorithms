package com.xiaowei.algorithms.recursion;

import java.util.Arrays;

/**
 * @author weiguowei
 * https://leetcode.cn/problems/climbing-stairs/submissions/
 * leetcode 70. 爬楼梯
 */
public class ClimbStairs {

    public static int cacheData(int n){
        //定义数组缓存多路递归的数据
        int[] arr = new int[n+2];
        //填充为-1
        Arrays.fill(arr,-1);
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        return climbStairs(n,arr);
    }

    public static int climbStairs(int n,int[] arr) {
        if(arr[n] != -1){
            return arr[n];
        }

        int x =  climbStairs(n-1,arr);
        int y =  climbStairs(n-2,arr);
        arr[n] = x+y;
        return x+y;
    }

    public static void main(String[] args) {
        System.out.println(cacheData(1));
    }



}
