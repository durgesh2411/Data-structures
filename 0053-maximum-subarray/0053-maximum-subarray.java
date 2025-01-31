class Solution {
    public int maxSubArray(int[] nums) {


        // int sum = 0;
        // int maxi = Integer.MIN_VALUE;
        // for(int i = 0; i < nums.length; i++ ) {
        //     for(int j = i; j < nums.length; j++) {         // O(n^3)
        //         sum = 0;
        //         for(int k = i; k <= j; k++ ){
        //             sum += nums[k];
        //         }
        //         maxi = Math.max(maxi,sum);
        //     }
        // }
        // return maxi;


        //     int sum = 0;
        // int maxi = Integer.MIN_VALUE;
        // for(int i = 0; i < nums.length; i++ ) {
        //     sum = 0;
        //     for(int j = i; j < nums.length; j++) {            //O(n^2)
        //         sum += nums[j];
        //         maxi = Math.max(maxi,sum);
        //     }
        // }
        // return maxi;

        
        //      int sum = 0;
        // int maxi = Integer.MIN_VALUE;
        // if(nums.length == 1 && nums[0] == -1) {
        //     return -1;
        // }
        // for(int i = 0; i < nums.length; i++ ) {                  //O(n){non all negetive numbers}
        //    sum += nums[i];
        //     if(sum < 0) {
        //         sum = 0;
        //     }
        //     maxi = Math.max(maxi,sum);
        // }
        // return maxi;

    
        int sum = nums[0];
        int maxi = nums[0];

        for(int i = 1;i < nums.length;i++) {
            sum = Math.max(nums[i],sum+nums[i]);
            maxi = Math.max(maxi, sum);
        }
        return maxi;

        
    }
}