import java.util.ArrayList;
import java.util.Objects;

public class ProductofArrayExceptSelf {

    //brute force
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int pro = 1;
            for(int j=0; j<nums.length; j++){
                if(i==j)
                    continue;
                pro *= nums[j];

            }
            arr[i] = pro;
        }
        return arr;
    }

    //optimized but will not work if zero is present in array
    public int[] productExceptSelf1(int[] nums) {
        int product = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            product *= nums[i];
        }
        for(int num: nums){
            if(num != 0)
                list.add(product/num);
        }
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return  ans;

    }

    //optimized using prefix product and suffix product
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suff = new int[n];

        pre[0] = 1;
        suff[n-1] = 1;

        for(int i=1; i<n; i++){
            pre[i] = pre[i-1]*nums[i-1];
        }

        for(int i=n-2; i>=0; i--){
            suff[i] = suff[i+1]*nums[i+1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;

    }
}
