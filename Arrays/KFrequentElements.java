import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class KFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer>[] bucket = new ArrayList[nums.length+1];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] ans = new int[k];
        int pos = 0;

        for(int i= bucket.length-1; i>=0; i--){
            if(bucket[i] != null){
                for (int j=0; j<bucket[i].size() && pos<k ; j++){
                    ans[pos] = bucket[i].get(j);
                    pos++;
                }
            }
        }
        return ans;

    }
}
