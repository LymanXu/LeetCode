package select;

import java.util.Stack;

public class MaxTree {
    public int[] buildMaxTree(int[] A, int n) {

        int res[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++){
            int pos = -1;
            //使队列保持递减（递减的都放进去）,队列中存储索引
            while(!s.empty() && A[s.peek()] < A[i]){
                int t = s.pop();
                // 此时在右边出现大的元素，需要对队列中的元素的父节点进行更新
                if(res[t] == -1 || A[res[t]] > A[i])
                    res[t] = i;
            }
            if(!s.empty())
                pos = s.peek();
            s.push(i);
            res[i] = pos;
        }
        return res;
    }
}
