package Hash;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum1(int[] arr, int target){
        //用static方法就可以不用创造对象，就可以运行这个方法了
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                //注意j=i+1，不是从0开始的。
                // i+1的目的是从他自己后面那个数开始，就不用算自己加自己了
                if (arr[i]+arr[j] == target){
                    return new int[]{i,j};
                    //注意这个返回数组的方法
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum1_2(int[] arr, int target){
        //用static方法就可以不用创造对象，就可以运行这个方法了
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                //另外一种查询的方法
                if (arr[i]+arr[j] == target){
                    return new int[]{j,i};
                    //注意这个返回数组的方法
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum2(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement) && map.get(complement)!=i) {
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum3(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
                //注意这个顺序，不能反，为什么呢？
                //比如第一个6放进的时候，找的是7，7不在，进行下一次循环
                //第二次放7，找6，这时候不用把7放进去，就可以的到结果了
                //所以返回complement(之储存数字)的角标，和现在数字的角标
                //
                //注意return结束了这个整个方法，而不是结束了if判断语句。
            }
            map.put(arr[i],i);//一遍查找，一遍放入到map，逐步扩大map的范围。
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        int[] arr = {6, 7, 3, 8, 4};
        System.out.println(Arrays.toString(twoSum1(arr,13)));
    }
}
