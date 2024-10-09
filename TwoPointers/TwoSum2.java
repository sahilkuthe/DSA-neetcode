public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        int[] ans = new int[2];
        while(start < end){
            if((numbers[start] + numbers[end]) > target){
                end--;
            }else if ((numbers[start] + numbers[end]) < target){
                start++;
            }else {
                ans[0] = start;
                ans[1] = end;

            }
        }
        return  ans;

    }
}
