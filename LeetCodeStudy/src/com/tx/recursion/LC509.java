package com.tx.recursion;

public class LC509 {
    public int fib(int n) {
        if (n<2) {
            return n==0 ? 0:1;
        }
        return fib(n-1)+fib(n-2);
    }
}
