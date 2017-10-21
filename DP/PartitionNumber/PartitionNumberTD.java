package DP.PartitionNumber;

public class PartitionNumberTD {
    //memo[i][c]表示索引为[0..i]的这些元素，是否可以完全填充一个容差能为 c 的背包。
    //但是因为还要记录初始化状态，所以设置成整形数组。
    private static int [][] memo;
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i <nums.length; i++) {
            sum += nums[i];
        }
        //首先每个数字的和一定是偶数，如果不是，那直接就返回 false 了
        if (sum%2 != 0){
            return false;
        }
        memo = new int [nums.length][sum/2 +1];

        for (int[] row : memo) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -1;
            }
        }

        return tryPartition(nums, nums.length -1,sum/2);

    }

    /**
     * 使用 nums[0...index],是否可以完全填充填充一个容量为 sum 的背包。
     * @param nums
     * @param index
     * @param capacity
     * @return
     */
    private static boolean tryPartition(int[] nums, int index,int capacity) {

        if(capacity == 0){
        // if(nums[index] == capacity){
            return true;
        }
        if(index < 0 || capacity < 0){
            return false;
        }

        if(memo[index][capacity] == -1){
            boolean result;
            result = tryPartition(nums,index -1,capacity) ||
                    tryPartition(nums, index -1 , capacity - nums[index]);

            memo[index][capacity] = result ? 1:0;
        }

        return memo[index][capacity] == 1;


    }

    public static void main(String[] args) {
        int [] arr = {1, 5, 11, 5};
        int [] arr2 = {1, 2, 3, 5};
        boolean result = canPartition(arr2);
        System.out.println(result);
    }
}
