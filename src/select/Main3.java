package select;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLong()){
            long num = scanner.nextLong();

            // 记录0位的位置
            int count = 0;
            boolean[] flag = new boolean[64];
            int index = 0;
            while(num > 0){
                if((num & 1) ==1){
                    flag[index] = true;
                    count++;
                }
                num = num >> 1;
                index++;
            }

            // 计算
            int leftBit = count;
            int result = 0;
            for(int i = 63; i >=0; i--){

                if(flag[i]){
                    result += combination(i, leftBit);
                    leftBit--;
                }
            }
            System.out.println(result);
        }
    }

    public static int combination(int m, int n) {
        if (m < n)
            return 0;
        int k = 1;
        int j = 1;
        for (int i = n; i >= 1; i--) {
            k = k * m;
            j = j * n;
            m--;
            n--;
        }
        return k / j;
    }

}
