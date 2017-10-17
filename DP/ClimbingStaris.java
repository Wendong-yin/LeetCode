package DP;

public class ClimbingStaris {

    public static int climbStarisBasic (int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }

        return climbStaris(n-1)+ climbStaris(n-2);
    }
    public static int[] memo;

    public static int climbStaris (int n){
        memo = new int[n+1];
        return climbMemo(n);
    }

    public static int climbMemo(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (memo[n] == 0){
            memo[n] = climbMemo(n-1) + climbMemo(n-2);
            //memo[n] = climbMemo(memo[n-1]) + climbMemo(memo[n-2]);
        }
        return memo[n];
    }

    public static int climbStaris_DP (int n){
        int [] arr = new int [n+1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <=n ; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int result = climbStaris_DP(5);
        System.out.println(result);
    }

}
