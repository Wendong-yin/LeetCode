package Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KdiffPair {
    public static int Kdiffpair (int[]arr, int k){

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> mapWithDuplicate = new HashSet<>();
        //
        /*根据k是否等于0，分成两种情况：
        第一种k==0，比如{1,1,1,2,2,2}，那么统计的是“重复元素的组数”
        这里就有两组重复元素。可以把出现重复的放在一个set中，然后set.size（）就是答案
        * */

        for (int i = 0; i <arr.length; i++) {
            if(map.containsKey(arr[i])){
                mapWithDuplicate.add(arr[i]);
            }
            else{
                map.put(arr[i],i);
            }

        }
        if(k==0){
            return mapWithDuplicate.size();
        }
        else if(k<0){
            return 0;
        }

         /*第二种就是K>0,这种情况就和two sum很相似，可以套用*/
        int count =0;
//        for (int i = 0; i < arr.length; i++) {
//            if (map.containsKey(arr[i]+dff)&&map.get(arr[i]+dff)!=i){
//                count ++;
//            }
//        }
        //不应该使用for循环，因为重复的数字会出现。
        for (Integer i : map.values()) {
            if (map.containsKey(arr[i]+k)&&map.get(arr[i]+k)!=i){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2};
        int result = Kdiffpair(arr,0);
        System.out.println(result);
    }
}
