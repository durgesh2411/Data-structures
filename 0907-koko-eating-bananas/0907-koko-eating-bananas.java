class Solution {
    public int arrMax(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }

    public int totalHr(int arr[],int hourly){
        int ttlHr=0;
        for(int i=0;i<arr.length;i++){
            ttlHr += Math.ceil((double)arr[i]/(double)hourly);
        }
        return ttlHr;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int high=arrMax(piles);
        int low = 1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int ttlhr = totalHr(piles,mid);
            if(ttlhr<=h){
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}