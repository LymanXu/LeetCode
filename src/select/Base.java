package select;

public class Base
{
    // 二分查找
    public int getPos(int[] A, int n, int val){
        if(n <= 0 || A == null) return -1;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(A[mid] == val){
                while(mid - 1 >=0 && A[mid - 1] == val){
                    mid--;
                }
                return mid;
            }
            else if(A[mid] < val){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
