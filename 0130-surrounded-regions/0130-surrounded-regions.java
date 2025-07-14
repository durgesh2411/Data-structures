class Solution {
    int di[] = {-1,0,1,0};
    int[] dj = {0,1,0,-1};
    int n, m;

    public boolean isValid(int X, int Y){
        if(X<0 || X>=n) return false;
        if(Y<0 || Y>=m) return false;
        return true;
    }
    public void bfs(int X, int Y, char[][] board, int[][] vis){
        vis[X][Y] = 1;
        board[X][Y] = 'S';
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{X,Y});

        while(!q.isEmpty()){
            int[] cord = q.poll();
            int x = cord[0];
            int y = cord[1];
            for(int i=0;i<4;i++){
                int ii = x + di[i];
                int jj = y + dj[i];
                if(isValid(ii, jj) && vis[ii][jj] == 0 && board[ii][jj] == 'O'){
                    vis[ii][jj] = 1;
                    board[ii][jj] = 'S';
                    q.add(new int[]{ii, jj});
                }
            }
        }

    }

    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++){
            if( (vis[i][0] == 0 && board[i][0] == 'O')){
                bfs(i, 0, board, vis);
            }
            if((vis[i][m-1] == 0 && board[i][m-1] == 'O')){
                bfs(i, m-1, board, vis);
            }
        }

        for(int j=0;j<m;j++){
            if(vis[0][j] == 0 && board[0][j] == 'O'){
                bfs(0,j,board, vis);
            }
            if(vis[n-1][j] == 0 && board[n-1][j] == 'O'){
                bfs(n-1, j, board, vis);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }
}