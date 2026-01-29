//----------------------GFG Variant---------------------
class Solution {
    // Function to find unit area of the largest region of 1s.
    public int calcArea(int grid[][], boolean visited[][], int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
            return 0;
        
        if(visited[i][j] || grid[i][j]==0) return 0;
        visited[i][j]= true;
        
        return 1+ calcArea(grid, visited, i, j+1)
                + calcArea(grid, visited, i+1, j+1)
                + calcArea(grid, visited, i+1, j)
                + calcArea(grid, visited, i+1, j-1)
                + calcArea(grid, visited, i, j-1)
                + calcArea(grid, visited, i-1, j-1)
                + calcArea(grid, visited, i-1, j)
                + calcArea(grid, visited, i-1, j+1);
    }
    public int findMaxArea(int[][] grid) {
        // Code here
        int m= grid.length;
        int n= grid[0].length;
        
        int maxArea=0, area=0;
        boolean vis[][]= new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j] && grid[i][j]==1){
                    area= calcArea(grid, vis, i, j);
                    maxArea= Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }


//---------------LeetCode-------------------
class Solution {
    private int checkArea(int[][] grid, boolean[][] vis, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return 0;

        if(vis[i][j] || grid[i][j]==0) return 0;
        
        vis[i][j]= true;

        return 1+ checkArea(grid, vis, i+1, j)
                + checkArea(grid, vis, i-1, j)
                + checkArea(grid, vis, i, j+1)
                + checkArea(grid, vis, i, j-1); 
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        boolean[][] vis= new boolean[m][n];

        int area=0, maxArea=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j]  && grid[i][j]==1){
                    area= checkArea(grid, vis, i, j);
                    maxArea= Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}

//---------------------without Visisted Array-----------------
class Solution {
    private int checkArea(int[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return 0;

        if(grid[i][j]==0) return 0;
        
        grid[i][j]= 0;

        return 1+ checkArea(grid, i+1, j)
                + checkArea(grid, i-1, j)
                + checkArea(grid, i, j+1)
                + checkArea(grid, i, j-1); 
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        int area=0, maxArea=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    area= checkArea(grid, i, j);
                    maxArea= Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}
}
