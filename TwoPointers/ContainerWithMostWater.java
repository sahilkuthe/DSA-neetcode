public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(left<right){
            int currArea = 1;
            currArea = (right-left)*(Math.min(height[left], height[right]));
            if(currArea>maxArea){
                maxArea = currArea;
            }
            if(height[left] < height[right]){
                left++;
            }else{
                right-- ;
            }
        }
        return maxArea;
    }
}
