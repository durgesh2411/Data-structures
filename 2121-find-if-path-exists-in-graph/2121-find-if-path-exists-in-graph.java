class Solution {

    public void bfs(int start, List<Integer>[] adj, Set<Integer> vis, int source, int destination, boolean isPath){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis.add(start);
        while(!q.isEmpty()){
            int current = q.poll();
            for(int nbr : adj[current]){
                if(!vis.contains(nbr)){
                    vis.add(nbr);
                    q.add(nbr);
                }
            }
        }
        if(vis.contains(source)){
            if(vis.contains(destination))
                isPath = true;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new ArrayList[n];

        // list is non primitive type( kahali dabbe banneane honge pahle) 
        for(int i=0;i<n;i++) adj[i] = new ArrayList<>();

        for(int[] edge : edges){
            int a  = edge[0];
            int b = edge[1];
            adj[a].add(b);
            adj[b].add(a);
        }
        Set<Integer> vis = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     if(!vis.contains(i)){
        //         vis.add(i);
        //         bfs(i,adj,vis,source, destination, isPath);
        //     }
        // }
    
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis.add(source);
        while(!q.isEmpty()){
            int current = q.poll();
            if(current == destination) return true;
            for(int nbr : adj[current]){
                if(!vis.contains(nbr)){
                    vis.add(nbr);
                    q.add(nbr);
                }
            }
        }
        return false;
    }
}