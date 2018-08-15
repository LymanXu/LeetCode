package sort;
/*
网上相似参考
https://blog.csdn.net/yuxin6866/article/details/52771739
 */
public class Sort {

    // 插入排序
    public void insertSort(int[] array){
        for(int i = 1, len = array.length; i < len; i++){
            if(array[i] < array[i - 1]){
                int temp = array[i];
                int j = i -1;
                for(; j >= 0 && temp < array[j]; j--){
                    array[j + 1] = array[j];
                }
                array[j + 1] = temp;
            }
        }
    }

    // 最简单的冒泡排序
    public void bubbleSortBase(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j= 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // 冒泡排序，当一趟起泡排序无更改时表明已排序好
    public void bubbleSort(int[] array){
        boolean flag = true;
        int len = array.length;
        while(flag){
            flag = false;
            for(int i = 0; i < len; i++){
                if(array[i] > array[i + 1]){
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    flag = true;
                }
            }
            len--;
        }
    }

    // 快速排序
    public static int partition(int[] array, int left, int right){
        int key = array[left];
        while(left < right){
            while(left < right && array[right] >= key) right--;
            array[left] = array[right];
            while(left < right && array[left] <= key) left++;
            array[right] = array[left];
        }
        array[left] = key;
        return left;
    }
    public void quickSort(int[] array, int left, int right){
        if(left < right){
            int midIndex = Sort.partition(array, left, right);
            quickSort(array, left, midIndex - 1);
            quickSort(array, midIndex + 1, right);
        }

    }

    // 快速排序2
    public void quickSort2(int[] array, int left, int right){
        if(left < right){
            int key = array[left];
            int low = left;
            int high = right;

            while(low < high){
                while(low < high && array[high] >= key) high--;
                array[low] = array[high];
                while(low < high && array[low] <= key) low++;
                array[high] = array[low];
            }
            array[low] = key;
            quickSort2(array, left, low - 1);
            quickSort2(array, low + 1, right);

        }
    }

    // 归并排序
    public void merge(int[] array, int[] result, int low, int middle, int high){
        int i = low, k = low, j = middle + 1;

        for(; i <= middle && j <= high; k++){
            if(array[i] < array[j]){
                result[k] = array[i++];
            }else{
                result[k] = array[j++];
            }
        }
        while(i <= middle)
            result[k++] = array[i++];
        while(j <= high)
            result[k++] = array[j++];
    }

    public void MSort(int[] array, int[] result, int left, int right){
        if(left == right){
            result[left] = array[left];
        }
        else{
            int m = (left + right)/2;
            MSort(array, result, left, m);
            MSort(array, result, m + 1, right);
            this.merge(array, result, left, m, right);
        }
    }

    // 堆排序
    public void heapAdjust(int[] array,int s, int m){
        // array[s..m]中出了array[s]外其他都满足(大顶)堆定义（处理调整array[s]）
        int temp = array[s];
        for(int i = 2 * s; i <= m; i *= 2){
            if(i < m && array[i] < array[i + 1]) i++;
            if(temp > array[i]) break;
            array[s] = array[i];
            s = i;
        }
        array[s] = temp;
    }

    public void heapSort(int[] array){
        // 构建大顶堆,元素存在array[1..array.length -1 ],将array[1..array.length - 1]构造成大顶堆
        for(int i = (array.length -1)/2; i > 0; i--)
            heapAdjust(array, i, array.length);

        // 排序、筛选
        for(int i = array.length - 1; i > 1; i--){
            int temp = array[1];
            array[1] = array[i];
            array[i] = temp;
            heapAdjust(array, 1, i - 1);
        }
    }

    public static void testA(int[] a, int[] b){
        // b[0] = a[0];
        b = a;
    }

    public static void main(String[] args){
        /*int[] a = {1, 2, 3};
        int[] b = new int[3];
        Sort.testA(a, b);
        System.out.println(b[0]);*/

        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
    }
}
