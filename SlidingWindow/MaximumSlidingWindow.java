package SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * MaximumSlidingWindow
 */
public class MaximumSlidingWindow {

    //Brute Force
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     int left = 0;
    //     for(int right=k-1; right<nums.length-k; right++){
    //         int max = Integer.MIN_VALUE;
    //         for(int i=left; i<right; i++){
    //             max = Math.max(max, nums[i]);
    //         }
    //         list.add(max);
    //         left++;
    //     }
    //     int[] ans = new int[list.size()];
    //     for (int i = 0; i < list.size(); i++) {
    //         ans[i] = list.get(i);
    //     }
    //     return ans;
    // }
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] arr = maxSlidingWindow(nums, 3);
        System.out.println(arr.toString());

    }

    public static int[] maxSlidingWindow(int[] nums, int k){
        int n = nums.length;
        if(n == 0 || k == 0){
            return new int[0];
        }

        int[] result = new int[n-k+1];
        Deque<Integer> window = new ArrayDeque<>();     //will store indices

        for(int i=0; i<n; i++){
            //remove indices that are out of bound
            while(window.size() > 0 && window.peekFirst() <= i-k){
                window.pollFirst();     //removes first element of deque
            }

            //remove the indices that have value less than nums[i]
            while (window.size() > 0 && nums[window.peekLast()] < nums[i]) {
                window.pollLast();      
            }

            window.offerLast(i);    //insert i in deque
            if(i >= k-1){
                result[i-k+1] = nums[window.peekFirst()];
            }
        }
        return result;
    }
}