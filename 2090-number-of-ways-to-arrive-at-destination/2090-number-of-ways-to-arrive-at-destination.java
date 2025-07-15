class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road: roads){
            int a = road[0], b = road[1], wt = road[2];
            adj.get(a).add(new int[]{b, wt});
            adj.get(b).add(new int[]{a, wt});
        }

        long[] disT = new long[n];
        Arrays.fill(disT, Long.MAX_VALUE);
        disT[0] = 0;
        
        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong((a) -> a[0]));
        pq.add(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] pair = pq.poll();
            int u = (int)pair[1];
            long time = pair[0];
            if(time > disT[u]) continue;
            for(int[] nbrP : adj.get(u)){
                int v = nbrP[0];
                int extraTfromU = nbrP[1];
                long newTime = time + (long)extraTfromU;
                if(newTime < disT[v]){
                    disT[v] = newTime;
                    ways[v] = ways[u];
                    pq.add(new long[]{newTime, v});
                }
                else if(newTime == disT[v]){
                    ways[v] =(ways[v]+ways[u])% 1_000_000_007;
                }
            }
        }
        return ways[n-1];
    }
}