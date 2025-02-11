class Solution {


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; 
        DSU dsu = new DSU(n);
      for (int i = 0; i < n; i++) {
         for (int j = 0; j<n; j++) { // j==nextNode
         if(isConnected[i][j] == 1)
            dsu.union(i, j);
         }
      }
      Set<Integer> count = new HashSet<>(); 
        for(int i = 0; i < dsu.parent.length; i++) {
            count.add(dsu.find(dsu.parent[i]));
        }
        return count.size();
    }

    public class DSU{
    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i=0;i<n;i++) {
            parent[i]=i;
            rank[i]=0;
        }
    }

        public int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        } 

        public void union (int x,int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }
            else if(rank[rootY] > rank[rootX]){
                parent[rootX] = rootY;
            }
            else{
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
        }
    }
}


