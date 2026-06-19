//dfs approach
class numberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int provinces=0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                provinces++;
                dfs(i, isConnected, visited);
            }
        }
        return provinces;
    }
    void dfs(int node, int[][] isConnected, boolean[] visited){
        visited[node]=true;
        for(int i=0; i<isConnected.length; i++){
            if(isConnected[node][i]==1 && !visited[i]){
                dfs(i, isConnected, visited);
            }
        }
    }
}






//bfs approach
/*
class numberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int provinces=0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            while(!vis[i]){
                provinces++;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i]=true;
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int j=0; j<n; j++){
                        if(isConnected[curr][j]==1 && !vis[j]){
                            vis[j]=true;
                            q.add(j);
                        }
                    }
                }
                
            }
        }
        return provinces;
    }
}
*/
