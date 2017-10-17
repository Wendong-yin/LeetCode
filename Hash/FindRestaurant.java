package Hash;

import java.util.*;

public class FindRestaurant {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap < String, Integer > map = new HashMap < String, Integer > ();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        List< String > res = new ArrayList < > ();
        int min_sum = Integer.MAX_VALUE, sum;
        for (int j = 0; j < list2.length && j <= min_sum; j++) {
            //两个for循环结束的限制条件：注意第二个，当一个角标已经大于两个数角标的时候，继续查找就没有意义了
            //应该遍历数组寻找hashmap，还是遍历haspmap寻找数组呢？
            //因为数组的查找很费时间，所以应该根据数组的元素，查找key
            if (map.containsKey(list2[j])) {
                sum = j + map.get(list2[j]);
                if (sum < min_sum) {
                    res.clear();//每一步存入之前，都要清空res，最终返回的是res.size(),也就是最后一个数
                    res.add(list2[j]);//这里存入的是餐厅的内容，而不是角标
                    min_sum = sum;
                } else if (sum == min_sum)
                    res.add(list2[j]);
            }
        }
        return res.toArray(new String[res.size()]);//注意这个写法
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};

        String [] result = findRestaurant(list1, list2);
        System.out.println(Arrays.toString(result));
    }
}