package array;
/*
Given an array and a value, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 */
public class Solution27 {
    /*
    public int removeElement(int[] nums, int val) {

        int tmp = 0;
        for(int i = 0; i < nums.length; i++){
            tmp += nums[i] == val ? 1: 0;
        }
        return nums.length - tmp;
    }*/

    public int removeElement(int[] nums, int val) {

        // Note : 双指针，充分利用了len--[参考]
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i] == val){
                nums[i--] = nums[len-- - 1];
            }
        }
        return len;
    }
}
