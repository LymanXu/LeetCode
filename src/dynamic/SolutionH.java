package dynamic;

import java.util.ArrayList;

public class SolutionH {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        if(sum < 3)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> resu = new ArrayList<>();
        ArrayList<Integer> tempResu = null;

        int n = sum/2 + 1;
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            dp[1][i] = dp[1][i - 1] + i;
            if(dp[1][i] == sum){
                tempResu = new ArrayList<>();
                int tmp = 1;
                while(tmp <= i)
                    tempResu.add(tmp++);
                resu.add(tempResu);
            }
        }

        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(j <= i)
                    continue;
                dp[i][j] = dp[i - 1][j] - i + 1;
                if(dp[i][j] == sum){
                    tempResu = new ArrayList<>();
                    int tmp = i;
                    while(tmp <= j)
                        tempResu.add(tmp++);
                    resu.add(tempResu);
                }
            }
        }
        return resu;
    }
}
