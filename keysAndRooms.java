class keysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int cnt=0;
        for(int i=0; i<rooms.size(); i++){
            cnt++;
        }
        boolean[] vis = new boolean[cnt];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int x : rooms.get(curr)){
                if(!vis[x]){
                    vis[x]=true;
                    q.add(x);
                }
            }
        }
        int vis_cnt=0;
        for(int j=0; j<vis.length; j++){
            if(vis[j]){
                vis_cnt++;
            }
            
        }
        if(cnt==vis_cnt){
            return true;
        }
        return false;
    }
}
