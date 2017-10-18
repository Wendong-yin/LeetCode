package DP;

import java.util.Arrays;

public class HouseRobber {
    /**
     * memo[i] use to record the largest value we can rob from the index i
     */
    public static int[] memo;


    public static int rob(int[] nums) {
        memo = new int[nums.length+1];
        Arrays.fill(memo,-1);
        //if the given array is [0,0,0,0], which can induce memo array to useless,
        //so I set the default value at -1
        return tryRob(nums, 0);
    }

    /**
     *
     * @param nums nums[ndex,nums.length) is going to be robbed
     * @param index the beginning index of the array
     * @return the largest value we can get from the nums[index, nums.length) aka memo[index]
     */
    private static int tryRob(int[] nums, int index) {
        if (index >= nums.length){
            return 0;
        }

        if (memo[index] == -1){
            int result = 0;
            for (int i = index; i < nums.length; i++) {
                result = Math.max(result,nums[i] + tryRob(nums, i+2));
            }
            memo[index] = result;
        }

        return memo[index];

    }

    public static int robDP(int nums[]){
        int n = nums.length;
        int[] arr = new int [n];
        //arr[i] use to record the largest value we can rob from the index i
        arr[0] = 0;
        arr[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            for (int j = i ; j < n ; j++) {
                arr[i] = Math.max(arr[i], nums[j] + (j+2<n ? arr[j+2]: 0));
                //arr[i] = Math.max(arr[i], nums[j] + arr[i+2]);

            }
        }
        return arr[0];
    }

    public static void main(String[] args) {
        int[]test ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int result = robDP(test);
        System.out.println(result);
    }

}
