class Solution {
    public int divide(int dividend, int divisor) {
        // Checking edge cases:
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            // Handle overflow case
            if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            return -dividend;
        }

        // Taking the flag for sign consideration
        boolean sign = (dividend < 0) == (divisor < 0);

        // Taking the absolute value for calculation
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long quotient = 0;

        // Checking the value till numerator is bigger
        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }
            quotient += (1L << cnt);
            n -= (d << cnt);
        }

        // Handling overflow case
        if (quotient > Integer.MAX_VALUE) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return sign ? (int) quotient : (int) -quotient;
    }
}
