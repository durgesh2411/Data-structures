class Solution {
    public int search(int[] nums, int target) {
        // placing the pointer to low and high and intiallizing the ans to -1(as for the possiblity for element is absent)
        int high=nums.length-1;int low=0;int ans=-1;
        //creating thr search space till we high crosses the low value
        while(low<=high){
            //we are checking the mid value to be the target again and again
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                ans = mid;
                return ans;
            }

            // since the intial array was sorted so after the rotation the one half will always be sorted.
            // for the left sorted case:  (checking the 2 possiblity like: if the target is present int sorted part & if not)
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<=nums[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            // for the right sorted case:(checking the same two possiblity)
            else{
                if(target>=nums[mid] && target<=nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return ans;
    }
}