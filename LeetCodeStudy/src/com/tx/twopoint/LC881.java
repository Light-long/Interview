package com.tx.twopoint;

import java.util.Arrays;

public class LC881 {
    public int numRescueBoats(int[] people, int limit) {
        // 给people排序
        Arrays.sort(people);
        // 双指针
        int i = 0;
        int j = people.length-1;
        int result = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i = i+1;
            }
            j = j-1;
            result = result+1;
        }
        return result;
    }
}
