class Solution {
    ArrayList<String> ans;
    void path(int maze[][], int i, int j, boolean[][] vis, StringBuilder route){
        
        if(i<0 || i>=maze.length || j<0 || j>=maze[0].length || maze[i][j]==0 ||vis[i][j]) return;

        if(i==maze.length-1 && j==maze.length-1){
            ans.add(route.toString());
            return;
        }
        
        
        vis[i][j]= true;
        
        route.append('D');
        path(maze, i+1, j, vis, route);
        route.deleteCharAt(route.length() - 1);
        
        route.append('L');
        path(maze, i, j-1, vis, route);
        route.deleteCharAt(route.length() - 1);
        
        route.append('R');
        path(maze, i, j+1, vis, route);
        route.deleteCharAt(route.length() - 1);
        
        route.append('U');
        path(maze, i-1, j, vis, route);
        route.deleteCharAt(route.length() - 1);
        
        
        vis[i][j]= false;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ans= new ArrayList<>();
        
        if (maze[0][0] == 0) return ans;

        boolean[][] vis = new boolean[maze.length][maze.length];
        
        path(maze, 0, 0, vis, new StringBuilder());
        
        return ans;
        
    }
}
