package array;

import java.util.Arrays;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

Solution:
还是使用双指针，左指针指向从左第一0的位置，右指针指向左指针后第一个非零数的位置
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {

        int len = nums.length;
        int left = 0;
        int right = 0;
        while(left < len && right < len){
            while(left < len && nums[left] != 0){
                left++;
            }
            right = left + 1;
            while (right < len && nums[right] == 0){
                right++;
            }
            if(right < len){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
    }

    public static void main(String[] args){
        int[] a = {0, 1, 0, 3, 12};
        Solution283 solu = new Solution283();
        solu.moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}
