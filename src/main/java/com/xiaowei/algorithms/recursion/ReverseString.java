package com.xiaowei.algorithms.recursion;

/**
 * @author weiguowei
 * 反转字符串
 */
public class ReverseString {

    private static void reverseString(int n,String str){
        if(n == str.length()){
            return;
        }
        reverseString(n+1,str);
        System.out.println(str.charAt(n));
    }

    public static void main(String[] args) {
        reverseString(0,"abcd");
    }
}
