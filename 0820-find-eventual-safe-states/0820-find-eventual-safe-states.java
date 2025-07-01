class Solution {
    public boolean dfs(int node, int[][] graph, int[] currPath, boolean[] vis){
        vis[node] = true;
        currPath[node] = 1;
        for(int nbr : graph[node]){
            if(!vis[nbr]){
                boolean res = dfs(nbr, graph, currPath, vis);
                if(res) return true;
                
            }
            else{
                if(currPath[nbr] == 1) return true;
            }
        }
            currPath[node] = 0;
            return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] currPath = new int[N];
        List<Integer> res = new ArrayList<>();
        List<Integer> unsafeNodes = new ArrayList<>();
        boolean vis[] = new boolean[N];
        for(int i=0;i<N;i++){
            if(!vis[i]){
                boolean ans = dfs(i, graph, currPath, vis);
            }
        }

        for(int i=0;i<N;i++){
            if(currPath[i] == 0)
                res.add(i);
        }
        return res;
    }
}