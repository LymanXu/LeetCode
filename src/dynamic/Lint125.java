package dynamic;
/*
给出n个物品的体积A[i]和其价值V[i]，将他们装入一个大小为m的背包，最多能装入的总价值有多大？

 注意事项
A[i], V[i], n, m均为整数。你不能将物品进行切分。你所挑选的物品总体积需要小于等于给定的m。

您在真实的面试中是否遇到过这个题？
样例
对于物品体积[2, 3, 5, 7]和对应的价值[1, 5, 2, 4], 假设背包大小为10的话，最大能够装入的价值为9。

Solution:
典型背包问题
 */
public class Lint125 {
    public int backPackII(int m, int[] A, int[] V) {

        int[][] dp = new int[A.length][m + 1];
        for(int i = 0; i <= m; i++){
            if(i >= A[0])
                dp[0][i] = V[0];
        }
        for(int i = 1; i < A.length; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= A[i]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i]] + V[i]);
                }
            }
        }
        return dp[A.length-1][m];
    }
}
