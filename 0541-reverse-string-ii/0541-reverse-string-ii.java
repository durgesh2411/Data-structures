class Solution {

    public void reverse(char[] str, int f ,int l) {
        while( f < l) {
            char temp = str[f];
            str[f] = str[l];
            str[l] = temp;
            f++;
            l--;
        }
    }
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int n = str.length;
        int i = 0;
        while(i < n) {
            int p = k+i-1;
            if(p <= n-1) {
                reverse(str,i,p);
            }
            else{
                reverse(str,i,n-1);
            }
            i+=2*k;
        }
        return new String(str);
    }
}