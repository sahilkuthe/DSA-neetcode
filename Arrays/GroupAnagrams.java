import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class GroupAnagrams {

    public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            ArrayList<String> innerList = new ArrayList<>();
            for (int j = i; j < strs.length; j++) {
               if(isAnagram(strs[i], strs[j])){
                   innerList.add(strs[i]);
                   innerList.add(strs[j]);
                   list.add(innerList);
               }
            }
            innerList.clear();

        }
        return list;

    }
    public  static boolean isAnagram(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();

        for(char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for(char x : t.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)-1);
        }

        for(int values : map.values()){
            if(values != 0){
                return false;
            }
        }
        return true;
    }
}
