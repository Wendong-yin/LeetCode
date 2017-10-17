package binarysearch;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KElement {
    public static List<Integer> findClosestElements(int[] nums, int k, int x) {
//传入int [] ，需要转化成Integer列表
        List<Integer> arr = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            arr.add(nums[index]);
        }
/*There is no shortcut for converting from int[] to List<Integer>
as Arrays.asList does not deal with boxing and will just create a
List<int[]> which is not what you want. You have to make a utility
 method.*/
        int l = 0, r = arr.size() - k;
        int count =1;
        while (l < r) {
            System.out.println("第"+count+"次循环");

            //因为subList是前闭后开区间，最后一个数字取不到。
            int m = (l + r) / 2;
            System.out.println("此时Windows： " + arr.subList(m, m+k));
            System.out.println("l = " +l + "   arr[l] = "+ arr.get(l));
            System.out.println("r = " +r + "   arr[r] = "+ arr.get(r));
            System.out.println("m = " +m + "   arr[m] = "+ arr.get(m));
            System.out.println("m+k = "+ (m+l) + " arr[m+k] = "+ arr.get(m+k));
            System.out.println("                 x= " +x);
            System.out.println("左边的距离：x - arr.get(m)= " + (x - arr.get(m)));
            System.out.println("右边的距离：arr.get(m+k) - x= " + (arr.get(m+k) - x));

            if (x - arr.get(m) > arr.get(m+k) - x){
                //窗口左端点距离X的距离：x - arr.get(m)
                //窗口右端点距离X的距离：arr.get(m+k) - x
                //当左边的距离>右边的距离时，距离越小，说明越接近x
                //所以要减少左边的距离，x - arr.get(m)，x保持不变，窗口右移

                l = m + 1;
            }

            else
                r = m;

            count++;
            System.out.println("处理后：");
            System.out.println("l = " +l + " arr[l] = "+ arr.get(l));
            System.out.println("r = " +r + " arr[r] = "+ arr.get(r));
            System.out.println("此时数列的范围是： " + arr.subList(l, l+k));
        }
        return arr.subList(l, l + k);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(findClosestElements(arr,4,5).toString());
    }
}
