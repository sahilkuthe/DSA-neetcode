package SlidingWindow;

import java.util.HashMap;

/**
 * LongestRepeatingChReplacement
 */
public class LongestRepeatingChReplacement {

    public int characterReplacement(String s, int k) {
        int maxLen = 0, maxFreq = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char currChar = s.charAt(right);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(currChar));

            while(((right-left + 1) - maxFreq) > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left ++;
            }
            maxLen = Math.max(maxLen, (right-left+1));
        }
        return maxLen;
    }
}