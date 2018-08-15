package select;

import java.util.HashSet;
import java.util.Scanner;
import java.lang.Math;
public class Main{
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            TreeSet<Integer> tree = new TreeSet<Integer>();
            while(num > 0){
                tree.add(num%10);
                num /= 10;
            }
            int resu = 0;
            int count = 0;
            for(Integer temp: tree){
                resu += temp * Math.pow(10, count);
                count++;
            }
            System.out.println(resu);
        }*/
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            String s = String.valueOf(num);
            int resu = 0;
            int count = 0;
            HashSet<Integer> set = new HashSet<Integer>();

            for (int i = 0; i < s.length(); i++) {
                int temp = s.charAt(i) - '0';
                if (!set.contains(temp)) {
                    resu += temp * Math.pow(10, count);
                    count++;
                    set.add(temp);
                }
            }
            System.out.println(resu);
        }
    }
}