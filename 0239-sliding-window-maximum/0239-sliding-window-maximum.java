class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // List<Integer> ans = new ArrayList<>();
        // int n = nums.length;
        // int maxi = 0;
        // for(int i=0;i<n-k+1;i++){
        //     maxi = nums[i];
        //     for(int j=i;j<k+i;i++){
        //         maxi = Math.max(maxi,nums[j]);
        //     }
        //     ans.add(maxi);
        // }
        // int[] res = new int[ans.size()];
        // int i=0;
        // for(int itm : ans){
        //     res[i++] = itm;
        // }
        // return res;

        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();   // used as decreasing monotnic stack
        int ansIdx = 0;
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst() <= (i-k)) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
            dq.offer(i);

            if(i >= k-1) ans[ansIdx++] = nums[dq.peekFirst()];
        }
        return ans;
    }
}