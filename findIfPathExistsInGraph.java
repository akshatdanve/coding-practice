//dfs approach
class findIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        return dfs (source, destination, adj, visited);
    }

    boolean dfs (int source, int destination, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        if(source==destination){
            return true;
        }
        visited[source] = true;
        for(int neighbour : adj.get(source)){
            if(!visited[neighbour]){
                if(dfs(neighbour, destination, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}

//bfs approach
/*
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            
        }

        
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        vis[source]=true;
        q.add(source);
        while(!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);
            for(int x : adj.get(curr)){
                if(!vis[x]){
                    vis[x]=true;
                    q.add(x);
                }   
            }
        }
        for(int i=0; i<res.size(); i++){
            if(res.get(i)==destination){
                return true;
            }
        }
        return false;
    }
}*/

