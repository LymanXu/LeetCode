package dynamic;
/*
在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]

 注意事项
你不可以将物品进行切割。

您在真实的面试中是否遇到过这个题？
样例
如果有4个物品[2, 3, 5, 7]

如果背包的大小为11，可以选择[2, 3, 5]装入背包，最多可以装满10的空间。

如果背包的大小为12，可以选择[2, 3, 7]装入背包，最多可以装满12的空间。

函数需要返回最多能装满的空间大小。

Solution:
典型0 1背包问题
 */
public class Lint92 {
    public int backPack(int m, int[] A) {
        int[][] dp = new int[A.length + 1][m + 1];
        for(int i = 0; i < m+1; i++){
            dp[0][i] = 0;
        }
        for(int i =1; i <= A.length; i++){
            for(int j = 0; j <= m; j++){
                dp[i][j] = 0;
                if(j < A[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - A[i-1]] + A[i -1]);
                }
            }
        }
        return dp[A.length][m];
    }
}
