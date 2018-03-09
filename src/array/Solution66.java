package array;
/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
使用一个数组表示一个非负数，然后加一，结果仍用数组存储，高位在list head
You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int b = 1;
        int lnum = 0;

        // Note: 通过本位的商作为上位的加数b
        for(int i=len-1; i>=0 && b>0; i--){
            int tmp = digits[i] + b;
            b = tmp/10;
            lnum = tmp%10;
            digits[i] = lnum;
        }
        if(b>0){
            int [] newDigits = new int[len+1];
            newDigits[0] = b;
            for(int i=0; i<len; i++){
                newDigits[i+1] = digits[i];
            }
            return newDigits;
        }else{
            return digits;
        }
    }

    public static void main(String[] args){

    }
}
