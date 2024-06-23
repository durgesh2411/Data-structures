class Solution {
    public int findMin(int[] nums) {
     int low=0;int high=nums.length-1;int ans = Integer.MAX_VALUE;
     while(low<=high){
        int mid = low+(high-low)/2;
        // now we'll check for the sorted side:
        // once sorted side is found then we'll update the ans=nums[low](if arr[low]<min)and eleminate the sorted part.
        
        // if left part is sorted:
        if(nums[low]<=nums[mid]){
            ans = Math.min(ans,nums[low]); //checking n updating the ans with min of(arr[low],ans)
            low = mid+1;                  // eleminate left sorted part
        }
        else{
            ans = Math.min(ans,nums[mid]); //checking n updating the ans with min of(arr[mid]-->(smallest value),ans)
            high = mid-1;                 // eleminating right sorted part
        }
     }
     return ans;   
    }
}