public class SearchRotatedSorted {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int start = 0;
        int end = nums.length-1;

        if(pivot == -1){    //the array is not rotated so do normal binary search
            return bSearch(nums, target, 0, nums.length - 1);
        }

        //if pivot found => search in the 2 asc sorted arrays
        if(target == nums[pivot]){
            return pivot;
        }
        if(target >= nums[0]){     //LHS
            return bSearch(nums, target, 0, pivot-1);
        }

        return bSearch(nums, target, pivot+1, nums.length-1);



    }

    public int findPivot(int[] nums){
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(mid < high && nums[mid] > nums[mid+1]){
                return mid;
            }
            if(mid > low && nums[mid] < nums[mid-1]){
                return mid;
            }

            if(nums[low] >= nums[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return -1;
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
