import java.util.*;
class G1_create{

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis[], ArrayList<Integer> dfs){
        dfs.add(node);
        vis[node] = 1;

        for(int e: adj.get(node)){
            if(vis[e]!=1){
                dfs(e, adj, vis, dfs);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World");

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n= 10;

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(6);
        adj.get(6).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(2).add(4);
        adj.get(4).add(2);

        adj.get(6).add(7);
        adj.get(7).add(6);

        adj.get(6).add(9);
        adj.get(9).add(6);

        adj.get(7).add(8);
        adj.get(8).add(7);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(5).add(8);
        adj.get(8).add(5);


        System.out.println("Adjacency list of vertex ");
        for(int i=0; i<n; i++){
            System.out.print(i +"->");
            for(int e: adj.get(i)){
                System.out.print(e+" ");
            }            
            System.out.println();
        }

        int vis[] = new int[n];

        ArrayList<Integer> bfs = new ArrayList<>();

        // Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();

        q.add(1);
        vis[1] = 1;

        while(!q.isEmpty()){
            int node= q.poll();
            bfs.add(node);

            for(int e: adj.get(node)){
                if(vis[e]!=1){
                    q.add(e);
                    vis[e]= 1;
                }                
            }
        }
        System.out.println(bfs);

        
        ArrayList<Integer> dfs = new ArrayList<>();
        int vis1[] = new int[n];
        dfs(1, adj, vis1, dfs);
        System.out.println(dfs);


    } 
}
