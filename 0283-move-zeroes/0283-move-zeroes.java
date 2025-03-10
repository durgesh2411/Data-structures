class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n == 0){
          return;
        }
        if(n==1){
          return; 
        }
        int j = 0;
        for(int i=0;i<n;i++){
                if(nums[i] != 0){
                    nums[j++] = nums[i];
                }
            }
        while(j < n){
            nums[j++] =0;
        }
        }
    }
