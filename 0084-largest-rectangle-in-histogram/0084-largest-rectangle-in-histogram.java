class Solution {

    public int[] NSEI(int[] nums){
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nsei = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i] <= nums[st.peek()]) st.pop();
            nsei[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nsei;
        }
    
    public int[] PSEI(int[] nums){
        int m = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] psei = new int[m];
        for(int i=0;i<m;i++){
            while(!st.isEmpty() && nums[i] <= nums[st.peek()]) st.pop();
            psei[i] = st.isEmpty() ? -1 :st.peek();
            st.push(i);
        }
        return psei;
    }
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        if(heights.length == 1 && heights[0] == 0) return 0;
        int n = heights.length;
        int[] psei = PSEI(heights);
        int[] nsei = NSEI(heights);
        int maxi = 0;
        for(int i=0;i<n;i++){
            int maxArea = heights[i]*(nsei[i] - psei[i]-1);
            maxi = Math.max(maxi,maxArea);
        }
        return maxi;
    }
}