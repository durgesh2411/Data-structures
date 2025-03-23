class Solution {
    public void generate(int O, int C, int n, String str, List<String> ans){
        if(O == C && O+C == 2*n){
            ans.add(str);
            return;
        }
        if(O < n) generate(O+1,C,n,str+'(', ans);
        if(C < O) generate(O, C+1, n, str+')', ans);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String str = "";
        generate(0,0,n,str,ans);
        return ans;
    }
}