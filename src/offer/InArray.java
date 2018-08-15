package offer;

/*
一个n常数组，元素取值[0, n-1]，找出其中重复的数字
 */
class MyArray {
    private boolean duplicate(int[] numbers, int length,int duplication){
        if(numbers == null || length <= 1){
            return false;
        }
        for(int i = 0; i < length; i++){
            if(numbers[i] < 0 || numbers[i] > length-1){
                return false;
            }
        }

        for(int i = 0; i < length; i++){
            while(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication = numbers[i];
                    return true;
                }
                // swqp numbers
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    // 数组不能被改变
    int getDuplication(int[] numbers, int length){
        MyArray myArray = new MyArray();
        if(numbers == null || length <= 0)
            return  -1;
        int start = 1;
        int end = length - 1;
        while(end >= start){
            int middle = (end - start)>>1 + start;
            int count = myArray.countRange(numbers, length, start, middle);
            if(end == start){
                if(count > 1)
                    return start;
                else
                    break;
            }
            if(count > (middle -start + 1)){
                end = middle;
            }
            else{
                start = middle + 1;
            }
        }
        return -1;
    }
    int countRange(int [] numbers, int length, int start, int end){
        if(numbers == null)
            return 0;
        int count = 0;
        for(int i = 0;i < length; i++){
            if(numbers[i] >= start && numbers[i] <= end)
                count++;
        }
        return count;
    }

    // 3
    boolean find(int[][] matrix, int rows, int columns, int number){
        boolean found = false;
        if(matrix != null && rows > 0 && columns > 0){
            int row = 0;
            int column = columns - 1;
            while(row < rows && column >= 0){
                if(matrix[row][column] == number){
                    found = true;
                    break;
                }else if(matrix[row][column] > number){
                    column--;
                }else{
                    row++;
                }
            }
        }
        return found;
    }

}
