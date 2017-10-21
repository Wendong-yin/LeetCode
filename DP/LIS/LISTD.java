package DP.LIS;

import java.util.Arrays;

public class LISTD {
    public static int [] memo;
    public int lengthOfLIS(int[] nums) {
        memo= new int[nums.length];
        Arrays.fill(memo, -1);
        return lengthofLIS(nums, nums.length -1);
    }

    private int lengthofLIS(int[] nums, int index) {
        if (memo[index] == -1){
            int max = 0;
            for (int i = 0; i < index; i++) {
                memo[i] = Math.max (memo[i],memo[i-1]+1);
            }

        }

        return 0;



    }

}
