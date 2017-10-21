package DP.KnapSack;

import java.util.Arrays;

public class Knapsack {
    public static int [][] memo;

    public static int knapsack01 (int[] weight, int[] values, int capacity){
        int size = weight.length;
        memo = new int[size][capacity+1];
        for (int[] row : memo) {
            //用int [] 储存一个二维数组中的一维数组。
            Arrays.fill(row,-1);
        }
        return bestValue(weight,values,size -1, capacity);
    }

    private static int bestValue(int[] w, int[] v, int i, int c) {
        if (i < 0 || c <0){
            return 0;
        }

        if (memo[i][c]==-1){
            int value = bestValue(w, v, i-1, c);
            if(w[i]<c){
                value = Math.max(value, v[i]+ bestValue(w,v,i-1,c-w[i]));
            }
            memo [i][c] = value;
        }
        return memo [i][c];
    }

    public static int knacSackDP(int[] weight, int[] values, int capacity){
        int size = weight.length;
        int [][] memory = new int [size][capacity+1];
        //base case 是表格的第一行
        for (int j = 0; j < memory[0].length; j++) {
            if (j >=weight[0]) {
                //j 代表当前的空间大小。当 j>自身物品自身情况的时候才可以放进去。
                memory[0][j]=values[0];
            }
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j < memory[0].length; j++) {
                memory[i][j] = memory[i-1][j];//不考虑第 i 个物品，直接把上一行复制下来。
                if(j >=weight[i]){
                    memory[i][j]=Math.max(memory[i][j],
                            memory[i-1][j-weight[i]]+values[i]);
                    //j-weight[i]]表示当前容量减去自身容差，表示剩余的容量
                }
            }
        }

        //Print THE TABLE

        for (int j = 0; j < memory[0].length; j++) {
            if(memory[0][j]==0){
                System.out.print(0 + "  ");
            }
            else{
                System.out.print(memory[0][j]+" ");
            }

        }
        System.out.println();
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j < memory[0].length; j++) {
                if (memory[i][j]==0){
                    System.out.print(0 + "  ");
                }
                else{
                    System.out.print(memory[i][j]+" ");
                }
            }
            System.out.println();
        }


        return memory[size-1][capacity];//输出右下角的元素
    }

    public static void main(String[] args) {
        int[] weight = new int[]{7,3,4,5};
        int[] value = new int[]{42,12,40,25};
        int capacity = 10;

        int result = knapsack01(weight,value, capacity);
        System.out.println(result);
    }
}
