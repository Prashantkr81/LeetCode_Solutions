class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();

        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());

        for(int pair[]: prerequisites){
            adj.get(pair[0]).add(pair[1]);
        }

        int indegree[]= new int[numCourses];

        for(int i=0; i<numCourses; i++)
            for(int in: adj.get(i)){
                indegree[in]++;
            }
        
        ArrayDeque<Integer> q= new ArrayDeque<>();

        for(int i=0; i<indegree.length; i++) if(indegree[i] == 0) q.add(i);

        int count =0;

        while(!q.isEmpty()){

            int curr= q.poll();
            count++;

            for(int neigh: adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh] == 0) q.add(neigh);
            }
        }
        return numCourses == count;
    }
}