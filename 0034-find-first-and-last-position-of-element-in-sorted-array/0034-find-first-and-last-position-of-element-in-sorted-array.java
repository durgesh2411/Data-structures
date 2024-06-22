class Solution {
    // Function to find the first occurrence of the target
    public int fO(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int ans = -1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    ans = mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans; // Return the index of the first occurrence or -1 if not found
    }

    // Function to find the last occurrence of the target
    public int lO(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int ans = -1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    ans = mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans; // Return the index of the last occurrence or -1 if not found
    }

    // Function to find the range of the target (first and last occurrence)
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        int alter_ans[] = {-1, -1};
        
        ans[0] = fO(nums, target);
        if (ans[0] == -1) return alter_ans;
        
        ans[1] = lO(nums, target);
        return ans;
    }
}
