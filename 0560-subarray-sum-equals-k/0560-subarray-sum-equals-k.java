class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int cnt = 0, prefixSum = 0;
        for(int i=0;i<nums.length;i++){
            prefixSum += nums[i];

            if(mp.containsKey(prefixSum - k)){
                cnt += mp.get(prefixSum - k);
            }

            mp.put(prefixSum, mp.getOrDefault(prefixSum,0)+1);

        }
        return cnt;
    }
}