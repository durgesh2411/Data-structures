class Solution {
    public int lengthOfLongestSubstring(String s) {
        // if(s.length()==0) return 0;
        // Set<Character> set= new HashSet<>();
        // int l=0;
        // int maxLen = Integer.MIN_VALUE;
        // for(int r=0;r<s.length();r++){
        //     if(set.contains(s.charAt(r))){
        //         while(l<r && set.contains(s.charAt(r))){
        //             set.remove(s.charAt(l));
        //             l++;
        //         }
        //     }
        //     set.add(s.charAt(r));
        //     maxLen = Math.max(maxLen,r-l+1);
        // }
        // return maxLen;

        int n = s.length();
        if(n == 0) return 0;
        int l = 0;
        int r = 0;
        int maxlen = Integer.MIN_VALUE;
        int[] hash = new int[256];
        for(int i=0; i<256; i++){
            hash[i] = -1;
        }
        while(r<n){
            if(hash[s.charAt(r)] != -1){
                if(hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)] + 1;
                }
            }
            maxlen = Math.max(maxlen,r-l+1);
            hash[s.charAt(r)] = r;
            r ++;
        } 
            return maxlen;

    }
}