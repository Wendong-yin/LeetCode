package binarysearch;

public class FindPeak {
    public static int findPeakElement_Linear (int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            //注意终止的条件是Lenght-1;
            if(nums[i]>nums[i+1]){
                return nums[i];
            }
        }
        return nums.length-1;
        //因为最终返回的是index，如果数组是一直上升，那么返回最后一个数字就好了。
    }

    public static int findPeakElement_Binary(int[] nums){
        return helper(nums,0, nums.length -1 );

    }

    public static int helper(int []nums, int l, int r){
        if (l==r){
            return l;
        }

        int m = (l + r)/2;
        if (nums[m] > nums[m+1])
            return helper(nums, l,m);
            //这里不能直接返回m，因为有可能m-1比m还要大。所以要进一步递归
        else
            return helper(nums, m+1, r);
    }

    public static void main(String[] args) {
        int [] nums = {6,7,3,8,4};
        int result = findPeakElement_Binary( nums);
        System.out.println(result);
    }
}
