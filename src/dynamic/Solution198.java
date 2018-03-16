package dynamic;
/*
198. House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Solution:
动态规划方法，和普通规划方法
 */
public class Solution198 {
    public int rob(int[] nums) {

        if(nums == null || nums.length < 1){
            return 0;
        }
        int len = nums.length;
        int[] moneys = new int[len + 1];
        boolean[] flags = new boolean[len + 1];

        moneys[0] = 0;

        int q = 0;
        for(int j = 1; j <= len; j++){
            if(j == 1){
                q = nums[j - 1];
                flags[j] = true;
            }else{
                if(moneys[j - 1] > moneys[j - 2] + nums[j - 1]){
                    q = moneys[j - 1];
                    flags[j] =false;
                }else{
                    q = moneys[j - 2] + nums[j - 1];
                    flags[j - 1] = false;
                    flags[j] = true;
                }
            }
            moneys[j] = q;

        }
        return moneys[len];
    }
}
