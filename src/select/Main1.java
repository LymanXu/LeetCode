package select;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] wen ={-150, 0, 40, 300, 650};
        int[] pin = {-1000, 700, 940, 3000, 7500};

        while(scanner.hasNextInt()){
            int x = scanner.nextInt();
            if(x < -400){
                x = -400;
            }else if(x > 1000){
                x = 1000;
            }
            int index = 0;
            for(int i=0;i < 5; i++){
                if(x > wen[i]){
                    index++;
                }else{
                    break;
                }
            }
            if(index == 0){
                index = 1;
            }

            int k = (pin[index] - pin[index-1])/(wen[index] - wen[index-1]);
            int resu = pin[index-1] + k*(x-wen[index-1]);
            System.out.println(resu);
        }


    }
}
