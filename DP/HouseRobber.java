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
        if (n == 0){
            return 0;
        }
        int[] memory = new int [n];
        //arr[i] use to record the largest value we can rob from the index i
        //memory[0] = nums[0];
        memory[n-1] = nums[n-1];
        // n-1代表最后一个房子，所以当只有一个房子的时候，就会记录这一个房子的值。
        // 但同时有了n-1就需要小心数组越界的问题。所以要考虑特殊情况，提前退出。
        for (int i = n-2; i >=0; i--) {
            //内层循环的原因是根据状态转移方程，寻找每一个状态的最大值
            for (int j = i ; j < n ; j++) {
                if (j+2<n) {//判断「邻居」房子存不存在
                    memory[i] = Math.max(memory[i], nums[j] + memory[j+2]);
                }
                else{
                    memory[i]= Math.max(memory[i], nums[j] + 0);
                }

                //arr[i] = Math.max(arr[i], nums[j] + arr[i+2]);
                //解决DP问题的核心是先解决小问题，再解决大问题，
                //这个问题从左边开始和从右边开始其实是无所谓的，是平级的。
                //如果我们用「正常的逻辑」从左向右看，因为memory[i]的计算要设计[i+2]，
                //这一点和fib数列是相反的。
                //所以我们的小问题是获得先获得最右边的值，然后逐渐获得最左边的值
                // 要从最右边开始取得X，每一个X都需要根据状态转移方程遍历一边，得到小问题的最优值。
            }
        }
        return memory[0];
        //因为X是从🈶️向左开始，所以最左边的端点「覆盖了最大的范围」
    }



    public static void main(String[] args) {
        int[]test ={4,3,2,1};
        int result = robDP(test);
        System.out.println(result);
    }

}
