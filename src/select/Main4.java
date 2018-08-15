import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main4 {

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String ipMatch(String ip, String[] ipRangeList) {

        for(String temp: ipRangeList){
            String[] detail = temp.split(" ");
            String[] ipAndCidr = detail[0].split("/");
            int cidr = Integer.parseInt(ipAndCidr[1]);
            String[] ipS = ipAndCidr[0].split(".");

        }

        return null;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _ip;
        try {
            _ip = in.nextLine();
        } catch (Exception e) {
            _ip = null;
        }

        List<String> _ipRangeList = new ArrayList<>();

        while (in.hasNextLine()) {
            try {
                String temp = in.nextLine();

                if ("end".equals(temp.trim())) {
                    break;
                }

                _ipRangeList.add(temp);

            } catch (Exception e) {

            }
        }

        res = ipMatch(_ip, _ipRangeList.toArray(new String[_ipRangeList.size()]));
        System.out.println(res);
    }
}