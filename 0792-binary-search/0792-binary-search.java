class Solution {
    public int search(int[] nums, int target) {
       int index = -1;int low=0;int high = nums.length-1;   // firstly setting the Low and High values.
       while(low<=high){                                     // now iterating low and high poiters towards each other
                int mid = high+low/2;
                if(nums[mid]==target){
                    index = mid;
                    return index;
                }

                else if(nums[mid]>target){
                    high = mid-1;
                }

                else{
                    low = mid+1;
                }
       } 
       return index;
    }
}