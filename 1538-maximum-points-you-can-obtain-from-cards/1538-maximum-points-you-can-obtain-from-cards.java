class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        // int maxSum=0;         // here we are not considering sum of 1st 4 element i in arr as ans.
        int n = cardPoints.length;
        for(int i = 0; i < k; i ++) {
                leftSum += cardPoints[i];
        }
        int maxSum = leftSum;
        int rightIdx = n-1;
        for(int i = 0; i < k; i++){
            leftSum -= cardPoints[k-1-i];
            rightSum +=  cardPoints[n-1-i];
            maxSum = Math.max(maxSum,leftSum+rightSum);
            
        }
        return maxSum;
    }
}