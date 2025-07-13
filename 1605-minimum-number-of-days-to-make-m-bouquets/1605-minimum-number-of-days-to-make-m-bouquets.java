class Solution {
    int n;
    public boolean isValid(int day, int[] bloomDays, int minFInB, int numB){
      int currNumB = 0;
      int adjF = 0;
      for(int i=0;i<n;i++){
        if(bloomDays[i] <= day){
          adjF++;
        }
        else{
            adjF = 0;
        }
        if(adjF == minFInB){
            currNumB++;
            adjF = 0;
        }
      }
      if(currNumB >= numB) return true;
      return false;
    }
    public int minDays(int[] nums, int m, int k) {
    if((long)m*k > nums.length) return -1;
    n = nums.length;
     int low = Integer.MAX_VALUE; int high = 0;
     for(int num : nums){
      high = Math.max(high, num);
      low = Math.min(low, num);
     }
      int ans = -1;
     while(low <= high){
      int mid = low + (high - low)/2;
      if(isValid(mid, nums, k, m)){
        ans = mid;
        high = mid -1;
      }
      else{
        low = mid + 1;
      }
        
     }
     return ans;
    }
}
