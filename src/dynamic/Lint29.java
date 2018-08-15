package dynamic;
/*
给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。



您在真实的面试中是否遇到过这个题？
样例
比如 s1 = "aabcc" s2 = "dbbca"

    - 当 s3 = "aadbbcbcac"，返回  true.

    - 当 s3 = "aadbbbaccc"， 返回 false.

Solution:

 */
public class Lint29 {
    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i =1; i <= s2.length(); i++)
            dp[0][i] = dp[0][i - 1] && s3.charAt(i - 1) == s2.charAt(i - 1);
        /* 错误，这只是判断了前s2.length()位
        if(dp[0][s2.length()])
            return true;*/
        for(int i = 1; i <= s1.length(); i++)
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i - 1);
        /*
        if(dp[s1.length()][0])
            return true;*/
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j  - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];

    }
}
