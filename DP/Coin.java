package DP;

import java.util.Arrays;

public class Coin {
    /**
     * memo[i] use to record the largest value we can rob from the index i
     */
    public static int[] memo;


    public static int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        //if the given array is [0,0,0,0], which can induce memo array to useless,
        //so I set the default value at -1
        return tryRob(nums, nums.length-1);
    }

    /**
     *
     * @param nums nums[ndex,nums.length) is going to be robbed
     * @param i the beginning index of the array
     * @return the largest value we can get from the nums[index, nums.length) aka memo[index]
     */
    private static int tryRob(int[] nums, int i) {
        if (i >= nums.length || i<0){
            return 0;
        }
        if (i==0){
            return nums[0];
        }

        if (memo[i] == -1){
            memo[i] = Math.max(nums[i] + tryRob(nums, i-2),tryRob(nums,i-1));
        }

        return memo[i];

    }

    public static int robDP(int nums[]){

        //这个方法的Base Case和边界太麻烦了。
        int n = nums.length;
        if (n<1){
            return 0;
        }
        if (n==1){
            return nums[n-1];
        }

        int[] memory = new int [n];
        memory[0] = nums[0];
        memory[1] = Math.max(nums[1],nums[0]);

        for (int i = 2; i < n ; i ++) {
           memory[i] = Math.max(memory[i-1], nums[i] + memory[i-2]);
        }
        return memory[n-1];//这意味这n一定>=1. 所以还要增加特殊情况
    }



    public static void main(String[] args) {
        int[]test ={2,1};
        int result = robDP(test);
        System.out.println(result);
    }

}
