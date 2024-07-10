class Solution {
    public int minBitFlips(int start, int goal) {
        // XOR of start and goal will give the bits that are different
        int xor = start ^ goal;

        // Count the number of set bits in the xor result
        int count = 0;
        while (xor > 0) {
            // Increment count for each set bit
            count += xor & 1;
            // Right shift xor by 1 to check the next bit
            xor >>= 1;
        }
        
        return count;
    }
}