package com.tx.javase;

public class SelfIncreasing {
    public static void main(String[] args) {
        int i = 1;
        // 先算i++,i=2,i++=1,覆盖，i=1
        i = i++;
        // j = 1,i = 2
        int j = i++;
        // k = 2+3*3,i = 4
        int k = i + ++i * i++;
        // 4
        System.out.println("i="+ i);
        // 1
        System.out.println("j="+ j);
        // 11
        System.out.println("k="+ k);
    }
}
