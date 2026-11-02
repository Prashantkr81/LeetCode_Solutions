class Solution {
    class pair{
        int row, col, time;
        pair(int x, int y, int t){
            this.row= x;
            this.col= y;
            this.time=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m= grid.length, n = grid[0].length;
        
        ArrayDeque<pair> q= new ArrayDeque<>();

        boolean[][] visited= new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
                if(grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.add(new pair(i,j,0));
                }
        }

        int time = 0;
        int [][] dirn= {
            {0,1},
            {1,0},
            {-1, 0},
            {0, -1}
        };
        
        while(!q.isEmpty()){
            pair curr= q.poll();
            
            time = Math.max(time, curr.time);

            for(int i=0; i<4; i++){
                int nr= curr.row + dirn[i][0];
                int nc= curr.col + dirn[i][1];

                if(nr <0 || nr>= m || nc<0 || nc>= n || visited[nr][nc] || grid[nr][nc] ==0 || grid[nr][nc] == 2) continue;

                else{
                    q.add(new pair(nr, nc, curr.time+1));
                    visited[nr][nc] = true;
                } 
            }

        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !visited[i][j]) return -1;
            }
        }
        return time;
    }
}