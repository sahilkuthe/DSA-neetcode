import java.util.ArrayList;
import java.util.Collections;

public class MedianOfSorted {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        ArrayList<Integer> merged = new ArrayList<>();

        for (int num : nums1) {
            merged.add(num);
        }
        for(int num: nums2){
            merged.add(num);
        }

        Collections.sort(merged);

        int start = 0;
        int end = merged.size()-1;
        if(merged.size() % 2 == 1){
            int mid = start + (end-start)/2;
            return (double)(merged.get(mid));
        }else{
            int mid = start + (end-start)/2;
            return (double) (merged.get(mid) + merged.get(mid + 1)) /2;

        }

    }

    public int bSearch(int[] nums, int target, int start, int end) {

        while(start <= end){
            int mid = start + (end-start)/2;
            if(target < nums[mid]){
                end = mid-1;
            }else if(target > nums[mid]){
                start = mid+1;
            }else{
                return mid;
                //this is
            }
        }
        return -1;
    }
}
