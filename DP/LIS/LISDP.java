package DP.LIS;

import java.util.Arrays;

public class LISDP {
    public static int lengthOfLIS(int[] nums) {

        if (nums.length == 0 ){
            return 0;
        }


        int[] memo = new int[nums.length];
        Arrays.fill(memo,1);

        /* 外循环的i是给定数组nums中的角标
           内循环的j是寻找i之前，有没有比i小的数。
        * */
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <i; j++) {
                if (nums[j] < nums[i]) {
                    memo [i] = Math.max(memo [i],memo[j] + 1);
                }
            }
        }

        //在memo数组中遍历一圈，寻找最大值。因为不见得数组中最后一个数就是最大值。
        int max = 0;
        for (int i = 0; i < memo.length; i++) {
            max = Math.max(max,memo[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int [] arr = {1,3,6,7,9,4,10,5,6};
        int result = lengthOfLIS(arr);
        System.out.println(result);
    }

}
