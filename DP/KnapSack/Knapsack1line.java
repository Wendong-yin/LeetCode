package DP.KnapSack;

import java.util.Arrays;

public class Knapsack1line {
    public static int knacSackDP(int[] weight, int[] values, int capacity){
        int size = weight.length;
        int [] memory = new int [capacity+1];
        //int [][] memory = new int [2][capacity+1];
        //变化1：可以从二维数组，变成一维数组了。
        for (int j = 0; j < memory.length; j++) {
            if (j >=weight[0]) {
                // 变化1：给一维数组赋值
                // j 代表当前的空间大小。当 j>自身物品自身情况的时候才可以放进去。
                memory[j]=values[0];
            }
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j =  capacity; j>= weight[i]; j--) {
            //变化3：要从后面向前移动,并且更新循环截止条件
                memory[j] =Math.max(memory[j], memory[j-weight[i]]+values[i]);
                //变化4：更新 memo[j]
            }
        }

        return memory[capacity];//输出右下角的元素
    }

    public static void main(String[] args) {
        int[] weight = new int[]{7,3,4,5};
        int[] value = new int[]{42,12,40,25};
        int capacity = 10;

        int result = knacSackDP(weight,value, capacity);
        System.out.println(result);
    }
}
