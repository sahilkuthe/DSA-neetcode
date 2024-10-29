package StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        recurse(ans, 0, 0, "", n);
        return ans;
    }

    public void recurse(List<String> ans, int left, int right, String s, int n){
        if(s.length() == n*2){
            ans.add(s);
            return;
        }

        if(left < n){
            recurse(ans, left+1, right, s + "(", n);
        }

        if(right < left){
            recurse(ans, left, right+1, s + ")", n);
        }
    }
}
