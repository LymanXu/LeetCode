package array;

import java.util.Arrays;

/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II

Solution:
依然是关于双指针的运用，先将整个数组翻转过来，然后分别翻转前k个，和后一部分
 */
public class Solution189 {
    public void rotate(int[] nums, int k) {

        // Question 1: 忘记取余，右移数组的长度个单位即原始状态
        while (k > nums.length){
            k %= nums.length;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        int tmp = 0;
        while(start < end){
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
        return;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7};
        Solution189 solu = new Solution189();
        solu.rotate(a, 3);
        System.out.println(Arrays.toString(a));
    }
}
