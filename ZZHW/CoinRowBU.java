package ZZHW;

public class CoinRowBU {
    public static int solve(int nums[]){
        //这个方法的Base Case和边界太麻烦了。
        // 因为要保证i-2不越界。所以要考虑三种情况：
        // 1. nums[]为空，返回0
        int n = nums.length;
        if (n<1){
            return 0;
        }
        // 2. nums[]只有一个元素，就返回这个元素
        if (n==1){
            return nums[n-1];
        }
        // 3. nums[]有两个元素，返回这两个元素中的最大值。
        int[] memo = new int [n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[1],nums[0]);

        // 动态规划的核心部分其实很简单，但是base case太麻烦了。
        for (int i = 2; i < n ; i ++) {
            memo[i] = Math.max(memo[i-1], nums[i] + memo[i-2]);
        }
        return memo[n-1];
    }


    public static void main(String[] args) {
        int[]test ={2,1};
        int result = solve(test);
        System.out.println(result);
    }

}
