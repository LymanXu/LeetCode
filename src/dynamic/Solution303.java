package dynamic;
/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.

Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
class Solution303 {
    private int[] sumRes = null;
    private int[] nums = null;

    public Solution303(int[] nums) {
        this.nums = nums;
        int len = nums.length;
        this.sumRes = new int[nums.length];
        if(len>0){
            sumRes[0] = nums[0];
        }
        for(int i = 1; i < len; i++){
            sumRes[i] = sumRes[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {

        if(i == j){
            return nums[i];
        }
        return sumRes[j] - sumRes[i] + this.nums[i];
    }
}
