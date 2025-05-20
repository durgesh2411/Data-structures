class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        // Intialization:
        for(int i = 0;i <= n;i++){
            for(int j = 0; j <= m;j++){
                if(j == 0) dp[i][j] = 0;
                if( i == 0) dp[i][j] = 0;
            }
        }
        // Tabulation:
        for(int i = 1;i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){         // (i-1) : qki dp: 1 based Indexing, but strings 0 based indexing hai.
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}