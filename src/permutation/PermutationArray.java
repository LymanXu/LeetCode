package permutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationArray {

    public static void main(String[] args){
        String[] input = new String[]{"a", "b", "c"};
        boolean[] visit = new boolean[input.length];
        List<String> oneResu = new ArrayList<>();
        getData(input, visit, oneResu);

    }

    public static void getData(String[] input, boolean[] visit, List<String> tempResu){
        if(input == null || input.length == 0)
            return;
        if(input.length == tempResu.size()){
            for(String s: tempResu){
                System.out.print(s);
            }
            System.out.println();
        }
        for(int i = 0; i < input.length; i++){
            if(visit[i])
                continue;
            tempResu.add(input[i]);
            visit[i] = true;
            getData(input, visit, tempResu);
            tempResu.remove(tempResu.size()-1);
            visit[i] = false;
        }
    }
}
