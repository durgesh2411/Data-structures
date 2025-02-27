class Solution {
    public void sortColors(int[] nums) {
        int countZ = 0, countO = 0, countT = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0) countZ++;
            else if(nums[i] == 1) countO++;
            else countT++;
        }

        int currIdx = 0;
        while(countZ-- > 0){
            nums[currIdx] = 0;
            currIdx++;
        }
        System.out.println(currIdx);
        while(countO-- > 0 ){
            nums[currIdx] = 1;
            currIdx++;
        }
        while(countT-- > 0){
            nums[currIdx] = 2;
            currIdx++;
        }
        System.out.println(Arrays.toString(nums));
    }
}