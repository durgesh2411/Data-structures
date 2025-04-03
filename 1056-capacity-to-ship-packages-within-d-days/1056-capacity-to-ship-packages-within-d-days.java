class Solution {
    public boolean isPossible(int mid, int[] nums, int days){
       int cnt = 1; int weightSum = 0;
        for(int weight : nums){
            if(weightSum + weight > mid){
                cnt++;
                weightSum = weight;
            }
            else{
                weightSum += weight;
            }
        }
            // if(cnt <= days) return true;
            // return false;
            return cnt <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int weightT = 0; int maxi = 0;
        for(int weight : weights){ 
            weightT += weight;
            maxi = Math.max(maxi,weight);
        }

        int low = maxi;
        int high = weightT;
        while(low < high){               // l<h : hamee vo el choose karna h(jub l == h) na ki cross kare!!
            int mid = low + (high - low)/2;
            if(isPossible(mid, weights, days)) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}