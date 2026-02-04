class Solution {
    int numOfIsland=0;
    public void checkArea(char grid[][], int i, int j){

        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length) return ;

        if(grid[i][j]== '0' ) return;

        grid[i][j]='0';

        checkArea(grid, i+1, j); 
        checkArea(grid, i-1, j);
        checkArea(grid, i, j+1);
        checkArea(grid, i, j-1);
        
    }

  // void bcz we need to just traverse cells and mark them as visited only
    public int numIslands(char[][] grid) {
        
        int m= grid.length;
        int n= grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    checkArea(grid, i, j);
                    numOfIsland++;
                }
            }
        }
        return numOfIsland;
    }
}
