class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n-1;
        int waterT = 0;
        int leftMax = 0, rightMax = 0;

        while(l < r){
            if(height[l] <= height[r]){
                if(height[l] < leftMax){
                    waterT += leftMax - height[l];
                }
                else{
                    leftMax = Math.max(leftMax,height[l]);
                }
                l++;
            }
            else{
                if(height[r] < rightMax){
                    waterT += rightMax - height[r];
                }
                else{
                    rightMax = Math.max(rightMax,height[r]);
                }
                r--;
            }
        }
        return waterT;
    }
}