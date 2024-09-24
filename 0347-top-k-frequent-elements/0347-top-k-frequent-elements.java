class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> countMap = new HashMap<>();
        
        for(int num : nums){
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(
            (a,b) -> a.getValue() - b.getValue()
        );

            for(Map.Entry<Integer,Integer> entry:countMap.entrySet()){
                heap.offer(entry);
                if(heap.size()>k){
                    heap.poll();
                }
            }

            int ans[] = new int[k];
            for(int i=k-1;i>=0;i--){
                ans[i] = heap.poll().getKey();
            }

            return ans;

    }
}