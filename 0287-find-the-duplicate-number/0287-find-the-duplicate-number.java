class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> en : mp.entrySet()){
            if(en.getValue() >= 2) {
                return en.getKey();
            }
        }
        return 0; 
    }
}