class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0; int high = nums.length-1;boolean ans = false;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                ans = true;
                return ans;
            }
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                high = high-1;
                low = low+1;
                continue;
            }

            // left sorted part:
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && nums[mid]>=target){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            //right sorted part:
            else{
                if(nums[mid]<=target && nums[high]>=target){
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