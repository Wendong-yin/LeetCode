package Hash;

import java.util.Arrays;

public class TwoSumSorted {
    public static int[] twoSumSortted(int[]arr, int target){
        int i=0, j = arr.length - 1;


        while (i<j){
            int sum = arr[i]+arr[j];
            if (sum == target){
                return new int[]{i,j};
            }
            else if (sum < target)
            {
                i++;
            }
            else{
                j--;
            }
        }

        throw new IllegalArgumentException("do not exist");
    }

    public static void main(String[] args) {
        int [] arr= {3,4,6,7,8};
        int [] result = TwoSumSorted.twoSumSortted(arr,15   );
        System.out.println(Arrays.toString(result));
    }
}
