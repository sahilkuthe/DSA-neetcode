public class Search2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            int col = search(matrix[i], target);
            if(col != -1){
                return true;
            }
        }
        return false;

    }
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        if(nums[mid] == target){
            return mid;
        }
        while(start <= end){
            mid = start + (end-start)/2;
            if(target == nums[mid]){
                return mid;
            } else if(target < nums[mid]){
                end = mid-1;

            }else{
                start = mid+1;
            }
        }
        return -1;
    }
}
