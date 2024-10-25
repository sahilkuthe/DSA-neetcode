package SlidingWindow;

import java.util.HashSet;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        int count = 0;
        for(int right = 0; right < s2.length(); right++){
            if (set.contains(s2.charAt(right))) {
                count++;
                if(count == s1.length()){
                    return true;
                }
            }else{
                count = 0;
            }
        }
        return false;
    }
}
