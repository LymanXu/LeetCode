package dynamic;

import java.util.List;

/*
给一个整数数组，调整每个数的大小，使得相邻的两个数的差不大于一个给定的整数target，调整每个数的代价为调整前后的差的绝对值，求调整代价之和最小是多少。

 注意事项
你可以假设数组中每个整数都是正整数，且小于等于100。

您在真实的面试中是否遇到过这个题？
样例
对于数组[1, 4, 2, 3]和target=1，最小的调整方案是调整为[2, 3, 2, 3]，调整代价之和是2。返回2。

solution:
动态规划，找出表后，由底向上一层一层在满足约束下计算代价
 */
public class Lint91
{
    public int MinAdjustmentCost(List<Integer> A, int target) {
        if(A.size() < 2){
            return 0;
        }
        int[][] dp = new int[A.size()][101];
        for(int i = 0; i < 101; i++){
            dp[0][i] = Math.abs(A.get(0) - i);
        }
        for(int i = 1; i < A.size(); i++){
            for(int j =0; j < 101; j++){
                dp[i][j] = Integer.MAX_VALUE;
                int diff = Math.abs(j - A.get(i));
                int left = Math.max(j - target, 0);
                int right = Math.min(j + target, 100);
                for(int k = left; k <= right; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + diff);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < 101; i++){
            res = Math.min(res, dp[A.size()-1][i]);
        }
        return res;
    }
}
