package select;

import java.util.*;

public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        HashMap<String,HashMap<String, String>> conf = new HashMap<>();
        String section="";

        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            if(s.length()<3 || s.charAt(0)==';')
                continue;

            if(s.charAt(0) == '['){
                section = s.substring(1, s.length()-1);
                conf.put(section, new HashMap<>());
                continue;
            }
            String[] keyAndValue = s.split("=");
            conf.get(section).put(keyAndValue[0].trim(), keyAndValue[1].trim());

        }

        TreeSet<String>  sectionTree = new TreeSet<>();
        for(String key: conf.keySet()){
            sectionTree.add(key);
        }
        for(String sect: sectionTree){
            TreeSet<String> keyTree = new TreeSet<>();
            HashMap<String,String> temp = conf.get(sect);
            for(String key: temp.keySet()){
                keyTree.add(key);
            }
            for(String key: keyTree){
                System.out.println('{'+sect+'}'+'{'+key+'}'+'{'+temp.get(key)+'}');
            }
        }

    }
}
