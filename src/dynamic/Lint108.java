package dynamic;
/*
给定一个字符串s，将s分割成一些子串，使每个子串都是回文。

返回s符合要求的的最少分割次数。

您在真实的面试中是否遇到过这个题？
样例
比如，给出字符串s = "aab"，

返回 1， 因为进行一次分割可以将字符串s分割成["aa","b"]这样两个回文子串

reference: http://blog.csdn.net/jingsuwen1/article/details/51934277
解题思路：动态规划问题。
  dp[i] - 表示子串（0，i）的最小回文切割，则最优解在dp[s.length-1]中。（0,i）的子串中包括了i+1个字符。
 分几种情况：
  1.初始化：当字串s.substring(0,i+1)(包括i位置的字符)是回文时，dp[i] = 0(表示不需要分割)；否则，dp[i] = i（表示至多分割i次）;
  2.对于任意大于1的i，如果s.substring(j,i+1)( 1 =< j <=  i ,即遍历i之前的每个子串)是回文时，dp[i] = min(dp[i], dp[j-1]+1);
   (注：j不用取0是因为若j == 0，则又表示判断（0，i）)。
 */
public class Lint108 {

    public int minCut(String s) {

        if(s == null || s.length() ==0)
            return 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for(int i = 1; i < s.length(); i++){
            dp[i] = isPalind(s, 0, i) ? 0 : i;
            for(int j = i; j >= 1; j--){
                if(isPalind(s, j, i)){
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[s.length() - 1];
    }

    public boolean isPalind(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

}
