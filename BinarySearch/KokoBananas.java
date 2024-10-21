public class KokoBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }

        int low = 1;
        int high = max;
        while(low < high){
            int mid = low + (high -low)/2;
            if(check(mid, piles, h)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public boolean check(int mid, int[] piles, int h){
        int ans = 0;
        for (int pile : piles) {
            ans += pile / mid;
            if (pile % mid != 0) {
                ans++;
            }
        }
        return ans <= h;
    }
}
