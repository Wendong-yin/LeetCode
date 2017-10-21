package DP.PartitionNumber;

public class PartitionNumberBU {
    //memo[i][c]表示索引为[0..i]的这些元素，是否可以完全填充一个容差能为 c 的背包。
    //但是因为还要记录初始化状态，所以设置成整形数组。

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i <nums.length; i++) {
            sum += nums[i];
        }
        //首先每个数字的和一定是偶数，如果不是，那直接就返回 false 了
        if (sum%2 != 0){
            return false;
        }

        int capacity = sum/2;

        boolean[] memo = new boolean[capacity+1];

        for (int i = 0; i <=capacity ; i++) {
            memo[i] = (nums[0]==i);//i是当前的 capacity
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = capacity; j>=nums[i]; j-- ) {
                memo[j] = memo[j] || memo[j-nums[i]];
            }

        }
        return memo[capacity];
    }


    public static void main(String[] args) {
        int [] arr = {1, 5, 11, 5};
        int [] arr2 = {1, 2, 3, 5};
        boolean result = canPartition(arr);
        System.out.println(result);
    }
}
