class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder b = new StringBuilder(s);
        String t = b.reverse().toString();
        // Now its a Simple LCS Question:
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        //Intialization:
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0) dp[i][j] = 0;
                if(j==0) dp[j][j] = 0;
            }
        }

        // tabulation:
        for(int i=1; i<=n; i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
            
        }
        return dp[n][n];
    }
}
