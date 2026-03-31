class Solution {
    class node{
        int row; int col; int dis;
        node(int row, int col, int dis){
            this.row= row;
            this.col= col;
            this.dis= dis;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        
        int m= mat.length;
        int n= mat[0].length;

        int ans[][]= new int[m][n];
        boolean visited[][] = new boolean[m][n];

        ArrayDeque<node> q= new ArrayDeque<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new node (i,j, 0));
                    visited[i][j]= true;
                }
            }
        }

        int nrow[]= {-1, 0, +1, 0};
        int ncol[]= {0, -1, 0, +1};

        while(!q.isEmpty()){
            node curr= q.poll();

            int row= curr.row;
            int col= curr.col;
            int step= curr.dis;

            ans[row][col] = step;

            for(int i=0; i<4; i++){
                int nr = row + nrow[i];
                int nc = col + ncol[i];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new node(nr, nc, step + 1));
                }
            }
        }
        return ans;
    }
}
