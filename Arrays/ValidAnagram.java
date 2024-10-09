import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram("rat", "car"));

    }

//    public static boolean isAnagram(String s, String t) {
//        char[] a1 = s.toCharArray();
//        char[] a2 = t.toCharArray();
//        Arrays.sort(a1);
//        Arrays.sort(a2);
//        return Arrays.equals(a1, a2);
//
//    }

    //optimized
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
