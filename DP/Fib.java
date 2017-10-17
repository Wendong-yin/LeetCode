package DP;

public class Fib {
    static int count =0; //一算递归调用的次数。
    static long[] memo;

    /**
     *
     * @param n is the Fib number that is going to compute
     * @return return the fib result
     */
    public static long fib (int n){
        memo = new long[n + 1];
        //如果求 fib(5)需要，需要创建 memo[5+1],
        //这样就能够取到 memo[0,1,2,3,4,5] memo[6]是取不到的。
        return fibMemo(n);
    }

    public static long fibMemo (int n){

        count ++;
        if (n == 0 || n == 1){
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }
        //如果 memo 记录 fib 值，直接返回就好了
        //如果没有记录，则需要计算一次。但是每一个 fib 值只计算一次。

        memo[n] = fibMemo(n-1) + fibMemo(n-2);
        return memo[n];
    }

    public static long fib2 (int n){

        long[] arr = new long[n+1];

        arr[0] = 0;
        arr[1] = 1;
        //注意 for 开始的是2，不是0，因为前两个已经计算过了。

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }


    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        long result = fib(3);
        long end = System.currentTimeMillis();
        System.out.println(result + "[" + (end-begin) + " ms]");
        System.out.println("一共运行次:" + count);

        long begin2 = System.currentTimeMillis();
        long result2 = fib2(500);
        long end2 = System.currentTimeMillis();
        System.out.println(result2 + "[" + (end2-begin2) + " ms]");

    }
}
