package DP;

public class IntegerBreak {
    public static int integerBreak(int n) {
        return breakInteger(n);
    }

    /**
     *
     * @param n
     * @return
     */
    private static int breakInteger(int n) {
        if(n == 1){
            return 1;
        }

        int result = -1;
        for (int i = 1; i <n ; i++) {
            result = max3(result, i * (n-1),breakInteger(n-i) *i);
        }
        return result;
    }

    private static int max3 (int a, int b, int c){
        return Math.max(a,Math.max(b,c));
    }

    public static void main(String[] args) {
        int result = integerBreak(3);

        System.out.println(result);
    }


}
