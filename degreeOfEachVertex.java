class degreeOfEachVertex {
    public int[] findDegrees(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int count=0;
        int[] res = new int[m];

        for(int i=0; i<m; i++){
            count=0;
            for(int j=0; j<n; j++){
                if(matrix[i][j]==1){
                    count++;
                }
            }
            res[i]=count;
        }
        return res;
    }
}
