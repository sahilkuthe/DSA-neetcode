package SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length()<t.length()){
            return "";
        }

        //Hashmap to calculate frequency of char of target string
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for(char ch: t.toCharArray()){
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        //HashMap to calculate freq of char in current window
        HashMap<Character, Integer> windowMap = new HashMap<>();

        //two pointerss of the window
        int left = 0, start = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int matchCount = 0;
        while (right < s.length()) {
            char currChar = s.charAt(right);
            windowMap.put(currChar, windowMap.getOrDefault(currChar, 0)+1);

            //check if curr char is in target array and has same frequency
            if(targetMap.containsKey(currChar) && windowMap.get(currChar).intValue() == targetMap.get(currChar).intValue()){
                matchCount++;
            }

            while (matchCount == targetMap.size()) {
                if((right-left+1) <min ){
                    min = right-left+1;

                }
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // If the frequency of leftChar in window is less than in target, reduce matchCount
                if (targetMap.containsKey(leftChar) && 
                    windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    matchCount--;
                }
                left++;
            }
            right++;
        }

        // If minLen was updated, return the substring; otherwise, return ""
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
