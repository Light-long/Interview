package com.tx.greedy;

public class LC1217 {

    //  例如给定position=[1,2,3,4,5,6,7,8,9]，我们必然可以通过方式一将其中所有奇数位置的筹码
    // （1,3,5,7,9)移动到位置position[1]，同时能够将其中所有偶数位置的筹码(2,4,6,8)移动到位置position[2]，
    //  这时候position[1]上共有5个筹码，position[2]上共有4个筹码，
    //  其他位置均无筹码。然后利用方式二将position[2]上的4个筹码全部移动到position[1]上，总开销就为4.
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for (int num : position) {
            // 判断奇偶
            if ((num % 2) == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd,even);
    }
}
