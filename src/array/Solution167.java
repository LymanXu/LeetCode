package array;

import java.util.Arrays;

/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2


 */
public class Solution167 {
    // 典型的双指针，头指针+尾指针
    public int[] twoSum(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length - 1;
        int tmp = 0;
        int[] res = new int[2];
        while(start < end){
            tmp = numbers[start] + numbers[end];
            if(tmp == target){
                res[0] = start + 1;
                res[1] = end + 1;
                return res;
            }else if(tmp > target){
                end--;
            }else{
                start++;
            }
        }
        return res;
    }
    /*
    看来暴力法，复杂度为O(n^2)是不行的
    public int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];
        int len = numbers.length;
        for(int i = 0; i < len; i++){
            if(numbers[i] >= target/2 + 1){
                return res;
            }
            for(int j = i + 1; j < len; j++){
                if(numbers[i] + numbers[j] == target){
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }else if(numbers[i] + numbers[j] > target){
                    continue;
                }
            }
        }
        return res;
    }*/

    public static void main(String[] args){
        int[] a = {2, 7, 11, 15};
        Solution167 solu = new Solution167();
        System.out.println(Arrays.toString(solu.twoSum(a, 9)));
    }
}
