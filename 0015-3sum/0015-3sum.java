class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum<0) start++;
                else if(sum > 0) end--;
                else{
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i],nums[start],nums[end]));
                    ans.add(temp);
                    start++;
                    end--;
                    while(start<end && nums[start] == nums[start-1]) start++;
                    while(end>start && nums[end] == nums[end+1]) end--;
                }

            }
        }
        return ans;
        
        // List<List<Integer>> al = new ArrayList<List<Integer>>();
        // List<Integer> ans = new ArrayList<Integer>();
        // int n = nums.length;
        // int sum = 0;
        // for(int i=0;i<n;i++){
        //     int left = nums[i+1];
        //     int right = nums[n-1];
        //     while(left<right){
        //         Arrays.sort(nums);
        //         sum = nums[i]+nums[left]+nums[right];
        //         if(sum<0){
        //             left++;
        //         }
        //         else if(sum>0){
        //             right--;
        //         }
        //         else{
        //             if(nums[right]==nums[right-1]){
        //             ans.add(nums[i]);
        //             ans.add(nums[left]);
        //             ans.add(nums[right]);
        //             }
        //         }
        //         al.add(ans);
        //     }
        //             return al;
        }
    }
