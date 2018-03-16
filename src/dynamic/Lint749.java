package dynamic;
/*
约翰想在他家后面的空地上建一个后花园，现在有两种砖，一种3 dm的高度，7 dm的高度。约翰想围成x dm的墙。如果约翰能做到，输出YES，否则输出NO。

 注意事项
X是一个整数，取值范围为 [3, 1000]。

样例
给出 x = 10，返回YES。

解释：
x = 3 + 7 : 即需要1匹3 dm高度的砖和1匹7 dm 高度的砖。

Solution:
 即完全背包问题的思路，i表示第i中物品，f表示价值
 f[i][w] = max(f[i-1][v], f[i-1][v - k * Wi] + k * Vi]
 */
public class Lint749 {
    public String isBuild(int x) {
        // write you code here
        int[] res = new int[1001];
        for(int i = 0; i <=1000; i++){
            res[i] = 0;
        }
        res[0] = 1;
        for(int i = 3; i <= 1000; i++){
            if(res[i - 3] == 1){
                res[i] = 1;
            }
        }
        for(int i = 7; i <= 1000; i++){
            if(res[i - 7] == 1){
                res[i] = 1;
            }
        }
        return res[x] == 1 ? "YES" : "NO";
    }

    // 使用完全背包，还存在问题，三层循环冗余
    public String isBuild2(int x){
        int n = 2;
        int w = x;
        int[] weight = {0, 3, 7};
        int[] value = {0, 3, 7};
        int f[][] = new int[n+1][w+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= w; j++){
                if(i ==0 || j==0){
                    f[i][j] = 0;
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= w; j++){
                f[i][j] = 0;
                int nCount = j/weight[i];
                for(int k = 0; k <= nCount; k++){
                    f[i][j] = Math.max(f[i-1][j], f[i-1][j-k*weight[i]] + k*value[i]);
                }
            }
        }

        return f[n][w] == x ? "YES" : "NO";
    }
}
