package dynamic;
/*
给出两个字符串，找到最长公共子序列(LCS)，返回LCS的长度。

您在真实的面试中是否遇到过这个题？
说明
最长公共子序列的定义：

最长公共子序列问题是在一组序列（通常2个）中找到最长公共子序列（注意：不同于子串，LCS不需要是连续的子串）。该问题是典型的计算机科学问题，是文件差异比较程序的基础，在生物信息学中也有所应用。
https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
样例
给出"ABCD" 和 "EDCA"，这个LCS是 "A" (或 D或C)，返回1

给出 "ABCD" 和 "EACB"，这个LCS是"AC"返回 2
 */
public class Lint77 {
    public int longestCommonSubsequence(String A, String B) {

        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];
        int left = 1, lean = 2, top = 3;
        for(int i =1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    path[i][j] = lean;
                }else if(dp[i - 1][j] > dp[i][j - 1]){
                    dp[i][j] = dp[i - 1][j];
                    path[i][j] = left;
                }else{
                    dp[i][j] = dp[i][j - 1];
                    path[i][j] = top;
                }
            }
        }
        return dp[n][m];
    }
}
