package DP;

public class IntegerBreak {

    private static int[] memo;

    public static int integerBreak(int n) {
        memo = new int[n+1];
        return breakInteger(n);
    }


    private static int breakInteger(int n) {
        if(n == 1){
            return 1;
        }

        if(memo[n] == 0){
            int result = -1;
            for (int i = 1; i <n ; i++) {
                result = max3(result, i * (n-i),breakInteger(n-i) *i);
                /*在以下三个之中比较：以4为例
                1. 把4拆成【1，3】，【2，2】，【3，1】，这两个数的本身的乘机
                2. 【1，3】3代表的是之前的最优解，所以是 1，2，3分别于三种最优解的乘机
                3. 用 result 记录以上几种情况，遍历完完成之后得到4的最优解，放入 memo[4]
                * */
            }
            memo[n] = result;
        }


        return memo[n] ;
    }

    public static int integerBreakDP (int n){
        int [] memo = new int[n+1];

        memo[1] = 1;
        for (int i = 0; i <=n; i++) {
            for (int j = 1; j < i-1; j++) {
                memo[i] = max3(memo[i],j*(i-j),j*memo[i-j]);
            }
        }
        return memo[n];

    }


    private static int max3 (int a, int b, int c){
        return Math.max(a,Math.max(b,c));
    }

    public static void main(String[] args) {
        int result = integerBreakDP(29);

        System.out.println(result);
    }


}
