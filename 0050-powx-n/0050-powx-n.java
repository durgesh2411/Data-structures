class Solution {
    public double myPow(double x, int n) {
        double ans = 1.00000;
        double num = n;
        if(num<0){
            x = 1/x;
            num = -num;
        }

        while(num>0){
            if(num%2==0){
                x = x*x;
                num = num/2;
            }
            else{
                ans *= x;
                num = num-1;
            }
        }
        return ans;
    }
}