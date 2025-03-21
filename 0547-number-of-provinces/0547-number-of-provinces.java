class Solution {

    public void bfs(int start, Set<Integer> vis, List<List<Integer>> adjList){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        vis.add(start);
        while(!q.isEmpty()){
                int curr = q.poll();
                for(int nextVal : adjList.get(curr)){
                    if(!vis.contains(nextVal)){
                        q.add(nextVal);
                        vis.add(nextVal);
                    }
                }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        int n = isConnected.length, m = isConnected[0].length;
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }    
        } 

        int count = 0;
        for(int i = 0;i<n;i++){
            if(!vis.contains(i)){
                bfs(i, vis, adjList);
                count++;
            }
        }
        return count;
    }
}