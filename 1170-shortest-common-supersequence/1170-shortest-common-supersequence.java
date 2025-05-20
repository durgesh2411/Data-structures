

class Solution {

    //longest common Subsequence:
    public int func(String str1, String str2, int n, int m ,int[][] dp){
        if(n == 0 || m == 0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        if(str1.charAt(n-1) == str2.charAt(m-1))
            return dp[n][m] = 1 + func(str1, str2, n-1, m-1,dp);
        else {
            return dp[n][m] = Math.max(func(str1, str2, n-1, m, dp), func(str1, str2, n, m-1, dp));
        }
            
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int totalLen = n+m;
        int[][]dp = new int[n+1][m+1];
        // for(int[] row : dp) Arrays.fill(row,-1);
        // func(str1,str2,n, m, dp);
        for(int i = 0; i<=n; i++){
            for(int j=0;j<=m;j++){
                if(i==0) dp[i][j] = 0;
                if(j==0) dp[i][j] = 0;
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        int i = n, j = m;
        StringBuilder res = new StringBuilder();
        while( i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                res.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else{
                    if(dp[i-1][j] > dp[i][j-1]){
                        res.append(str1.charAt(i-1));
                        i--;
                    }
                    // else if(dp[i-1][j] < dp[i][j-1]){
                    //     res.append(str2.charAt(j-1));
                    //     j--;
                    // }  
                    else {
                        res.append(str2.charAt(j-1)); // or str1.charAt(i-1), both are fine
                        j--;                          // or i--, just make sure it moves
                    }
            }
        }
        while(i > 0) {
            res.append(str1.charAt(i-1));
            i--;
        }
        while(j > 0) {
        res.append(str2.charAt(j-1));
            j--;
        }
        String ans = res.reverse().toString();
        return ans;
    }
}
