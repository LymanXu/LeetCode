package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {

        // Question 1: List<Integer> res = new ArrayList<>(rowIndex + 1)
        // 此时的size依然=0，size指的是存的元素的个数，并不是底层空间
        // 调用add(index, element) set(index, element) raise Exception
        Integer[] oldres = new Integer[rowIndex + 1];
        Integer[] res = new Integer[rowIndex + 1];
        for(int i = 0; i <= rowIndex; i++){
            // cal each row
            res[0] = 1;
            int tmp = i + 1 - 2;
            if(tmp > 0){
                for(int j = 1; j <= tmp; j++){
                    res[j] = oldres[j-1] + oldres[j];
                }
            }
            res[i] = 1;
            oldres = res.clone();
        }
        // Note 1: Arrays.asList()
        return Arrays.asList(res);
    }

    public static void main(String[] args){
        Solution119 solu = new Solution119();
        System.out.println(solu.getRow(1));
        System.out.println(solu.getRow(2));
        System.out.println(solu.getRow(3));
        System.out.println(solu.getRow(4));
    }
}
