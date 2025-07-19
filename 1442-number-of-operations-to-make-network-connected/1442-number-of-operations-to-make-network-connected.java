class Solution {
    public void dfs(int node, List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;
        for(int nbr : adj.get(node)){
            if(!vis[nbr]){
                dfs(nbr, adj, vis);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] connection : connections){
            int a = connection[0], b = connection[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int cnt = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i, adj, vis);
                cnt++;
            }
        }
        return cnt-1;
    }
}