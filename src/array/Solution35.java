package array;

/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1

Solution:
使用二分查找，复杂度log(n)
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length<0){
            return 0;
        }
        return search(nums, 0, nums.length-1, target);
    }

    public int search(int[] nums, int start, int end, int target){
        // Question 1: 对边界确定问题 if(start >=end){
        //导致当剩下两个元素比较时，当左边元素小于target时，start==mid
        //导致下次依然是start，end,无尽的迭代
        if(start + 1 >= end){
            if(nums[start] >= target){
                return start;
            } else if (nums[end] >= target) {
                return end;
            }else{
                return end + 1;
            }
        }
        int mid = (start + end)/2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] > target){
            //Question 2: 别写这种search(nums, start, mid -1, target)
            //导致想不清的边界问题
            return search(nums, start, mid, target);
        }else{
            return search(nums, mid, end, target);
        }
    }

    // 参考答案：
    public int searchInsert2(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }

    public static void main(String[] args){
        Solution35 solu = new Solution35();
        int[] a = {1,3,5,6};
        System.out.println(solu.searchInsert(a, 5));
        System.out.println(solu.searchInsert(a, 2));
        System.out.println(solu.searchInsert(a, 7));
        System.out.println(solu.searchInsert(a, 0));
    }
}
